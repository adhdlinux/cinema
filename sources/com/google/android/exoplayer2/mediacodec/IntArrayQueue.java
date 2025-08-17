package com.google.android.exoplayer2.mediacodec;

import java.util.NoSuchElementException;

final class IntArrayQueue {

    /* renamed from: a  reason: collision with root package name */
    private int f25260a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f25261b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f25262c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int[] f25263d;

    /* renamed from: e  reason: collision with root package name */
    private int f25264e;

    public IntArrayQueue() {
        int[] iArr = new int[16];
        this.f25263d = iArr;
        this.f25264e = iArr.length - 1;
    }

    private void c() {
        int[] iArr = this.f25263d;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i2 = this.f25260a;
            int i3 = length2 - i2;
            System.arraycopy(iArr, i2, iArr2, 0, i3);
            System.arraycopy(this.f25263d, 0, iArr2, i3, i2);
            this.f25260a = 0;
            this.f25261b = this.f25262c - 1;
            this.f25263d = iArr2;
            this.f25264e = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }

    public void a(int i2) {
        if (this.f25262c == this.f25263d.length) {
            c();
        }
        int i3 = (this.f25261b + 1) & this.f25264e;
        this.f25261b = i3;
        this.f25263d[i3] = i2;
        this.f25262c++;
    }

    public void b() {
        this.f25260a = 0;
        this.f25261b = -1;
        this.f25262c = 0;
    }

    public boolean d() {
        return this.f25262c == 0;
    }

    public int e() {
        int i2 = this.f25262c;
        if (i2 != 0) {
            int[] iArr = this.f25263d;
            int i3 = this.f25260a;
            int i4 = iArr[i3];
            this.f25260a = (i3 + 1) & this.f25264e;
            this.f25262c = i2 - 1;
            return i4;
        }
        throw new NoSuchElementException();
    }
}
