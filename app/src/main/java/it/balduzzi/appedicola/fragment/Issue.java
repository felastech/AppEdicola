package it.balduzzi.appedicola.fragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issue {
    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("data")
    @Expose
    private Data data;


    // Getter Methods

    public boolean getError() {
        return error;
    }

    public String getMethod() {
        return method;
    }

    public Data getData() {
        return data;
    }

    // Setter Methods

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setData(Data dataObject) {
        this.data = dataObject;
    }
}
