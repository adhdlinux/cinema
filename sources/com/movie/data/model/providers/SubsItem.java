package com.movie.data.model.providers;

import com.google.gson.annotations.SerializedName;

public class SubsItem {
    @SerializedName("file")
    private String file;
    @SerializedName("label")
    private String label;

    public String getFile() {
        return this.file;
    }

    public String getLabel() {
        return this.label;
    }
}
