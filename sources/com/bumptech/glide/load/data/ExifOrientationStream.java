package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f16325d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16326e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16327f;

    /* renamed from: b  reason: collision with root package name */
    private final byte f16328b;

    /* renamed from: c  reason: collision with root package name */
    private int f16329c;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f16325d = bArr;
        int length = bArr.length;
        f16326e = length;
        f16327f = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
        }
        this.f16328b = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i2;
        int i3;
        int i4 = this.f16329c;
        if (i4 < 2 || i4 > (i3 = f16327f)) {
            i2 = super.read();
        } else if (i4 == i3) {
            i2 = this.f16328b;
        } else {
            i2 = f16325d[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.f16329c++;
        }
        return i2;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.f16329c = (int) (((long) this.f16329c) + skip);
        }
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f16329c;
        int i6 = f16327f;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f16328b;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f16325d, this.f16329c - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f16329c += i4;
        }
        return i4;
    }
}
