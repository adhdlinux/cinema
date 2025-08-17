package com.original.tase.model.hydrax;

public class StreamXResponse {
    private String hash;
    private String link;
    private boolean status;

    public String getHash() {
        return this.hash;
    }

    public String getLink() {
        return this.link;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }
}
