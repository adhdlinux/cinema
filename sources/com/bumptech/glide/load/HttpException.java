package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    private final int f16295b;

    public HttpException(int i2) {
        this("Http request failed with status code: " + i2, i2);
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i2) {
        this(str, i2, (Throwable) null);
    }

    public HttpException(String str, int i2, Throwable th) {
        super(str, th);
        this.f16295b = i2;
    }
}
