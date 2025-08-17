package com.original.tase.model.trakt;

public class TraktGetTokenResult {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;

    public String getAccess_token() {
        return this.access_token;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public String getScope() {
        return this.scope;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setExpires_in(int i2) {
        this.expires_in = i2;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }
}
