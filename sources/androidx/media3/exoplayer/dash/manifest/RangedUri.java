package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.media3.common.util.UriUtil;

public final class RangedUri {

    /* renamed from: a  reason: collision with root package name */
    public final long f6094a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6095b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6096c;

    /* renamed from: d  reason: collision with root package name */
    private int f6097d;

    public RangedUri(String str, long j2, long j3) {
        this.f6096c = str == null ? "" : str;
        this.f6094a = j2;
        this.f6095b = j3;
    }

    public RangedUri a(RangedUri rangedUri, String str) {
        String c2 = c(str);
        if (rangedUri != null && c2.equals(rangedUri.c(str))) {
            long j2 = this.f6095b;
            long j3 = -1;
            if (j2 != -1) {
                long j4 = this.f6094a;
                if (j4 + j2 == rangedUri.f6094a) {
                    long j5 = rangedUri.f6095b;
                    if (j5 != -1) {
                        j3 = j2 + j5;
                    }
                    return new RangedUri(c2, j4, j3);
                }
            }
            long j6 = rangedUri.f6095b;
            if (j6 != -1) {
                long j7 = rangedUri.f6094a;
                if (j7 + j6 == this.f6094a) {
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
        return UriUtil.f(str, this.f6096c);
    }

    public String c(String str) {
        return UriUtil.e(str, this.f6096c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RangedUri.class != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        if (this.f6094a == rangedUri.f6094a && this.f6095b == rangedUri.f6095b && this.f6096c.equals(rangedUri.f6096c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f6097d == 0) {
            this.f6097d = ((((527 + ((int) this.f6094a)) * 31) + ((int) this.f6095b)) * 31) + this.f6096c.hashCode();
        }
        return this.f6097d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f6096c + ", start=" + this.f6094a + ", length=" + this.f6095b + ")";
    }
}
