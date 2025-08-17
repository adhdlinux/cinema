package com.original.tase.model.debrid.realdebrid;

public class RealDebridGetTokenResult {
    private String access_token;
    private int expires_in;
    private String last_clientID;
    private String last_clientSecret;
    private String refresh_token;
    private String token_type;

    public String getAccess_token() {
        return this.access_token;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getLast_clientID() {
        return this.last_clientID;
    }

    public String getLast_clientSecret() {
        return this.last_clientSecret;
    }

    public String getRefresh_token() {
        return this.refresh_token;
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

    public void setLast_clientID(String str) {
        this.last_clientID = str;
    }

    public void setLast_clientSecret(String str) {
        this.last_clientSecret = str;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }
}
