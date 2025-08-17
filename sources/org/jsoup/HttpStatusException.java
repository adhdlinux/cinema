package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    private int f41496b;

    /* renamed from: c  reason: collision with root package name */
    private String f41497c;

    public HttpStatusException(String str, int i2, String str2) {
        super(str);
        this.f41496b = i2;
        this.f41497c = str2;
    }

    public String toString() {
        return super.toString() + ". Status=" + this.f41496b + ", URL=" + this.f41497c;
    }
}
