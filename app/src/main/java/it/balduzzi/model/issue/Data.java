package it.balduzzi.model.issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @SerializedName("startIndex")
    @Expose
    private float startIndex;
    @SerializedName("totalItems")
    @Expose
    private float totalItems;
    @SerializedName("itemsPerPage")
    @Expose
    private float itemsPerPage;
    @SerializedName("itemsCount")
    @Expose
    private float itemsCount;
    @SerializedName("timestamp")
    @Expose
    private float timestamp;
    @SerializedName("prevPage")
    @Expose
    private String prevPage = null;
    @SerializedName("nextPage")
    @Expose
    private String nextPage = null;
    @SerializedName("itemsType")
    @Expose
    private String itemsType;
    @SerializedName("items")
    @Expose
    ArrayList< ItemIssue > items = new ArrayList < ItemIssue > ();

    public float getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(float startIndex) {
        this.startIndex = startIndex;
    }

    public float getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(float totalItems) {
        this.totalItems = totalItems;
    }

    public float getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(float itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public float getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(float itemsCount) {
        this.itemsCount = itemsCount;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public String getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(String prevPage) {
        this.prevPage = prevPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public String getItemsType() {
        return itemsType;
    }

    public void setItemsType(String itemsType) {
        this.itemsType = itemsType;
    }

    public ArrayList<ItemIssue> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemIssue> items) {
        this.items = items;
    }
}