package hoang.manh.huynh.testskill.outer.ui.activity.main;

import android.util.Log;

import java.util.List;

import hoang.manh.huynh.testskill.inner.data.Image;
import hoang.manh.huynh.testskill.inner.data.Repositories;
import hoang.manh.huynh.testskill.middle.ImageConverter;
import hoang.manh.huynh.testskill.outer.data.ImageRepository;
import hoang.manh.huynh.testskill.outer.data.model.Response;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void loadImages() {
        mView.showLoading();
        Repositories.ImageRepository imageRepository = new ImageRepository();
        Repositories.LoadDataCallback<Response> callback = new Repositories.LoadDataCallback<Response>() {
            @Override
            public void onSuccess(Response response) {
                Repositories.LoadDataCallback<List<Image>> convertCallback = new Repositories.LoadDataCallback<List<Image>>() {
                    @Override
                    public void onSuccess(List<Image> response) {
                        mView.dismissLoading();
                        mView.loadImagesToUi(response);
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                };
                ImageConverter imageConverter = new ImageConverter(convertCallback);
                imageConverter.execute(new Response[]{response});
            }

            @Override
            public void onError(Throwable error) {
                Log.d("xxx", error.getMessage());
            }
        };
        imageRepository.getImagesJson(callback);
    }
}
