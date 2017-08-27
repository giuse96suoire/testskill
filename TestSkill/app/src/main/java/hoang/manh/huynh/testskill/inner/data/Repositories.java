package hoang.manh.huynh.testskill.inner.data;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public interface Repositories {
    interface ImageRepository {
        void getImagesJson(LoadDataCallback callback);
    }
    interface LoadDataCallback<T> {
        void onSuccess(T response);
        void onError(Throwable error);
    }
}
