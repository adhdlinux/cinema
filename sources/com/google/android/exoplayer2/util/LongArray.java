package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {

    /* renamed from: a  reason: collision with root package name */
    private int f28707a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f28708b;

    public LongArray() {
        this(32);
    }

    public void a(long j2) {
        int i2 = this.f28707a;
        long[] jArr = this.f28708b;
        if (i2 == jArr.length) {
            this.f28708b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f28708b;
        int i3 = this.f28707a;
        this.f28707a = i3 + 1;
        jArr2[i3] = j2;
    }

    public long b(int i2) {
        if (i2 >= 0 && i2 < this.f28707a) {
            return this.f28708b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f28707a);
    }

    public int c() {
        return this.f28707a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f28708b, this.f28707a);
    }

    public LongArray(int i2) {
        this.f28708b = new long[i2];
    }
}
