package hoang.manh.huynh.testskill.inner.data;

/**
 * Created by Manh Hoang Huynh on 26/08/2017.
 */

public class Image {
    private String mId;
    private String mFarmId;
    private String mServerId;
    private String mSecret;
    private String mSize = "c";
    private String mUrl;

    public Image(String id, String farmId, String serverId, String secret, String size) {
        mId = id;
        mFarmId = farmId;
        mServerId = serverId;
        mSecret = secret;
        mSize = size;
    }

    public String getUrl() {
        if (mUrl == null || mUrl.length() == 0) {
            mUrl = "https://farm"+mFarmId+".staticflickr.com/"+mServerId+"/"+mId+"_"+mSecret+"_"+mSize+".jpg";
        }
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setFarmId(String farmId) {
        mFarmId = farmId;
    }

    public void setServerId(String serverId) {
        mServerId = serverId;
    }

    public void setSecret(String secret) {
        mSecret = secret;
    }

    public void setSize(String size) {
        mSize = size;
    }

    public String getId() {
        return mId;
    }

    public String getFarmId() {
        return mFarmId;
    }

    public String getServerId() {
        return mServerId;
    }

    public String getSecret() {
        return mSecret;
    }

    public String getSize() {
        return mSize;
    }
}
