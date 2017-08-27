package hoang.manh.huynh.testskill.outer.ui.activity.main;

import java.util.List;

import hoang.manh.huynh.testskill.inner.data.Image;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public interface MainContract {
    interface Presenter{
        void loadImages();
    }
    interface View{
        void loadImagesToUi(List<Image> listImage);
        void showErrorMessage();
        void showLoading();
        void dismissLoading();
    }
}
