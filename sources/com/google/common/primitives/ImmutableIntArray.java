package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import okhttp3.HttpUrl;

public final class ImmutableIntArray implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    private static final ImmutableIntArray f30720e = new ImmutableIntArray(new int[0]);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f30721b;

    /* renamed from: c  reason: collision with root package name */
    private final transient int f30722c;

    /* renamed from: d  reason: collision with root package name */
    private final int f30723d;

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray a(int[] iArr) {
        return iArr.length == 0 ? f30720e : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    public static ImmutableIntArray e() {
        return f30720e;
    }

    public int b(int i2) {
        Preconditions.j(i2, d());
        return this.f30721b[this.f30722c + i2];
    }

    public boolean c() {
        return this.f30723d == this.f30722c;
    }

    public int d() {
        return this.f30723d - this.f30722c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (d() != immutableIntArray.d()) {
            return false;
        }
        for (int i2 = 0; i2 < d(); i2++) {
            if (b(i2) != immutableIntArray.b(i2)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.f30722c; i3 < this.f30723d; i3++) {
            i2 = (i2 * 31) + Ints.i(this.f30721b[i3]);
        }
        return i2;
    }

    public String toString() {
        if (c()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(d() * 5);
        sb.append('[');
        sb.append(this.f30721b[this.f30722c]);
        int i2 = this.f30722c;
        while (true) {
            i2++;
            if (i2 < this.f30723d) {
                sb.append(", ");
                sb.append(this.f30721b[i2]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    private ImmutableIntArray(int[] iArr, int i2, int i3) {
        this.f30721b = iArr;
        this.f30722c = i2;
        this.f30723d = i3;
    }
}
