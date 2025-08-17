package com.movie.data.model.premiumize;

import java.util.List;

public class Cache {
    private List<String> filename;
    private List<String> filesize;
    private List<Boolean> response;
    private String status;
    private List<Boolean> transcoded;

    public List<String> getFilename() {
        return this.filename;
    }

    public List<String> getFilesize() {
        return this.filesize;
    }

    public List<Boolean> getResponse() {
        return this.response;
    }

    public String getStatus() {
        return this.status;
    }

    public List<Boolean> getTranscoded() {
        return this.transcoded;
    }

    public void setFilename(List<String> list) {
        this.filename = list;
    }

    public void setFilesize(List<String> list) {
        this.filesize = list;
    }

    public void setResponse(List<Boolean> list) {
        this.response = list;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTranscoded(List<Boolean> list) {
        this.transcoded = list;
    }
}
