package com.movie.data.model.tmvdb;

import com.google.gson.annotations.SerializedName;

public class PostersItem {
    @SerializedName("aspect_ratio")
    private Object aspectRatio;
    @SerializedName("file_path")
    private String filePath;
    @SerializedName("height")
    private int height;
    @SerializedName("iso_639_1")
    private String iso6391;
    @SerializedName("vote_average")
    private Object voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("width")
    private int width;

    public Object getAspectRatio() {
        return this.aspectRatio;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getHeight() {
        return this.height;
    }

    public String getIso6391() {
        return this.iso6391;
    }

    public Object getVoteAverage() {
        return this.voteAverage;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public int getWidth() {
        return this.width;
    }
}
