package com.globaldex.newlistapp.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("num_results")
    @Expose
    public int num_results;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private T results;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }



    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", copyright='" + copyright + '\'' +
                ", results='" + results + '\'' +
                ", num_results=" + num_results +
                '}';
    }
}


