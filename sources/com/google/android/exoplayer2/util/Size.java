package com.google.android.exoplayer2.util;

public final class Size {

    /* renamed from: c  reason: collision with root package name */
    public static final Size f28781c = new Size(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    public static final Size f28782d = new Size(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f28783a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28784b;

    public Size(int i2, int i3) {
        boolean z2;
        if ((i2 == -1 || i2 >= 0) && (i3 == -1 || i3 >= 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f28783a = i2;
        this.f28784b = i3;
    }

    public int a() {
        return this.f28784b;
    }

    public int b() {
        return this.f28783a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.f28783a == size.f28783a && this.f28784b == size.f28784b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f28784b;
        int i3 = this.f28783a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public String toString() {
        return this.f28783a + "x" + this.f28784b;
    }
}
