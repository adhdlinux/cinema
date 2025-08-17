package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;

public final class RangedUri {

    /* renamed from: a  reason: collision with root package name */
    public final long f26323a;

    /* renamed from: b  reason: collision with root package name */
    public final long f26324b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26325c;

    /* renamed from: d  reason: collision with root package name */
    private int f26326d;

    public RangedUri(String str, long j2, long j3) {
        this.f26325c = str == null ? "" : str;
        this.f26323a = j2;
        this.f26324b = j3;
    }

    public RangedUri a(RangedUri rangedUri, String str) {
        String c2 = c(str);
        if (rangedUri != null && c2.equals(rangedUri.c(str))) {
            long j2 = this.f26324b;
            long j3 = -1;
            if (j2 != -1) {
                long j4 = this.f26323a;
                if (j4 + j2 == rangedUri.f26323a) {
                    long j5 = rangedUri.f26324b;
                    if (j5 != -1) {
                        j3 = j2 + j5;
                    }
                    return new RangedUri(c2, j4, j3);
                }
            }
            long j6 = rangedUri.f26324b;
            if (j6 != -1) {
                long j7 = rangedUri.f26323a;
                if (j7 + j6 == this.f26323a) {
                    if (j2 != -1) {
                        j3 = j6 + j2;
                    }
                    return new RangedUri(c2, j7, j3);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return UriUtil.e(str, this.f26325c);
    }

    public String c(String str) {
        return UriUtil.d(str, this.f26325c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RangedUri.class != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        if (this.f26323a == rangedUri.f26323a && this.f26324b == rangedUri.f26324b && this.f26325c.equals(rangedUri.f26325c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f26326d == 0) {
            this.f26326d = ((((527 + ((int) this.f26323a)) * 31) + ((int) this.f26324b)) * 31) + this.f26325c.hashCode();
        }
        return this.f26326d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f26325c + ", start=" + this.f26323a + ", length=" + this.f26324b + ")";
    }
}
