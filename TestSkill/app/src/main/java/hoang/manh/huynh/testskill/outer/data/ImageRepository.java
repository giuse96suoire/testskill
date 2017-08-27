package hoang.manh.huynh.testskill.outer.data;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import hoang.manh.huynh.testskill.inner.data.Repositories;
import hoang.manh.huynh.testskill.outer.data.model.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public class ImageRepository implements Repositories.ImageRepository {

    public ImageRepository() {
    }

    @Override
    public void getImagesJson(final Repositories.LoadDataCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.FLICKR_API_URL)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())
                ))
                .build();
        FlickrService flickrService = retrofit.create(FlickrService.class);
        Call<Response> response = flickrService.getImagesJson();
        response.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response rsp = response.body();
                callback.onSuccess(rsp);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                callback.onError(t);
            }
        });
    }


}
