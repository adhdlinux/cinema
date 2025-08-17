package com.google.zxing.common;

import java.util.Arrays;

public final class BitArray implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private int[] f31184b;

    /* renamed from: c  reason: collision with root package name */
    private int f31185c;

    public BitArray() {
        this.f31185c = 0;
        this.f31184b = new int[1];
    }

    private void e(int i2) {
        if (i2 > this.f31184b.length * 32) {
            int[] i3 = i(i2);
            int[] iArr = this.f31184b;
            System.arraycopy(iArr, 0, i3, 0, iArr.length);
            this.f31184b = i3;
        }
    }

    private static int[] i(int i2) {
        return new int[((i2 + 31) / 32)];
    }

    public void a(boolean z2) {
        e(this.f31185c + 1);
        if (z2) {
            int[] iArr = this.f31184b;
            int i2 = this.f31185c;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f31185c++;
    }

    public void b(BitArray bitArray) {
        int i2 = bitArray.f31185c;
        e(this.f31185c + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(bitArray.f(i3));
        }
    }

    public void c(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        e(this.f31185c + i3);
        while (i3 > 0) {
            boolean z2 = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z2 = false;
            }
            a(z2);
            i3--;
        }
    }

    /* renamed from: d */
    public BitArray clone() {
        return new BitArray((int[]) this.f31184b.clone(), this.f31185c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.f31185c != bitArray.f31185c || !Arrays.equals(this.f31184b, bitArray.f31184b)) {
            return false;
        }
        return true;
    }

    public boolean f(int i2) {
        return ((1 << (i2 & 31)) & this.f31184b[i2 / 32]) != 0;
    }

    public int g() {
        return this.f31185c;
    }

    public int h() {
        return (this.f31185c + 7) / 8;
    }

    public int hashCode() {
        return (this.f31185c * 31) + Arrays.hashCode(this.f31184b);
    }

    public void j(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (f(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public void k(BitArray bitArray) {
        if (this.f31184b.length == bitArray.f31184b.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f31184b;
                if (i2 < iArr.length) {
                    iArr[i2] = iArr[i2] ^ bitArray.f31184b[i2];
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public String toString() {
        char c2;
        StringBuilder sb = new StringBuilder(this.f31185c);
        for (int i2 = 0; i2 < this.f31185c; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            if (f(i2)) {
                c2 = 'X';
            } else {
                c2 = '.';
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    BitArray(int[] iArr, int i2) {
        this.f31184b = iArr;
        this.f31185c = i2;
    }
}
