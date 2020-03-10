package it.balduzzi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertiesJson {

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