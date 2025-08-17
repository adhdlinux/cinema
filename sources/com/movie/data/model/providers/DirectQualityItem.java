package com.movie.data.model.providers;

import com.google.gson.annotations.SerializedName;

public class DirectQualityItem {
    @SerializedName("file")
    private String file;
    @SerializedName("quality")
    private int quality;

    public String getFile() {
        return this.file;
    }

    public int getQuality() {
        return this.quality;
    }
}
