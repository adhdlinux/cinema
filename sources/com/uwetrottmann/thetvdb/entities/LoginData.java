package com.uwetrottmann.thetvdb.entities;

public class LoginData {
    public String apikey;
    public String username;
    public String userpass;

    public LoginData(String str) {
        this.apikey = str;
    }

    public LoginData user(String str, String str2) {
        this.username = str;
        this.userpass = str2;
        return this;
    }
}
