package it.balduzzi.model.publication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PropertiesJson implements Serializable {

    @SerializedName("stores")
    @Expose
    private Stores stores;
    @SerializedName("products")
    @Expose
    private Products products;

    public Stores getStores() {
        return stores;
    }

    public void setStores(Stores stores) {
        this.stores = stores;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

}