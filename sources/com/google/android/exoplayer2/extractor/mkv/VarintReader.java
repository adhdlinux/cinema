package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader {

    /* renamed from: d  reason: collision with root package name */
    private static final long[] f24488d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24489a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private int f24490b;

    /* renamed from: c  reason: collision with root package name */
    private int f24491c;

    public static long a(byte[] bArr, int i2, boolean z2) {
        long j2 = ((long) bArr[0]) & 255;
        if (z2) {
            j2 &= ~f24488d[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }

    public static int c(int i2) {
        int i3 = 0;
        while (true) {
            long[] jArr = f24488d;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & ((long) i2)) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public int b() {
        return this.f24491c;
    }

    public long d(ExtractorInput extractorInput, boolean z2, boolean z3, int i2) throws IOException {
        if (this.f24490b == 0) {
            if (!extractorInput.f(this.f24489a, 0, 1, z2)) {
                return -1;
            }
            int c2 = c(this.f24489a[0] & 255);
            this.f24491c = c2;
            if (c2 != -1) {
                this.f24490b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.f24491c;
        if (i3 > i2) {
            this.f24490b = 0;
            return -2;
        }
        if (i3 != 1) {
            extractorInput.readFully(this.f24489a, 1, i3 - 1);
        }
        this.f24490b = 0;
        return a(this.f24489a, this.f24491c, z3);
    }

    public void e() {
        this.f24490b = 0;
        this.f24491c = 0;
    }
}
