package com.google.zxing.common.reedsolomon;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;

public final class GenericGF {

    /* renamed from: h  reason: collision with root package name */
    public static final GenericGF f31215h = new GenericGF(4201, CodedOutputStream.DEFAULT_BUFFER_SIZE, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final GenericGF f31216i = new GenericGF(1033, 1024, 1);

    /* renamed from: j  reason: collision with root package name */
    public static final GenericGF f31217j;

    /* renamed from: k  reason: collision with root package name */
    public static final GenericGF f31218k = new GenericGF(19, 16, 1);

    /* renamed from: l  reason: collision with root package name */
    public static final GenericGF f31219l = new GenericGF(285, UserVerificationMethods.USER_VERIFY_HANDPRINT, 0);

    /* renamed from: m  reason: collision with root package name */
    public static final GenericGF f31220m;

    /* renamed from: n  reason: collision with root package name */
    public static final GenericGF f31221n;

    /* renamed from: o  reason: collision with root package name */
    public static final GenericGF f31222o;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f31223a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f31224b;

    /* renamed from: c  reason: collision with root package name */
    private final GenericGFPoly f31225c;

    /* renamed from: d  reason: collision with root package name */
    private final GenericGFPoly f31226d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31227e;

    /* renamed from: f  reason: collision with root package name */
    private final int f31228f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31229g;

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        f31217j = genericGF;
        GenericGF genericGF2 = new GenericGF(301, UserVerificationMethods.USER_VERIFY_HANDPRINT, 1);
        f31220m = genericGF2;
        f31221n = genericGF2;
        f31222o = genericGF;
    }

    public GenericGF(int i2, int i3, int i4) {
        this.f31228f = i2;
        this.f31227e = i3;
        this.f31229g = i4;
        this.f31223a = new int[i3];
        this.f31224b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f31223a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f31224b[this.f31223a[i7]] = i7;
        }
        this.f31225c = new GenericGFPoly(this, new int[]{0});
        this.f31226d = new GenericGFPoly(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f31225c;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new GenericGFPoly(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        return this.f31223a[i2];
    }

    public int d() {
        return this.f31229g;
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly e() {
        return this.f31225c;
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) {
        if (i2 != 0) {
            return this.f31223a[(this.f31227e - this.f31224b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        if (i2 != 0) {
            return this.f31224b[i2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int h(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f31223a;
        int[] iArr2 = this.f31224b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f31227e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f31228f) + ',' + this.f31227e + ')';
    }
}
