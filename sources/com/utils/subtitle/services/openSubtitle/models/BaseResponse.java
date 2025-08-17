package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class BaseResponse {
    private final String message;
    private final int status;

    public BaseResponse(String str, int i2) {
        Intrinsics.f(str, "message");
        this.message = str;
        this.status = i2;
    }

    public static /* synthetic */ BaseResponse copy$default(BaseResponse baseResponse, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = baseResponse.message;
        }
        if ((i3 & 2) != 0) {
            i2 = baseResponse.status;
        }
        return baseResponse.copy(str, i2);
    }

    public final String component1() {
        return this.message;
    }

    public final int component2() {
        return this.status;
    }

    public final BaseResponse copy(String str, int i2) {
        Intrinsics.f(str, "message");
        return new BaseResponse(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseResponse)) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        return Intrinsics.a(this.message, baseResponse.message) && this.status == baseResponse.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.status;
    }

    public String toString() {
        return "BaseResponse(message=" + this.message + ", status=" + this.status + ')';
    }
}
