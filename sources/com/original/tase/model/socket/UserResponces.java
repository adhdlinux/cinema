package com.original.tase.model.socket;

import com.google.gson.Gson;

public class UserResponces {
    public static final int USER_RESPONCE_FAIL = 404;
    public static final int USER_RESPONCE_SUCCSES = 200;
    public int code;
    public String messge;

    public UserResponces(int i2, String str) {
        this.code = i2;
        this.messge = str;
    }

    public String toJson(UserResponces userResponces) {
        return new Gson().u(userResponces);
    }

    public UserResponces toObject(String str) {
        return (UserResponces) new Gson().l(str, UserResponces.class);
    }

    public String toJson() {
        return new Gson().u(this);
    }
}
