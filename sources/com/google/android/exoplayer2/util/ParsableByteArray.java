package com.google.android.exoplayer2.util;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.UnsignedBytes;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class ParsableByteArray {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f28761d = {13, 10};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f28762e = {10};

    /* renamed from: f  reason: collision with root package name */
    private static final ImmutableSet<Charset> f28763f = ImmutableSet.u(Charsets.US_ASCII, Charsets.UTF_8, Charsets.UTF_16, Charsets.UTF_16BE, Charsets.UTF_16LE);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f28764a;

    /* renamed from: b  reason: collision with root package name */
    private int f28765b;

    /* renamed from: c  reason: collision with root package name */
    private int f28766c;

    public ParsableByteArray() {
        this.f28764a = Util.f28813f;
    }

    private void W(Charset charset) {
        if (m(charset, f28761d) == 13) {
            m(charset, f28762e);
        }
    }

    private int d(Charset charset) {
        int i2;
        if (charset.equals(Charsets.UTF_8) || charset.equals(Charsets.US_ASCII)) {
            i2 = 1;
        } else if (charset.equals(Charsets.UTF_16) || charset.equals(Charsets.UTF_16LE) || charset.equals(Charsets.UTF_16BE)) {
            i2 = 2;
        } else {
            throw new IllegalArgumentException("Unsupported charset: " + charset);
        }
        int i3 = this.f28765b;
        while (true) {
            int i4 = this.f28766c;
            if (i3 >= i4 - (i2 - 1)) {
                return i4;
            }
            if ((charset.equals(Charsets.UTF_8) || charset.equals(Charsets.US_ASCII)) && Util.y0(this.f28764a[i3])) {
                return i3;
            }
            if (charset.equals(Charsets.UTF_16) || charset.equals(Charsets.UTF_16BE)) {
                byte[] bArr = this.f28764a;
                if (bArr[i3] == 0 && Util.y0(bArr[i3 + 1])) {
                    return i3;
                }
            }
            if (charset.equals(Charsets.UTF_16LE)) {
                byte[] bArr2 = this.f28764a;
                if (bArr2[i3 + 1] == 0 && Util.y0(bArr2[i3])) {
                    return i3;
                }
            }
            i3 += i2;
        }
    }

    private int i(Charset charset) {
        byte b2;
        char c2;
        int i2 = 1;
        if ((charset.equals(Charsets.UTF_8) || charset.equals(Charsets.US_ASCII)) && a() >= 1) {
            b2 = (byte) Chars.a((long) UnsignedBytes.b(this.f28764a[this.f28765b]));
        } else {
            if ((charset.equals(Charsets.UTF_16) || charset.equals(Charsets.UTF_16BE)) && a() >= 2) {
                byte[] bArr = this.f28764a;
                int i3 = this.f28765b;
                c2 = Chars.c(bArr[i3], bArr[i3 + 1]);
            } else if (!charset.equals(Charsets.UTF_16LE) || a() < 2) {
                return 0;
            } else {
                byte[] bArr2 = this.f28764a;
                int i4 = this.f28765b;
                c2 = Chars.c(bArr2[i4 + 1], bArr2[i4]);
            }
            b2 = (byte) c2;
            i2 = 2;
        }
        return (Chars.a((long) b2) << 16) + i2;
    }

    private char m(Charset charset, char[] cArr) {
        int i2 = i(charset);
        if (i2 == 0) {
            return 0;
        }
        char c2 = (char) (i2 >> 16);
        if (!Chars.b(cArr, c2)) {
            return 0;
        }
        this.f28765b += i2 & 65535;
        return c2;
    }

    public long A() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        this.f28765b = i9 + 1;
        return ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
    }

    public String B() {
        return n(0);
    }

    public String C(int i2) {
        int i3;
        if (i2 == 0) {
            return "";
        }
        int i4 = this.f28765b;
        int i5 = (i4 + i2) - 1;
        if (i5 >= this.f28766c || this.f28764a[i5] != 0) {
            i3 = i2;
        } else {
            i3 = i2 - 1;
        }
        String E = Util.E(this.f28764a, i4, i3);
        this.f28765b += i2;
        return E;
    }

    public short D() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        this.f28765b = i3 + 1;
        return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
    }

    public String E(int i2) {
        return F(i2, Charsets.UTF_8);
    }

    public String F(int i2, Charset charset) {
        String str = new String(this.f28764a, this.f28765b, i2, charset);
        this.f28765b += i2;
        return str;
    }

    public int G() {
        return (H() << 21) | (H() << 14) | (H() << 7) | H();
    }

    public int H() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        this.f28765b = i2 + 1;
        return bArr[i2] & 255;
    }

    public int I() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        byte b2 = (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
        this.f28765b = i3 + 1 + 2;
        return b2;
    }

    public long J() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        this.f28765b = i5 + 1;
        return ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 8) | (((long) bArr[i5]) & 255);
    }

    public int K() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        byte b2 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        this.f28765b = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }

    public int L() {
        int q2 = q();
        if (q2 >= 0) {
            return q2;
        }
        throw new IllegalStateException("Top bit not zero: " + q2);
    }

    public long M() {
        long A = A();
        if (A >= 0) {
            return A;
        }
        throw new IllegalStateException("Top bit not zero: " + A);
    }

    public int N() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        this.f28765b = i3 + 1;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public long O() {
        int i2;
        int i3;
        long j2 = (long) this.f28764a[this.f28765b];
        int i4 = 7;
        while (true) {
            i2 = 1;
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= (long) (i5 - 1);
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 != 0) {
            while (i2 < i3) {
                byte b2 = this.f28764a[this.f28765b + i2];
                if ((b2 & 192) == 128) {
                    j2 = (j2 << 6) | ((long) (b2 & 63));
                    i2++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                }
            }
            this.f28765b += i3;
            return j2;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
    }

    public Charset P() {
        if (a() >= 3) {
            byte[] bArr = this.f28764a;
            int i2 = this.f28765b;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f28765b = i2 + 3;
                return Charsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f28764a;
        int i3 = this.f28765b;
        byte b2 = bArr2[i3];
        if (b2 == -2 && bArr2[i3 + 1] == -1) {
            this.f28765b = i3 + 2;
            return Charsets.UTF_16BE;
        } else if (b2 != -1 || bArr2[i3 + 1] != -2) {
            return null;
        } else {
            this.f28765b = i3 + 2;
            return Charsets.UTF_16LE;
        }
    }

    public void Q(int i2) {
        S(b() < i2 ? new byte[i2] : this.f28764a, i2);
    }

    public void R(byte[] bArr) {
        S(bArr, bArr.length);
    }

    public void S(byte[] bArr, int i2) {
        this.f28764a = bArr;
        this.f28766c = i2;
        this.f28765b = 0;
    }

    public void T(int i2) {
        boolean z2;
        if (i2 < 0 || i2 > this.f28764a.length) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        this.f28766c = i2;
    }

    public void U(int i2) {
        boolean z2;
        if (i2 < 0 || i2 > this.f28766c) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        this.f28765b = i2;
    }

    public void V(int i2) {
        U(this.f28765b + i2);
    }

    public int a() {
        return this.f28766c - this.f28765b;
    }

    public int b() {
        return this.f28764a.length;
    }

    public void c(int i2) {
        if (i2 > b()) {
            this.f28764a = Arrays.copyOf(this.f28764a, i2);
        }
    }

    public byte[] e() {
        return this.f28764a;
    }

    public int f() {
        return this.f28765b;
    }

    public int g() {
        return this.f28766c;
    }

    public char h(Charset charset) {
        boolean contains = f28763f.contains(charset);
        Assertions.b(contains, "Unsupported charset: " + charset);
        return (char) (i(charset) >> 16);
    }

    public int j() {
        return this.f28764a[this.f28765b] & 255;
    }

    public void k(ParsableBitArray parsableBitArray, int i2) {
        l(parsableBitArray.f28757a, 0, i2);
        parsableBitArray.p(0);
    }

    public void l(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f28764a, this.f28765b, bArr, i2, i3);
        this.f28765b += i3;
    }

    public String n(char c2) {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f28765b;
        while (i2 < this.f28766c && this.f28764a[i2] != c2) {
            i2++;
        }
        byte[] bArr = this.f28764a;
        int i3 = this.f28765b;
        String E = Util.E(bArr, i3, i2 - i3);
        this.f28765b = i2;
        if (i2 < this.f28766c) {
            this.f28765b = i2 + 1;
        }
        return E;
    }

    public double o() {
        return Double.longBitsToDouble(A());
    }

    public float p() {
        return Float.intBitsToFloat(q());
    }

    public int q() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i5 = i4 + 1;
        byte b3 = b2 | ((bArr[i4] & 255) << 8);
        this.f28765b = i5 + 1;
        return (bArr[i5] & 255) | b3;
    }

    public int r() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        byte b2 = (((bArr[i2] & 255) << 24) >> 8) | ((bArr[i3] & 255) << 8);
        this.f28765b = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }

    public String s() {
        return t(Charsets.UTF_8);
    }

    public String t(Charset charset) {
        boolean contains = f28763f.contains(charset);
        Assertions.b(contains, "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(Charsets.US_ASCII)) {
            P();
        }
        String F = F(d(charset) - this.f28765b, charset);
        if (this.f28765b == this.f28766c) {
            return F;
        }
        W(charset);
        return F;
    }

    public int u() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        byte b2 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        int i5 = i4 + 1;
        byte b3 = b2 | ((bArr[i4] & 255) << 16);
        this.f28765b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | b3;
    }

    public long v() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        this.f28765b = i9 + 1;
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 40) | ((((long) bArr[i8]) & 255) << 48) | ((((long) bArr[i9]) & 255) << 56);
    }

    public short w() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        this.f28765b = i3 + 1;
        return (short) (((bArr[i3] & 255) << 8) | (bArr[i2] & 255));
    }

    public long x() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        this.f28765b = i5 + 1;
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16) | ((((long) bArr[i5]) & 255) << 24);
    }

    public int y() {
        int u2 = u();
        if (u2 >= 0) {
            return u2;
        }
        throw new IllegalStateException("Top bit not zero: " + u2);
    }

    public int z() {
        byte[] bArr = this.f28764a;
        int i2 = this.f28765b;
        int i3 = i2 + 1;
        this.f28765b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
    }

    public ParsableByteArray(int i2) {
        this.f28764a = new byte[i2];
        this.f28766c = i2;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f28764a = bArr;
        this.f28766c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i2) {
        this.f28764a = bArr;
        this.f28766c = i2;
    }
}
