package com.movie.data.model.realdebrid;

public class UnRestrictCheckObject {
    private String filename;
    private long filesize;
    private String host;
    private String link;
    private int supported;

    public String getFilename() {
        return this.filename;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public String getHost() {
        return this.host;
    }

    public String getLink() {
        return this.link;
    }

    public int getSupported() {
        return this.supported;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setFilesize(long j2) {
        this.filesize = j2;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setSupported(int i2) {
        this.supported = i2;
    }
}
