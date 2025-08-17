package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f31266a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31267b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31268c;

    public ByteMatrix(int i2, int i3) {
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i3;
        this.f31266a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.f31267b = i2;
        this.f31268c = i3;
    }

    public void a(byte b2) {
        for (int i2 = 0; i2 < this.f31268c; i2++) {
            for (int i3 = 0; i3 < this.f31267b; i3++) {
                this.f31266a[i2][i3] = b2;
            }
        }
    }

    public byte b(int i2, int i3) {
        return this.f31266a[i3][i2];
    }

    public byte[][] c() {
        return this.f31266a;
    }

    public int d() {
        return this.f31268c;
    }

    public int e() {
        return this.f31267b;
    }

    public void f(int i2, int i3, int i4) {
        this.f31266a[i3][i2] = (byte) i4;
    }

    public void g(int i2, int i3, boolean z2) {
        this.f31266a[i3][i2] = z2 ? (byte) 1 : 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f31267b * 2 * this.f31268c) + 2);
        for (int i2 = 0; i2 < this.f31268c; i2++) {
            for (int i3 = 0; i3 < this.f31267b; i3++) {
                byte b2 = this.f31266a[i2][i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
