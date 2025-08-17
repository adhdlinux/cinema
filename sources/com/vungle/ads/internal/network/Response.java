package com.vungle.ads.internal.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.ResponseBody;

public final class Response<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final T body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
            Intrinsics.f(response, "rawResponse");
            if (!response.isSuccessful()) {
                return new Response<>(response, (Object) null, responseBody, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("rawResponse should not be successful response".toString());
        }

        public final <T> Response<T> success(T t2, okhttp3.Response response) {
            Intrinsics.f(response, "rawResponse");
            if (response.isSuccessful()) {
                return new Response<>(response, t2, (ResponseBody) null, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response".toString());
        }
    }

    private Response(okhttp3.Response response, T t2, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t2;
        this.errorBody = responseBody;
    }

    public /* synthetic */ Response(okhttp3.Response response, Object obj, ResponseBody responseBody, DefaultConstructorMarker defaultConstructorMarker) {
        this(response, obj, responseBody);
    }

    public final T body() {
        return this.body;
    }

    public final int code() {
        return this.rawResponse.code();
    }

    public final ResponseBody errorBody() {
        return this.errorBody;
    }

    public final Headers headers() {
        return this.rawResponse.headers();
    }

    public final boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public final String message() {
        return this.rawResponse.message();
    }

    public final okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
