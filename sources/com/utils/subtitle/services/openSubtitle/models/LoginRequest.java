package com.utils.subtitle.services.openSubtitle.models;

import com.applovin.sdk.AppLovinEventParameters;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class LoginRequest {
    @SerializedName("password")
    private final String password;
    @SerializedName("username")
    private final String username;

    public LoginRequest(String str, String str2) {
        Intrinsics.f(str, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
        Intrinsics.f(str2, "password");
        this.username = str;
        this.password = str2;
    }

    public static /* synthetic */ LoginRequest copy$default(LoginRequest loginRequest, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loginRequest.username;
        }
        if ((i2 & 2) != 0) {
            str2 = loginRequest.password;
        }
        return loginRequest.copy(str, str2);
    }

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.password;
    }

    public final LoginRequest copy(String str, String str2) {
        Intrinsics.f(str, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
        Intrinsics.f(str2, "password");
        return new LoginRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginRequest)) {
            return false;
        }
        LoginRequest loginRequest = (LoginRequest) obj;
        return Intrinsics.a(this.username, loginRequest.username) && Intrinsics.a(this.password, loginRequest.password);
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (this.username.hashCode() * 31) + this.password.hashCode();
    }

    public String toString() {
        return "LoginRequest(username=" + this.username + ", password=" + this.password + ')';
    }
}
