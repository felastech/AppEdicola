package it.balduzzi.model.publication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Products implements Serializable {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("consumable")
    @Expose
    private Integer consumable;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getConsumable() {
        return consumable;
    }

    public void setConsumable(Integer consumable) {
        this.consumable = consumable;
    }
}