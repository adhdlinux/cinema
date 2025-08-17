package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {

    /* renamed from: a  reason: collision with root package name */
    private final int f25019a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25020b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25021c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f25022d;

    /* renamed from: e  reason: collision with root package name */
    public int f25023e;

    public NalUnitTargetBuffer(int i2, int i3) {
        this.f25019a = i2;
        byte[] bArr = new byte[(i3 + 3)];
        this.f25022d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f25020b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f25022d;
            int length = bArr2.length;
            int i5 = this.f25023e;
            if (length < i5 + i4) {
                this.f25022d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f25022d, this.f25023e, i4);
            this.f25023e += i4;
        }
    }

    public boolean b(int i2) {
        if (!this.f25020b) {
            return false;
        }
        this.f25023e -= i2;
        this.f25020b = false;
        this.f25021c = true;
        return true;
    }

    public boolean c() {
        return this.f25021c;
    }

    public void d() {
        this.f25020b = false;
        this.f25021c = false;
    }

    public void e(int i2) {
        boolean z2 = true;
        Assertions.g(!this.f25020b);
        if (i2 != this.f25019a) {
            z2 = false;
        }
        this.f25020b = z2;
        if (z2) {
            this.f25023e = 3;
            this.f25021c = false;
        }
    }
}
