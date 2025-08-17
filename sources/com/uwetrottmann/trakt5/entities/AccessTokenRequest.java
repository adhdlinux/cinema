package com.uwetrottmann.trakt5.entities;

public class AccessTokenRequest {
    public String client_id;
    public String client_secret;
    public String code;
    public String grant_type = "authorization_code";
    public String redirect_uri;

    public AccessTokenRequest(String str, String str2, String str3, String str4) {
        this.code = str;
        this.client_id = str2;
        this.client_secret = str3;
        this.redirect_uri = str4;
    }
}
