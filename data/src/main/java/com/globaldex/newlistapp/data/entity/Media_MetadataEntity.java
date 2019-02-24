package com.globaldex.newlistapp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by renjumenon on 20/02/19.
 */
public class Media_MetadataEntity {
    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("height")
    @Expose
    private int height;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
