package hoang.manh.huynh.testskill.outer.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */
@Root(name = "rps", strict = false)
public class Response {
    @Attribute(name = "stat")
    private String mState;
    @Element(name = "photos")
    private Photos mPhotos;
    public Response(){}
    public void setState(String state) {
        mState = state;
    }

    public void setPhotos(Photos photos) {
        mPhotos = photos;
    }

    public String getState() {
        return mState;
    }

    public Photos getPhotos() {
        return mPhotos;
    }
}
