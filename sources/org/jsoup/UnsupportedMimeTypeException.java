package org.jsoup;

import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    private String f41498b;

    /* renamed from: c  reason: collision with root package name */
    private String f41499c;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.f41498b = str2;
        this.f41499c = str3;
    }

    public String toString() {
        return super.toString() + ". Mimetype=" + this.f41498b + ", URL=" + this.f41499c;
    }
}
