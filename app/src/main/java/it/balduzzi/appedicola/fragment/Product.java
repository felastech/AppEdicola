package it.balduzzi.appedicola.fragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {


    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("projectId")
    @Expose
    private String projectId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("generated")
    @Expose
    private String generated;
    @SerializedName("updatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("deletedOn")
    @Expose
    private String deletedOn;
    @SerializedName("sortingPosition")
    @Expose
    private String sortingPosition;
    @SerializedName("isHidden")
    @Expose
    private boolean isHidden;

    @SerializedName("validOn")
    @Expose
    private ValidOn validOn;

    @SerializedName("storeProducts")
    @Expose
    private StoreProducts storeProducts;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated;
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

    public String getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(String deletedOn) {
        this.deletedOn = deletedOn;
    }

    public String getSortingPosition() {
        return sortingPosition;
    }

    public void setSortingPosition(String sortingPosition) {
        this.sortingPosition = sortingPosition;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public ValidOn getValidOn() {
        return validOn;
    }

    public void setValidOn(ValidOn validOn) {
        this.validOn = validOn;
    }

    public StoreProducts getStoreProducts() {
        return storeProducts;
    }

    public void setStoreProducts(StoreProducts storeProducts) {
        this.storeProducts = storeProducts;
    }
}
