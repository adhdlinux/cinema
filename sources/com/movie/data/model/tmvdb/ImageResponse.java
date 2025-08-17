package com.movie.data.model.tmvdb;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ImageResponse {
    @SerializedName("backdrops")
    private List<BackdropsItem> backdrops;
    @SerializedName("id")
    private int id;
    @SerializedName("logos")
    private List<Object> logos;
    @SerializedName("posters")
    private List<PostersItem> posters;

    public List<BackdropsItem> getBackdrops() {
        return this.backdrops;
    }

    public int getId() {
        return this.id;
    }

    public List<Object> getLogos() {
        return this.logos;
    }

    public List<PostersItem> getPosters() {
        return this.posters;
    }
}
