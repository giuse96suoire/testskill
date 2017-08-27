package hoang.manh.huynh.testskill.outer.data;

import hoang.manh.huynh.testskill.outer.data.model.Response;
import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public interface FlickrService {
    @POST(value = "/services/rest/?method=flickr.photos.getRecent&api_key=0963e3b44f25e5afb0f17650a3a1722a&content_type =1&per_page =10")
    Call<Response> getImagesJson();
}
