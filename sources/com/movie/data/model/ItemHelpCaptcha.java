package com.movie.data.model;

public class ItemHelpCaptcha {
    private String link;
    private String providerName;

    public ItemHelpCaptcha(String str, String str2) {
        this.providerName = str;
        this.link = str2;
    }

    public String getLink() {
        return this.link;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }
}
