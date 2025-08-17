package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

public class CacheSpan implements Comparable<CacheSpan> {

    /* renamed from: b  reason: collision with root package name */
    public final String f28581b;

    /* renamed from: c  reason: collision with root package name */
    public final long f28582c;

    /* renamed from: d  reason: collision with root package name */
    public final long f28583d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28584e;

    /* renamed from: f  reason: collision with root package name */
    public final File f28585f;

    /* renamed from: g  reason: collision with root package name */
    public final long f28586g;

    public CacheSpan(String str, long j2, long j3, long j4, File file) {
        boolean z2;
        this.f28581b = str;
        this.f28582c = j2;
        this.f28583d = j3;
        if (file != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28584e = z2;
        this.f28585f = file;
        this.f28586g = j4;
    }

    /* renamed from: a */
    public int compareTo(CacheSpan cacheSpan) {
        if (!this.f28581b.equals(cacheSpan.f28581b)) {
            return this.f28581b.compareTo(cacheSpan.f28581b);
        }
        int i2 = ((this.f28582c - cacheSpan.f28582c) > 0 ? 1 : ((this.f28582c - cacheSpan.f28582c) == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            return -1;
        }
        return 1;
    }

    public boolean b() {
        return !this.f28584e;
    }

    public boolean c() {
        return this.f28583d == -1;
    }

    public String toString() {
        return "[" + this.f28582c + ", " + this.f28583d + "]";
    }
}
