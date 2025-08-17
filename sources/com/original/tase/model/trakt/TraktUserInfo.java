package com.original.tase.model.trakt;

import com.google.gson.annotations.SerializedName;

public class TraktUserInfo {
    private dsBean ids;
    private Object name;
    @SerializedName("private")
    private boolean privateX;
    private String username;
    private boolean vip;
    private boolean vip_ep;

    public class dsBean {
        private String slug;

        public dsBean() {
        }

        public String getSlug() {
            return this.slug;
        }

        public void setSlug(String str) {
            this.slug = str;
        }
    }

    public dsBean getIds() {
        return this.ids;
    }

    public Object getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isPrivateX() {
        return this.privateX;
    }

    public boolean isVip() {
        return this.vip;
    }

    public boolean isVip_ep() {
        return this.vip_ep;
    }

    public void setIds(dsBean dsbean) {
        this.ids = dsbean;
    }

    public void setName(Object obj) {
        this.name = obj;
    }

    public void setPrivateX(boolean z2) {
        this.privateX = z2;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setVip(boolean z2) {
        this.vip = z2;
    }

    public void setVip_ep(boolean z2) {
        this.vip_ep = z2;
    }
}
