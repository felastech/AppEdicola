package it.balduzzi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stores {

    @SerializedName("googlePlayDefaultPriceTier")
    @Expose
    private Object googlePlayDefaultPriceTier;
    @SerializedName("appStoreDefaultPriceTier")
    @Expose
    private Object appStoreDefaultPriceTier;

    public Object getGooglePlayDefaultPriceTier() {
        return googlePlayDefaultPriceTier;
    }

    public void setGooglePlayDefaultPriceTier(Object googlePlayDefaultPriceTier) {
        this.googlePlayDefaultPriceTier = googlePlayDefaultPriceTier;
    }

    public Object getAppStoreDefaultPriceTier() {
        return appStoreDefaultPriceTier;
    }

    public void setAppStoreDefaultPriceTier(Object appStoreDefaultPriceTier) {
        this.appStoreDefaultPriceTier = appStoreDefaultPriceTier;
    }
}