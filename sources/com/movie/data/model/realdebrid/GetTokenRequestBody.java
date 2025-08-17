package com.movie.data.model.realdebrid;

public class GetTokenRequestBody {
    String client_id;
    String client_secret;
    String code;
    String grant_type;

    public String getClient_id() {
        return this.client_id;
    }

    public String getClient_secret() {
        return this.client_secret;
    }

    public String getCode() {
        return this.code;
    }

    public String getGrant_type() {
        return this.grant_type;
    }

    public void setClient_id(String str) {
        this.client_id = str;
    }

    public void setClient_secret(String str) {
        this.client_secret = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setGrant_type(String str) {
        this.grant_type = str;
    }
}
