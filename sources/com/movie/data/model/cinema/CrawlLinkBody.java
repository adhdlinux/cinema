package com.movie.data.model.cinema;

public class CrawlLinkBody {
    private String createdAt;
    private String host;
    private String link;
    private String quality;
    private String releaseDate;
    private long size;
    private long tmdbID;

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getHost() {
        return this.host;
    }

    public String getLink() {
        return this.link;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public long getSize() {
        return this.size;
    }

    public long getTmdbID() {
        return this.tmdbID;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public void setTmdbID(long j2) {
        this.tmdbID = j2;
    }
}
