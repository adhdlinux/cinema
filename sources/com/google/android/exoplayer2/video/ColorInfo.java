package com.google.android.exoplayer2.video;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;
import w0.a;

public final class ColorInfo implements Bundleable {

    /* renamed from: g  reason: collision with root package name */
    public static final ColorInfo f28838g = new ColorInfo(1, 2, 3, (byte[]) null);

    /* renamed from: h  reason: collision with root package name */
    private static final String f28839h = Util.u0(0);

    /* renamed from: i  reason: collision with root package name */
    private static final String f28840i = Util.u0(1);

    /* renamed from: j  reason: collision with root package name */
    private static final String f28841j = Util.u0(2);

    /* renamed from: k  reason: collision with root package name */
    private static final String f28842k = Util.u0(3);

    /* renamed from: l  reason: collision with root package name */
    public static final Bundleable.Creator<ColorInfo> f28843l = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f28844b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28845c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28846d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f28847e;

    /* renamed from: f  reason: collision with root package name */
    private int f28848f;

    public ColorInfo(int i2, int i3, int i4, byte[] bArr) {
        this.f28844b = i2;
        this.f28845c = i3;
        this.f28846d = i4;
        this.f28847e = bArr;
    }

    @Pure
    public static int b(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int c(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ColorInfo d(Bundle bundle) {
        return new ColorInfo(bundle.getInt(f28839h, -1), bundle.getInt(f28840i, -1), bundle.getInt(f28841j, -1), bundle.getByteArray(f28842k));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.f28844b == colorInfo.f28844b && this.f28845c == colorInfo.f28845c && this.f28846d == colorInfo.f28846d && Arrays.equals(this.f28847e, colorInfo.f28847e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f28848f == 0) {
            this.f28848f = ((((((527 + this.f28844b) * 31) + this.f28845c) * 31) + this.f28846d) * 31) + Arrays.hashCode(this.f28847e);
        }
        return this.f28848f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f28839h, this.f28844b);
        bundle.putInt(f28840i, this.f28845c);
        bundle.putInt(f28841j, this.f28846d);
        bundle.putByteArray(f28842k, this.f28847e);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f28844b);
        sb.append(", ");
        sb.append(this.f28845c);
        sb.append(", ");
        sb.append(this.f28846d);
        sb.append(", ");
        sb.append(this.f28847e != null);
        sb.append(")");
        return sb.toString();
    }
}
