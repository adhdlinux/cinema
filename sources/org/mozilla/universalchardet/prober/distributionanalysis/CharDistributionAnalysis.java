package org.mozilla.universalchardet.prober.distributionanalysis;

public abstract class CharDistributionAnalysis {

    /* renamed from: a  reason: collision with root package name */
    private int f41970a;

    /* renamed from: b  reason: collision with root package name */
    private int f41971b;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f41972c;

    /* renamed from: d  reason: collision with root package name */
    protected float f41973d;

    public CharDistributionAnalysis() {
        e();
    }

    public float a() {
        int i2;
        int i3 = this.f41971b;
        if (i3 <= 0 || (i2 = this.f41970a) <= 4) {
            return 0.01f;
        }
        if (i3 != i2) {
            float f2 = ((float) i2) / (((float) (i3 - i2)) * this.f41973d);
            if (f2 < 0.99f) {
                return f2;
            }
        }
        return 0.99f;
    }

    /* access modifiers changed from: protected */
    public abstract int b(byte[] bArr, int i2);

    public boolean c() {
        return this.f41971b > 1024;
    }

    public void d(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 == 2) {
            i4 = b(bArr, i2);
        } else {
            i4 = -1;
        }
        if (i4 >= 0) {
            this.f41971b++;
            int[] iArr = this.f41972c;
            if (i4 < iArr.length && 512 > iArr[i4]) {
                this.f41970a++;
            }
        }
    }

    public final void e() {
        this.f41971b = 0;
        this.f41970a = 0;
    }
}
