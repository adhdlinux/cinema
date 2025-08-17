package com.google.android.exoplayer2.extractor;

import com.facebook.imageutils.JfifUtil;

public final class VorbisBitArray {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24250a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24251b;

    /* renamed from: c  reason: collision with root package name */
    private int f24252c;

    /* renamed from: d  reason: collision with root package name */
    private int f24253d;

    public VorbisBitArray(byte[] bArr) {
        this.f24250a = bArr;
        this.f24251b = bArr.length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f24251b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f24252c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f24251b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f24253d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.util.Assertions.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.VorbisBitArray.a():void");
    }

    public int b() {
        return (this.f24252c * 8) + this.f24253d;
    }

    public boolean c() {
        boolean z2;
        if ((((this.f24250a[this.f24252c] & 255) >> this.f24253d) & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        e(1);
        return z2;
    }

    public int d(int i2) {
        int i3 = this.f24252c;
        int min = Math.min(i2, 8 - this.f24253d);
        int i4 = i3 + 1;
        int i5 = ((this.f24250a[i3] & 255) >> this.f24253d) & (JfifUtil.MARKER_FIRST_BYTE >> (8 - min));
        while (min < i2) {
            i5 |= (this.f24250a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        e(i2);
        return i6;
    }

    public void e(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f24252c + i3;
        this.f24252c = i4;
        int i5 = this.f24253d + (i2 - (i3 * 8));
        this.f24253d = i5;
        if (i5 > 7) {
            this.f24252c = i4 + 1;
            this.f24253d = i5 - 8;
        }
        a();
    }
}
