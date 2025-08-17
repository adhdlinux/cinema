package com.google.android.exoplayer2.drm;

public final class UnsupportedDrmException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    public final int f24115b;

    public UnsupportedDrmException(int i2) {
        this.f24115b = i2;
    }

    public UnsupportedDrmException(int i2, Exception exc) {
        super(exc);
        this.f24115b = i2;
    }
}
