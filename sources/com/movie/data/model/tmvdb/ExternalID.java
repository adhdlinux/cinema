package com.movie.data.model.tmvdb;

public class ExternalID {
    private String facebook_id;
    private String freebase_id;
    private String freebase_mid;
    private int id;
    private String imdb_id;
    private String instagram_id;
    private int tvdb_id;
    private int tvrage_id;
    private String twitter_id;

    public String getFacebook_id() {
        return this.facebook_id;
    }

    public String getFreebase_id() {
        return this.freebase_id;
    }

    public String getFreebase_mid() {
        return this.freebase_mid;
    }

    public int getId() {
        return this.id;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public String getInstagram_id() {
        return this.instagram_id;
    }

    public int getTvdb_id() {
        return this.tvdb_id;
    }

    public int getTvrage_id() {
        return this.tvrage_id;
    }

    public String getTwitter_id() {
        return this.twitter_id;
    }

    public void setFacebook_id(String str) {
        this.facebook_id = str;
    }

    public void setFreebase_id(String str) {
        this.freebase_id = str;
    }

    public void setFreebase_mid(String str) {
        this.freebase_mid = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public void setInstagram_id(String str) {
        this.instagram_id = str;
    }

    public void setTvdb_id(int i2) {
        this.tvdb_id = i2;
    }

    public void setTvrage_id(int i2) {
        this.tvrage_id = i2;
    }

    public void setTwitter_id(String str) {
        this.twitter_id = str;
    }
}
