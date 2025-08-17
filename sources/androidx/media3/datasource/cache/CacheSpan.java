package androidx.media3.datasource.cache;

import java.io.File;

public class CacheSpan implements Comparable<CacheSpan> {

    /* renamed from: b  reason: collision with root package name */
    public final String f4976b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4977c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4978d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4979e;

    /* renamed from: f  reason: collision with root package name */
    public final File f4980f;

    /* renamed from: g  reason: collision with root package name */
    public final long f4981g;

    public CacheSpan(String str, long j2, long j3, long j4, File file) {
        boolean z2;
        this.f4976b = str;
        this.f4977c = j2;
        this.f4978d = j3;
        if (file != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f4979e = z2;
        this.f4980f = file;
        this.f4981g = j4;
    }

    /* renamed from: a */
    public int compareTo(CacheSpan cacheSpan) {
        if (!this.f4976b.equals(cacheSpan.f4976b)) {
            return this.f4976b.compareTo(cacheSpan.f4976b);
        }
        int i2 = ((this.f4977c - cacheSpan.f4977c) > 0 ? 1 : ((this.f4977c - cacheSpan.f4977c) == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            return -1;
        }
        return 1;
    }

    public boolean b() {
        return !this.f4979e;
    }

    public boolean c() {
        return this.f4978d == -1;
    }

    public String toString() {
        return "[" + this.f4977c + ", " + this.f4978d + "]";
    }
}
