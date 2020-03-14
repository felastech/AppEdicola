package it.balduzzi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OutputPublications implements Serializable {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
