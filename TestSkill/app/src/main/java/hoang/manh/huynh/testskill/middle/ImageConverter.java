package hoang.manh.huynh.testskill.middle;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import hoang.manh.huynh.testskill.inner.data.Image;
import hoang.manh.huynh.testskill.inner.data.Repositories;
import hoang.manh.huynh.testskill.outer.data.model.Photo;
import hoang.manh.huynh.testskill.outer.data.model.Response;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public class ImageConverter extends AsyncTask<Response, Void, List<Image>> {
    private Repositories.LoadDataCallback<List<Image>> mCallback;

    public ImageConverter(Repositories.LoadDataCallback<List<Image>> callback) {
        this.mCallback = callback;
    }

    @Override
    protected List<Image> doInBackground(Response... responses) {
        Response response = responses[0];
        List<Image> result = new ArrayList<>();
        if (response != null) {
            List<Photo> listPhoto = response.getPhotos().getListPhoto();
            if (listPhoto.size() != 0) {
                result = new ArrayList<>();
                for (Photo p : listPhoto) {
                    Image image = new Image(p.getId(), p.getFarm(), p.getServer(), p.getSecret(), "m");
                    result.add(image);
                }
            }

        }
        return result;
    }

    @Override
    protected void onPostExecute(List<Image> images) {
        super.onPostExecute(images);
        mCallback.onSuccess(images);
    }
}
