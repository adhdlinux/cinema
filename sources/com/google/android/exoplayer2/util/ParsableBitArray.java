package com.google.android.exoplayer2.util;

import com.facebook.imageutils.JfifUtil;
import java.nio.charset.Charset;

public final class ParsableBitArray {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f28757a;

    /* renamed from: b  reason: collision with root package name */
    private int f28758b;

    /* renamed from: c  reason: collision with root package name */
    private int f28759c;

    /* renamed from: d  reason: collision with root package name */
    private int f28760d;

    public ParsableBitArray() {
        this.f28757a = Util.f28813f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f28760d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f28758b
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f28760d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f28759c
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.ParsableBitArray.a():void");
    }

    public int b() {
        return ((this.f28760d - this.f28758b) * 8) - this.f28759c;
    }

    public void c() {
        if (this.f28759c != 0) {
            this.f28759c = 0;
            this.f28758b++;
            a();
        }
    }

    public int d() {
        boolean z2;
        if (this.f28759c == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        return this.f28758b;
    }

    public int e() {
        return (this.f28758b * 8) + this.f28759c;
    }

    public void f(int i2, int i3) {
        if (i3 < 32) {
            i2 &= (1 << i3) - 1;
        }
        int min = Math.min(8 - this.f28759c, i3);
        int i4 = this.f28759c;
        int i5 = (8 - i4) - min;
        byte[] bArr = this.f28757a;
        int i6 = this.f28758b;
        byte b2 = (byte) (((65280 >> i4) | ((1 << i5) - 1)) & bArr[i6]);
        bArr[i6] = b2;
        int i7 = i3 - min;
        bArr[i6] = (byte) (b2 | ((i2 >>> i7) << i5));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.f28757a[i8] = (byte) (i2 >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.f28757a;
        byte b3 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b3;
        bArr2[i8] = (byte) (((i2 & ((1 << i7) - 1)) << i9) | b3);
        r(i3);
        a();
    }

    public boolean g() {
        boolean z2;
        if ((this.f28757a[this.f28758b] & (128 >> this.f28759c)) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        q();
        return z2;
    }

    public int h(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f28759c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f28759c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f28759c = i5;
            byte[] bArr = this.f28757a;
            int i6 = this.f28758b;
            this.f28758b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f28757a;
        int i7 = this.f28758b;
        int i8 = (-1 >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f28759c = 0;
            this.f28758b = i7 + 1;
        }
        a();
        return i8;
    }

    public void i(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.f28757a;
            int i5 = this.f28758b;
            int i6 = i5 + 1;
            this.f28758b = i6;
            byte b2 = bArr2[i5];
            int i7 = this.f28759c;
            byte b3 = (byte) (b2 << i7);
            bArr[i2] = b3;
            bArr[i2] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | b3);
            i2++;
        }
        int i8 = i3 & 7;
        if (i8 != 0) {
            byte b4 = (byte) (bArr[i4] & (JfifUtil.MARKER_FIRST_BYTE >> i8));
            bArr[i4] = b4;
            int i9 = this.f28759c;
            if (i9 + i8 > 8) {
                byte[] bArr3 = this.f28757a;
                int i10 = this.f28758b;
                this.f28758b = i10 + 1;
                bArr[i4] = (byte) (b4 | ((bArr3[i10] & 255) << i9));
                this.f28759c = i9 - 8;
            }
            int i11 = this.f28759c + i8;
            this.f28759c = i11;
            byte[] bArr4 = this.f28757a;
            int i12 = this.f28758b;
            bArr[i4] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i4]);
            if (i11 == 8) {
                this.f28759c = 0;
                this.f28758b = i12 + 1;
            }
            a();
        }
    }

    public long j(int i2) {
        if (i2 <= 32) {
            return Util.f1(h(i2));
        }
        return Util.e1(h(i2 - 32), h(32));
    }

    public void k(byte[] bArr, int i2, int i3) {
        boolean z2;
        if (this.f28759c == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        System.arraycopy(this.f28757a, this.f28758b, bArr, i2, i3);
        this.f28758b += i3;
        a();
    }

    public String l(int i2, Charset charset) {
        byte[] bArr = new byte[i2];
        k(bArr, 0, i2);
        return new String(bArr, charset);
    }

    public void m(ParsableByteArray parsableByteArray) {
        o(parsableByteArray.e(), parsableByteArray.g());
        p(parsableByteArray.f() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i2) {
        this.f28757a = bArr;
        this.f28758b = 0;
        this.f28759c = 0;
        this.f28760d = i2;
    }

    public void p(int i2) {
        int i3 = i2 / 8;
        this.f28758b = i3;
        this.f28759c = i2 - (i3 * 8);
        a();
    }

    public void q() {
        int i2 = this.f28759c + 1;
        this.f28759c = i2;
        if (i2 == 8) {
            this.f28759c = 0;
            this.f28758b++;
        }
        a();
    }

    public void r(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f28758b + i3;
        this.f28758b = i4;
        int i5 = this.f28759c + (i2 - (i3 * 8));
        this.f28759c = i5;
        if (i5 > 7) {
            this.f28758b = i4 + 1;
            this.f28759c = i5 - 8;
        }
        a();
    }

    public void s(int i2) {
        boolean z2;
        if (this.f28759c == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f28758b += i2;
        a();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i2) {
        this.f28757a = bArr;
        this.f28760d = i2;
    }
}
