package it.balduzzi.model.publication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Data implements Serializable {

    @SerializedName("startIndex")
    @Expose
    private Integer startIndex;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("itemsPerPage")
    @Expose
    private Integer itemsPerPage;
    @SerializedName("itemsCount")
    @Expose
    private Integer itemsCount;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("prevPage")
    @Expose
    private Object prevPage;
    @SerializedName("nextPage")
    @Expose
    private Object nextPage;
    @SerializedName("itemsType")
    @Expose
    private String itemsType;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Object getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Object prevPage) {
        this.prevPage = prevPage;
    }

    public Object getNextPage() {
        return nextPage;
    }

    public void setNextPage(Object nextPage) {
        this.nextPage = nextPage;
    }

    public String getItemsType() {
        return itemsType;
    }

    public void setItemsType(String itemsType) {
        this.itemsType = itemsType;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}






