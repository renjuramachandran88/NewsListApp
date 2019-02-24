package com.globaldex.newlistapp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by renjumenon on 20/02/19.
 */
public class NewsListEntity {
    @SerializedName("copyright")
    @Expose
    private String copyright;

    @SerializedName("results")
    @Expose
    private List<ResultsEntity> results;

    @SerializedName("num_results")
    @Expose
    private String num_results;

    @SerializedName("status")
    @Expose
    private String status;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public String getNum_results() {
        return num_results;
    }

    public void setNum_results(String num_results) {
        this.num_results = num_results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
