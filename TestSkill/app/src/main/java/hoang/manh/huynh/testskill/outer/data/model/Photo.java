package hoang.manh.huynh.testskill.outer.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */
@Root(name = "photo")
public class Photo {
    public Photo(){}
    @Attribute(name = "id")
    private String mId;

    @Attribute(name = "owner")
    private String mOwner;

    @Attribute(name = "secret")
    private String mSecret;

    @Attribute(name = "server")
    private String mServer;

    @Attribute(name = "farm")
    private String mFarm;

    @Attribute(name = "title")
    private String mTitle;

    @Attribute(name = "ispublic")
    private String mIspublic;

    @Attribute(name = "isfriend")
    private String mIsFriend;

    @Attribute(name = "isfamily")
    private String mIsFamily;

    public void setId(String id) {
        mId = id;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public void setSecret(String secret) {
        mSecret = secret;
    }

    public void setServer(String server) {
        mServer = server;
    }

    public void setFarm(String farm) {
        mFarm = farm;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setIspublic(String ispublic) {
        mIspublic = ispublic;
    }

    public void setIsFriend(String isFriend) {
        mIsFriend = isFriend;
    }

    public void setIsFamily(String isFamily) {
        mIsFamily = isFamily;
    }

    public String getId() {
        return mId;
    }

    public String getOwner() {
        return mOwner;
    }

    public String getSecret() {
        return mSecret;
    }

    public String getServer() {
        return mServer;
    }

    public String getFarm() {
        return mFarm;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getIspublic() {
        return mIspublic;
    }

    public String getIsFriend() {
        return mIsFriend;
    }

    public String getIsFamily() {
        return mIsFamily;
    }
}
