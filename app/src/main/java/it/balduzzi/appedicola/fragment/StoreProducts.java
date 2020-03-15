package it.balduzzi.appedicola.fragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreProducts {

    @SerializedName("appstore")
    @Expose
    private AppStore appstore;

    @SerializedName("googleplay")
    @Expose
    private GooglePlay googleplay;

    public AppStore getAppstore() {
        return appstore;
    }

    public void setAppstore(AppStore appstore) {
        this.appstore = appstore;
    }

    public GooglePlay getGoogleplay() {
        return googleplay;
    }

    public void setGoogleplay(GooglePlay googleplay) {
        this.googleplay = googleplay;
    }
}
