package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {

    /* renamed from: b  reason: collision with root package name */
    public final Timeline f23118b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23119c;

    /* renamed from: d  reason: collision with root package name */
    public final long f23120d;

    public IllegalSeekPositionException(Timeline timeline, int i2, long j2) {
        this.f23118b = timeline;
        this.f23119c = i2;
        this.f23120d = j2;
    }
}
