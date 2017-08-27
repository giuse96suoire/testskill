package hoang.manh.huynh.testskill.outer.ui.activity.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import hoang.manh.huynh.testskill.R;
import hoang.manh.huynh.testskill.inner.data.Image;

/**
 * @since 27/08/2017
 * @author Manh Hoang Huynh
 * MainActivity implement View (MVP)
 * I don't implement bottom navigate and some feature (show dialog error if load data failed,
 * stop slide each item if user slide manual because I have to finish my project at C9 to release
 * If you want, I can do it later, more smooth, more beauty,...
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;
    private RecyclerView mRvTopListImage;
    private MainTopImageAdapter mMainTopImageAdapter;
    private List<Image> mListImageData;
    private GridView mGvMoreImages;
    private ImageView mIvUserAvatar;
    private ImageView mIvUserBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter = new MainPresenter(this);
        mPresenter.loadImages();
    }

    private GridViewAdapter mGridViewAdapter;

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mIvUserAvatar = (ImageView) findViewById(R.id.iv_avatar);
        mIvUserBanner = (ImageView) findViewById(R.id.iv_banner);

        mListImageData = new ArrayList<>();

        mGvMoreImages = (GridView) findViewById(R.id.gv_more_image);
        mGridViewAdapter = new GridViewAdapter(this, mListImageData);
        mGvMoreImages.setAdapter(mGridViewAdapter);


        mMainTopImageAdapter = new MainTopImageAdapter(mListImageData, this);
        mRvTopListImage = (RecyclerView) findViewById(R.id.rl_top_list_image);
        mRvTopListImage.setHasFixedSize(true);
        mRvTopListImage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRvTopListImage.setAdapter(mMainTopImageAdapter);


        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle(getString(R.string.progress_dialog_title));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void loadImagesToUi(List<Image> listImage) {
        mListImageData.clear();
        mListImageData.addAll(listImage);

        mMainTopImageAdapter.notifyDataSetChanged();
        mGridViewAdapter.notifyDataSetChanged();

        loadUserImage();

        startSlideEachItemPerSecond();

        //TODO: remove it if finish, just use for debug
        for (Image i : listImage) {
            Log.d("xxx", i.getUrl());
        }
    }

    /**
     * @since 27/08/2017
     * @author Manh Hoang Huynh
     * load user avatar & user banner
     */
    private void loadUserImage() {
        Glide.with(this)
                .load(mListImageData.get(0).getUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(mIvUserAvatar);
        Glide.with(this)
                .load(mListImageData.get(1).getUrl())
                .into(mIvUserBanner);
    }

    @Override
    public void showErrorMessage() {
        // show error dialog if load data error (time out, no internet access,...
    }

    /**
     * @since 27/08/2017
     * @author Manh Hoang Huynh
     * start slide each image per second, because time not enough (I have to OT for current project
     * at C9), so I don't handle for more smooth & beauty. Ex: add animation for scroll,
     * pause scroll when user touch..
     */
    private void startSlideEachItemPerSecond() {
        final Handler handler = new Handler();
        final Runnable runnale = new Runnable() {
            @Override
            public void run() {
                mRvTopListImage.smoothScrollToPosition(mMainTopImageAdapter.getCurrentIndex());
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnale, 1000);
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.show();
    }

    @Override
    public void dismissLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };
}
