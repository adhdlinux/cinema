package com.utils.subtitle.services.openSubtitle.models;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class LoginResponse {
    @SerializedName("base_url")
    private final String base_url;
    @SerializedName("status")
    private final int status;
    @SerializedName("token")
    private final String token;
    @SerializedName("user")
    private final User user;

    public LoginResponse(String str, int i2, String str2, User user2) {
        Intrinsics.f(str, "base_url");
        Intrinsics.f(str2, "token");
        Intrinsics.f(user2, "user");
        this.base_url = str;
        this.status = i2;
        this.token = str2;
        this.user = user2;
    }

    public static /* synthetic */ LoginResponse copy$default(LoginResponse loginResponse, String str, int i2, String str2, User user2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = loginResponse.base_url;
        }
        if ((i3 & 2) != 0) {
            i2 = loginResponse.status;
        }
        if ((i3 & 4) != 0) {
            str2 = loginResponse.token;
        }
        if ((i3 & 8) != 0) {
            user2 = loginResponse.user;
        }
        return loginResponse.copy(str, i2, str2, user2);
    }

    public final String component1() {
        return this.base_url;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.token;
    }

    public final User component4() {
        return this.user;
    }

    public final LoginResponse copy(String str, int i2, String str2, User user2) {
        Intrinsics.f(str, "base_url");
        Intrinsics.f(str2, "token");
        Intrinsics.f(user2, "user");
        return new LoginResponse(str, i2, str2, user2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResponse)) {
            return false;
        }
        LoginResponse loginResponse = (LoginResponse) obj;
        return Intrinsics.a(this.base_url, loginResponse.base_url) && this.status == loginResponse.status && Intrinsics.a(this.token, loginResponse.token) && Intrinsics.a(this.user, loginResponse.user);
    }

    public final String getBase_url() {
        return this.base_url;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getToken() {
        return this.token;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return (((((this.base_url.hashCode() * 31) + this.status) * 31) + this.token.hashCode()) * 31) + this.user.hashCode();
    }

    public String toString() {
        return "LoginResponse(base_url=" + this.base_url + ", status=" + this.status + ", token=" + this.token + ", user=" + this.user + ')';
    }
}
