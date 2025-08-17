package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Util;

final class FixedSampleSizeRechunker {

    public static final class Results {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f8565a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f8566b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8567c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f8568d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f8569e;

        /* renamed from: f  reason: collision with root package name */
        public final long f8570f;

        private Results(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
            this.f8565a = jArr;
            this.f8566b = iArr;
            this.f8567c = i2;
            this.f8568d = jArr2;
            this.f8569e = iArr2;
            this.f8570f = j2;
        }
    }

    private FixedSampleSizeRechunker() {
    }

    public static Results a(int i2, long[] jArr, int[] iArr, long j2) {
        int[] iArr2 = iArr;
        int i3 = 8192 / i2;
        int i4 = 0;
        for (int k2 : iArr2) {
            i4 += Util.k(k2, i3);
        }
        long[] jArr2 = new long[i4];
        int[] iArr3 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr4 = new int[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            int i9 = iArr2[i8];
            long j3 = jArr[i8];
            while (i9 > 0) {
                int min = Math.min(i3, i9);
                jArr2[i6] = j3;
                int i10 = i2 * min;
                iArr3[i6] = i10;
                i7 = Math.max(i7, i10);
                jArr3[i6] = ((long) i5) * j2;
                iArr4[i6] = 1;
                j3 += (long) iArr3[i6];
                i5 += min;
                i9 -= min;
                i6++;
            }
        }
        return new Results(jArr2, iArr3, i7, jArr3, iArr4, j2 * ((long) i5));
    }
}
