package hoang.manh.huynh.testskill.outer.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */
@Root(name = "photos")
public class Photos {
    public Photos(){}

    @ElementList(entry = "photo", name = "photo", inline = true, required = false)
    List<Photo> mListPhoto;

    @Attribute(name = "page")
    private String mPage;

    @Attribute(name = "pages")
    private String mPages;

    @Attribute(name = "perpage")
    private String mPerPage;

    @Attribute(name = "total")
    private String mTotal;

    public void setPage(String page) {
        mPage = page;
    }

    public void setPages(String pages) {
        mPages = pages;
    }

    public void setPerPage(String perPage) {
        mPerPage = perPage;
    }

    public void setTotal(String total) {
        mTotal = total;
    }

    public String getPage() {
        return mPage;
    }

    public String getPages() {
        return mPages;
    }

    public String getPerPage() {
        return mPerPage;
    }

    public String getTotal() {
        return mTotal;
    }

    public void setListPhoto(List<Photo> listPhoto) {
        mListPhoto = listPhoto;
    }

    public List<Photo> getListPhoto() {
        return mListPhoto;
    }
}
