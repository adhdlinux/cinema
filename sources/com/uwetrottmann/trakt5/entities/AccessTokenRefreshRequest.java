package com.uwetrottmann.trakt5.entities;

public class AccessTokenRefreshRequest {
    public String client_id;
    public String client_secret;
    public String grant_type = "refresh_token";
    public String redirect_uri;
    public String refresh_token;

    public AccessTokenRefreshRequest(String str, String str2, String str3, String str4) {
        this.refresh_token = str;
        this.client_id = str2;
        this.client_secret = str3;
        this.redirect_uri = str4;
    }
}
