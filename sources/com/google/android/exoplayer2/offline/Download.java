package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.Assertions;

public final class Download {

    /* renamed from: a  reason: collision with root package name */
    public final DownloadRequest f25519a;

    /* renamed from: b  reason: collision with root package name */
    public final int f25520b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25521c;

    /* renamed from: d  reason: collision with root package name */
    public final long f25522d;

    /* renamed from: e  reason: collision with root package name */
    public final long f25523e;

    /* renamed from: f  reason: collision with root package name */
    public final int f25524f;

    /* renamed from: g  reason: collision with root package name */
    public final int f25525g;

    /* renamed from: h  reason: collision with root package name */
    final DownloadProgress f25526h;

    public Download(DownloadRequest downloadRequest, int i2, long j2, long j3, long j4, int i3, int i4) {
        this(downloadRequest, i2, j2, j3, j4, i3, i4, new DownloadProgress());
    }

    public long a() {
        return this.f25526h.f25570a;
    }

    public float b() {
        return this.f25526h.f25571b;
    }

    public boolean c() {
        int i2 = this.f25520b;
        return i2 == 3 || i2 == 4;
    }

    public Download(DownloadRequest downloadRequest, int i2, long j2, long j3, long j4, int i3, int i4, DownloadProgress downloadProgress) {
        Assertions.e(downloadProgress);
        boolean z2 = true;
        Assertions.a((i4 == 0) == (i2 != 4));
        if (i3 != 0) {
            Assertions.a((i2 == 2 || i2 == 0) ? false : z2);
        }
        this.f25519a = downloadRequest;
        this.f25520b = i2;
        this.f25521c = j2;
        this.f25522d = j3;
        this.f25523e = j4;
        this.f25524f = i3;
        this.f25525g = i4;
        this.f25526h = downloadProgress;
    }
}
