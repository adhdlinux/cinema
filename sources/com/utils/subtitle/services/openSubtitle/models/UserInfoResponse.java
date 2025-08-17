package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class UserInfoResponse {
    private final User data;

    public UserInfoResponse(User user) {
        Intrinsics.f(user, "data");
        this.data = user;
    }

    public static /* synthetic */ UserInfoResponse copy$default(UserInfoResponse userInfoResponse, User user, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            user = userInfoResponse.data;
        }
        return userInfoResponse.copy(user);
    }

    public final User component1() {
        return this.data;
    }

    public final UserInfoResponse copy(User user) {
        Intrinsics.f(user, "data");
        return new UserInfoResponse(user);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserInfoResponse) && Intrinsics.a(this.data, ((UserInfoResponse) obj).data);
    }

    public final User getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "UserInfoResponse(data=" + this.data + ')';
    }
}
