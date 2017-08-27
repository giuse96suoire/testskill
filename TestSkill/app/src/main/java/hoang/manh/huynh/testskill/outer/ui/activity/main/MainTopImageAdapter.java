package hoang.manh.huynh.testskill.outer.ui.activity.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import hoang.manh.huynh.testskill.R;
import hoang.manh.huynh.testskill.inner.data.Image;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public class MainTopImageAdapter extends RecyclerView.Adapter<MainTopImageAdapter.ViewHolder> {

    private List<Image> mListImage;
    private Context mContext;
    private int mCurrentIndex = 0;

    public MainTopImageAdapter(List<Image> listImage, Context context) {
        this.mListImage = listImage;
        this.mContext = context;
    }

    public int getCurrentIndex() {
        if (mCurrentIndex == mListImage.size() - 1) {
            mCurrentIndex = 0;
        }
        return ++mCurrentIndex;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_image_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Image image = mListImage.get(position);
        Glide.with(mContext)
                .applyDefaultRequestOptions(
                        new RequestOptions()
                                .override(holder.mImageView.getWidth(),holder.mImageView.getHeight())
                        .centerCrop()
                )
                .load(image.getUrl())
                .into(holder.mImageView);
    }


    @Override
    public int getItemCount() {
        return mListImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_top_image_title);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
