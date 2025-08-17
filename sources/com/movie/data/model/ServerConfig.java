package com.movie.data.model;

import com.google.gson.annotations.Expose;
import com.utils.PrefUtils;
import com.utils.Utils;

public class ServerConfig {
    @Expose
    private boolean in_review;
    @Expose
    private boolean is_active;
    @Expose
    private String poster_base_url;
    @Expose
    private String server_url = null;

    public ServerConfig() {
        String f2 = PrefUtils.f(Utils.v());
        this.server_url = f2;
        if (f2.isEmpty()) {
            this.server_url = Utils.Y();
        }
    }

    public String getServer_url() {
        String str = this.server_url;
        if (str == null || str.isEmpty()) {
            this.server_url = Utils.Y();
        }
        return this.server_url;
    }

    public boolean isIn_review() {
        return this.in_review;
    }

    public boolean is_active() {
        return this.is_active;
    }

    public void setServer_url(String str) {
        this.server_url = str;
    }

    public String toString() {
        return this.server_url + this.in_review + this.is_active;
    }
}
