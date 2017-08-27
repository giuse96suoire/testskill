package hoang.manh.huynh.testskill.outer.ui.activity.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import hoang.manh.huynh.testskill.R;
import hoang.manh.huynh.testskill.inner.data.Image;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Image> mListImage;
    public GridViewAdapter(Context c, List<Image> listImage) {
        mContext = c;
        mListImage = listImage;
    }
    @Override
    public int getCount() {
        return mListImage.size();
    }
    @Override
    public Image getItem(int position) {
        return mListImage.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        Glide.with(mContext)
                .load(mListImage.get(position).getUrl())
                .into(imageView);
        imageView.setImageResource(R.drawable.img_placeholder);
        return imageView;
    }


}
