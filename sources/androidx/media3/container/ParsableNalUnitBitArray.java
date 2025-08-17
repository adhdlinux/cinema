package androidx.media3.container;

public final class ParsableNalUnitBitArray {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f4792a;

    /* renamed from: b  reason: collision with root package name */
    private int f4793b;

    /* renamed from: c  reason: collision with root package name */
    private int f4794c;

    /* renamed from: d  reason: collision with root package name */
    private int f4795d;

    public ParsableNalUnitBitArray(byte[] bArr, int i2, int i3) {
        i(bArr, i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f4793b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f4794c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f4793b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f4795d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.h(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.ParsableNalUnitBitArray.a():void");
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
        if (2 <= i2 && i2 < this.f4793b) {
            byte[] bArr = this.f4792a;
            return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 - 1] == 0;
        }
    }

    public boolean b(int i2) {
        int i3 = this.f4794c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f4795d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f4793b) {
                int i7 = this.f4793b;
            } else if (j(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i72 = this.f4793b;
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
        int i2 = this.f4794c;
        int i3 = this.f4795d;
        int i4 = 0;
        while (this.f4794c < this.f4793b && !d()) {
            i4++;
        }
        if (this.f4794c == this.f4793b) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f4794c = i2;
        this.f4795d = i3;
        if (z2 || !b((i4 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean d() {
        boolean z2;
        if ((this.f4792a[this.f4794c] & (128 >> this.f4795d)) != 0) {
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
        this.f4795d += i2;
        int i5 = 0;
        while (true) {
            i3 = this.f4795d;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            int i6 = i3 - 8;
            this.f4795d = i6;
            byte[] bArr = this.f4792a;
            int i7 = this.f4794c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!j(i7 + 1)) {
                i4 = 1;
            }
            this.f4794c = i7 + i4;
        }
        byte[] bArr2 = this.f4792a;
        int i8 = this.f4794c;
        int i9 = (-1 >>> (32 - i2)) & (i5 | ((bArr2[i8] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f4795d = 0;
            if (!j(i8 + 1)) {
                i4 = 1;
            }
            this.f4794c = i8 + i4;
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
        this.f4792a = bArr;
        this.f4794c = i2;
        this.f4793b = i3;
        this.f4795d = 0;
        a();
    }

    public void k() {
        int i2 = 1;
        int i3 = this.f4795d + 1;
        this.f4795d = i3;
        if (i3 == 8) {
            this.f4795d = 0;
            int i4 = this.f4794c;
            if (j(i4 + 1)) {
                i2 = 2;
            }
            this.f4794c = i4 + i2;
        }
        a();
    }

    public void l(int i2) {
        int i3 = this.f4794c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f4794c = i5;
        int i6 = this.f4795d + (i2 - (i4 * 8));
        this.f4795d = i6;
        if (i6 > 7) {
            this.f4794c = i5 + 1;
            this.f4795d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f4794c) {
                a();
                return;
            } else if (j(i3)) {
                this.f4794c++;
                i3 += 2;
            }
        }
    }
}
