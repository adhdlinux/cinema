package androidx.media3.extractor;

import com.facebook.imageutils.JfifUtil;

public final class VorbisBitArray {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f8097a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8098b;

    /* renamed from: c  reason: collision with root package name */
    private int f8099c;

    /* renamed from: d  reason: collision with root package name */
    private int f8100d;

    public VorbisBitArray(byte[] bArr) {
        this.f8097a = bArr;
        this.f8098b = bArr.length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f8098b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f8099c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f8098b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f8100d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.h(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.VorbisBitArray.a():void");
    }

    public int b() {
        return (this.f8099c * 8) + this.f8100d;
    }

    public boolean c() {
        boolean z2;
        if ((((this.f8097a[this.f8099c] & 255) >> this.f8100d) & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        e(1);
        return z2;
    }

    public int d(int i2) {
        int i3 = this.f8099c;
        int min = Math.min(i2, 8 - this.f8100d);
        int i4 = i3 + 1;
        int i5 = ((this.f8097a[i3] & 255) >> this.f8100d) & (JfifUtil.MARKER_FIRST_BYTE >> (8 - min));
        while (min < i2) {
            i5 |= (this.f8097a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        e(i2);
        return i6;
    }

    public void e(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f8099c + i3;
        this.f8099c = i4;
        int i5 = this.f8100d + (i2 - (i3 * 8));
        this.f8100d = i5;
        if (i5 > 7) {
            this.f8099c = i4 + 1;
            this.f8100d = i5 - 8;
        }
        a();
    }
}
