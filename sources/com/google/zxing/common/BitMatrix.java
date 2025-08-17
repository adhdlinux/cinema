package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private final int f31186b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31187c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31188d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f31189e;

    public BitMatrix(int i2, int i3) {
        if (i2 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f31186b = i2;
        this.f31187c = i3;
        int i4 = (i2 + 31) / 32;
        this.f31188d = i4;
        this.f31189e = new int[(i4 * i3)];
    }

    /* renamed from: a */
    public BitMatrix clone() {
        return new BitMatrix(this.f31186b, this.f31187c, this.f31188d, (int[]) this.f31189e.clone());
    }

    public boolean b(int i2, int i3) {
        if (((this.f31189e[(i3 * this.f31188d) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f31187c;
    }

    public int d() {
        return this.f31186b;
    }

    public void e(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i5 < 1 || i4 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f31187c || i6 > this.f31186b) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f31188d * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f31189e;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.f31186b == bitMatrix.f31186b && this.f31187c == bitMatrix.f31187c && this.f31188d == bitMatrix.f31188d && Arrays.equals(this.f31189e, bitMatrix.f31189e)) {
            return true;
        }
        return false;
    }

    public String f(String str, String str2) {
        return g(str, str2, System.lineSeparator());
    }

    public String g(String str, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder(this.f31187c * (this.f31186b + 1));
        for (int i2 = 0; i2 < this.f31187c; i2++) {
            for (int i3 = 0; i3 < this.f31186b; i3++) {
                if (b(i3, i2)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                sb.append(str4);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public int hashCode() {
        int i2 = this.f31186b;
        return (((((((i2 * 31) + i2) * 31) + this.f31187c) * 31) + this.f31188d) * 31) + Arrays.hashCode(this.f31189e);
    }

    public String toString() {
        return f("X ", "  ");
    }

    private BitMatrix(int i2, int i3, int i4, int[] iArr) {
        this.f31186b = i2;
        this.f31187c = i3;
        this.f31188d = i4;
        this.f31189e = iArr;
    }
}
