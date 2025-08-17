package org.mozilla.universalchardet.prober.statemachine;

public class PkgInt {

    /* renamed from: a  reason: collision with root package name */
    private int f42031a;

    /* renamed from: b  reason: collision with root package name */
    private int f42032b;

    /* renamed from: c  reason: collision with root package name */
    private int f42033c;

    /* renamed from: d  reason: collision with root package name */
    private int f42034d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f42035e;

    public PkgInt(int i2, int i3, int i4, int i5, int[] iArr) {
        this.f42031a = i2;
        this.f42032b = i3;
        this.f42033c = i4;
        this.f42034d = i5;
        this.f42035e = (int[]) iArr.clone();
    }

    public static int a(int i2, int i3) {
        return i2 | (i3 << 16);
    }

    public static int b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return c(i2 | (i3 << 4), (i5 << 4) | i4, (i7 << 4) | i6, (i9 << 4) | i8);
    }

    public static int c(int i2, int i3, int i4, int i5) {
        return a(i2 | (i3 << 8), (i5 << 8) | i4);
    }

    public int d(int i2) {
        return (this.f42035e[i2 >> this.f42031a] >> ((i2 & this.f42032b) << this.f42033c)) & this.f42034d;
    }
}
