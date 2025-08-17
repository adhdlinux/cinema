package com.google.zxing.common.reedsolomon;

final class GenericGFPoly {

    /* renamed from: a  reason: collision with root package name */
    private final GenericGF f31230a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f31231b;

    GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f31230a = genericGF;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f31231b = iArr;
                return;
            }
            int i2 = 1;
            while (i2 < length && iArr[i2] == 0) {
                i2++;
            }
            if (i2 == length) {
                this.f31231b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i2)];
            this.f31231b = iArr2;
            System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly a(GenericGFPoly genericGFPoly) {
        if (!this.f31230a.equals(genericGFPoly.f31230a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (f()) {
            return genericGFPoly;
        } else {
            if (genericGFPoly.f()) {
                return this;
            }
            int[] iArr = this.f31231b;
            int[] iArr2 = genericGFPoly.f31231b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr4[i2] = GenericGF.a(iArr2[i2 - length], iArr[i2]);
            }
            return new GenericGFPoly(this.f31230a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly[] b(GenericGFPoly genericGFPoly) {
        if (!this.f31230a.equals(genericGFPoly.f31230a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!genericGFPoly.f()) {
            GenericGFPoly e2 = this.f31230a.e();
            int f2 = this.f31230a.f(genericGFPoly.c(genericGFPoly.e()));
            GenericGFPoly genericGFPoly2 = this;
            while (genericGFPoly2.e() >= genericGFPoly.e() && !genericGFPoly2.f()) {
                int e3 = genericGFPoly2.e() - genericGFPoly.e();
                int h2 = this.f31230a.h(genericGFPoly2.c(genericGFPoly2.e()), f2);
                GenericGFPoly h3 = genericGFPoly.h(e3, h2);
                e2 = e2.a(this.f31230a.b(e3, h2));
                genericGFPoly2 = genericGFPoly2.a(h3);
            }
            return new GenericGFPoly[]{e2, genericGFPoly2};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        int[] iArr = this.f31231b;
        return iArr[(iArr.length - 1) - i2];
    }

    /* access modifiers changed from: package-private */
    public int[] d() {
        return this.f31231b;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f31231b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f31231b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly g(GenericGFPoly genericGFPoly) {
        if (!this.f31230a.equals(genericGFPoly.f31230a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (f() || genericGFPoly.f()) {
            return this.f31230a.e();
        } else {
            int[] iArr = this.f31231b;
            int length = iArr.length;
            int[] iArr2 = genericGFPoly.f31231b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    int i5 = i2 + i4;
                    iArr3[i5] = GenericGF.a(iArr3[i5], this.f31230a.h(i3, iArr2[i4]));
                }
            }
            return new GenericGFPoly(this.f31230a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public GenericGFPoly h(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f31230a.e();
        } else {
            int length = this.f31231b.length;
            int[] iArr = new int[(i2 + length)];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.f31230a.h(this.f31231b[i4], i3);
            }
            return new GenericGFPoly(this.f31230a, iArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int e2 = e(); e2 >= 0; e2--) {
            int c2 = c(e2);
            if (c2 != 0) {
                if (c2 < 0) {
                    sb.append(" - ");
                    c2 = -c2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (e2 == 0 || c2 != 1) {
                    int g2 = this.f31230a.g(c2);
                    if (g2 == 0) {
                        sb.append('1');
                    } else if (g2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(g2);
                    }
                }
                if (e2 != 0) {
                    if (e2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(e2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
