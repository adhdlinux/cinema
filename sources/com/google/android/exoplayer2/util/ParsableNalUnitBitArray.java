package com.google.android.exoplayer2.util;

public final class ParsableNalUnitBitArray {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f28767a;

    /* renamed from: b  reason: collision with root package name */
    private int f28768b;

    /* renamed from: c  reason: collision with root package name */
    private int f28769c;

    /* renamed from: d  reason: collision with root package name */
    private int f28770d;

    public ParsableNalUnitBitArray(byte[] bArr, int i2, int i3) {
        i(bArr, i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f28768b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f28769c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f28768b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f28770d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.util.Assertions.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.ParsableNalUnitBitArray.a():void");
    }

    private int f() {
        int i2 = 0;
        int i3 = 0;
        while (!d()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = e(i3);
        }
        return i4 + i2;
    }

    private boolean j(int i2) {
        if (2 <= i2 && i2 < this.f28768b) {
            byte[] bArr = this.f28767a;
            return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 - 1] == 0;
        }
    }

    public boolean b(int i2) {
        int i3 = this.f28769c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f28770d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f28768b) {
                int i7 = this.f28768b;
            } else if (j(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i72 = this.f28768b;
        if (i5 < i72) {
            return true;
        }
        if (i5 == i72 && i6 == 0) {
            return true;
        }
        return false;
    }

    public boolean c() {
        boolean z2;
        int i2 = this.f28769c;
        int i3 = this.f28770d;
        int i4 = 0;
        while (this.f28769c < this.f28768b && !d()) {
            i4++;
        }
        if (this.f28769c == this.f28768b) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28769c = i2;
        this.f28770d = i3;
        if (z2 || !b((i4 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean d() {
        boolean z2;
        if ((this.f28767a[this.f28769c] & (128 >> this.f28770d)) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        k();
        return z2;
    }

    public int e(int i2) {
        int i3;
        int i4;
        this.f28770d += i2;
        int i5 = 0;
        while (true) {
            i3 = this.f28770d;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            int i6 = i3 - 8;
            this.f28770d = i6;
            byte[] bArr = this.f28767a;
            int i7 = this.f28769c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!j(i7 + 1)) {
                i4 = 1;
            }
            this.f28769c = i7 + i4;
        }
        byte[] bArr2 = this.f28767a;
        int i8 = this.f28769c;
        int i9 = (-1 >>> (32 - i2)) & (i5 | ((bArr2[i8] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f28770d = 0;
            if (!j(i8 + 1)) {
                i4 = 1;
            }
            this.f28769c = i8 + i4;
        }
        a();
        return i9;
    }

    public int g() {
        int i2;
        int f2 = f();
        if (f2 % 2 == 0) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        return i2 * ((f2 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i2, int i3) {
        this.f28767a = bArr;
        this.f28769c = i2;
        this.f28768b = i3;
        this.f28770d = 0;
        a();
    }

    public void k() {
        int i2 = 1;
        int i3 = this.f28770d + 1;
        this.f28770d = i3;
        if (i3 == 8) {
            this.f28770d = 0;
            int i4 = this.f28769c;
            if (j(i4 + 1)) {
                i2 = 2;
            }
            this.f28769c = i4 + i2;
        }
        a();
    }

    public void l(int i2) {
        int i3 = this.f28769c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f28769c = i5;
        int i6 = this.f28770d + (i2 - (i4 * 8));
        this.f28770d = i6;
        if (i6 > 7) {
            this.f28769c = i5 + 1;
            this.f28770d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f28769c) {
                a();
                return;
            } else if (j(i3)) {
                this.f28769c++;
                i3 += 2;
            }
        }
    }
}
