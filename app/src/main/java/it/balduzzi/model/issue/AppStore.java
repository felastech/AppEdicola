package it.balduzzi.model.issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppStore {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("productId")
    @Expose
    private int productId;

    @SerializedName("storeType")
    @Expose
    private String storeType;
    @SerializedName("storeProductId")
    @Expose
    private String storeProductId;

    @SerializedName("priceTier")
    @Expose
    private int priceTier;
    @SerializedName("updatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("prices")
    @Expose
    private List<Object> prices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(String storeProductId) {
        this.storeProductId = storeProductId;
    }

    public int getPriceTier() {
        return priceTier;
    }

    public void setPriceTier(int priceTier) {
        this.priceTier = priceTier;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public List<Object> getPrices() {
        return prices;
    }

    public void setPrices(List<Object> prices) {
        this.prices = prices;
    }
}
