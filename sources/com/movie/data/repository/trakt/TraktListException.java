package com.movie.data.repository.trakt;

import java.io.IOException;

public final class TraktListException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    private final int f31959b;

    public TraktListException(String str) {
        this(str, -1);
    }

    public TraktListException(String str, int i2) {
        this(str, i2, (Throwable) null);
    }

    public TraktListException(String str, int i2, Throwable th) {
        super(str, th);
        this.f31959b = i2;
    }
}
