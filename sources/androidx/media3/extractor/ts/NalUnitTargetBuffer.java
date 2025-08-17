package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {

    /* renamed from: a  reason: collision with root package name */
    private final int f9440a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9441b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9442c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f9443d;

    /* renamed from: e  reason: collision with root package name */
    public int f9444e;

    public NalUnitTargetBuffer(int i2, int i3) {
        this.f9440a = i2;
        byte[] bArr = new byte[(i3 + 3)];
        this.f9443d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f9441b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f9443d;
            int length = bArr2.length;
            int i5 = this.f9444e;
            if (length < i5 + i4) {
                this.f9443d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f9443d, this.f9444e, i4);
            this.f9444e += i4;
        }
    }

    public boolean b(int i2) {
        if (!this.f9441b) {
            return false;
        }
        this.f9444e -= i2;
        this.f9441b = false;
        this.f9442c = true;
        return true;
    }

    public boolean c() {
        return this.f9442c;
    }

    public void d() {
        this.f9441b = false;
        this.f9442c = false;
    }

    public void e(int i2) {
        boolean z2 = true;
        Assertions.h(!this.f9441b);
        if (i2 != this.f9440a) {
            z2 = false;
        }
        this.f9441b = z2;
        if (z2) {
            this.f9444e = 3;
            this.f9442c = false;
        }
    }
}
