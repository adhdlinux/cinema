package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {

        /* renamed from: a  reason: collision with root package name */
        private final Random f25943a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f25944b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f25945c;

        public DefaultShuffleOrder(int i2) {
            this(i2, new Random());
        }

        private static int[] h(int i2, Random random) {
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i3 + 1;
                int nextInt = random.nextInt(i4);
                iArr[i3] = iArr[nextInt];
                iArr[nextInt] = i3;
                i3 = i4;
            }
            return iArr;
        }

        public ShuffleOrder a(int i2, int i3) {
            int i4 = i3 - i2;
            int[] iArr = new int[(this.f25944b.length - i4)];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int[] iArr2 = this.f25944b;
                if (i5 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.f25943a.nextLong()));
                }
                int i7 = iArr2[i5];
                if (i7 < i2 || i7 >= i3) {
                    int i8 = i5 - i6;
                    if (i7 >= i2) {
                        i7 -= i4;
                    }
                    iArr[i8] = i7;
                } else {
                    i6++;
                }
                i5++;
            }
        }

        public int b(int i2) {
            int i3 = this.f25945c[i2] - 1;
            if (i3 >= 0) {
                return this.f25944b[i3];
            }
            return -1;
        }

        public int c(int i2) {
            int i3 = this.f25945c[i2] + 1;
            int[] iArr = this.f25944b;
            if (i3 < iArr.length) {
                return iArr[i3];
            }
            return -1;
        }

        public int d() {
            int[] iArr = this.f25944b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        public ShuffleOrder e() {
            return new DefaultShuffleOrder(0, new Random(this.f25943a.nextLong()));
        }

        public int f() {
            int[] iArr = this.f25944b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        public ShuffleOrder g(int i2, int i3) {
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int i4 = 0;
            int i5 = 0;
            while (i5 < i3) {
                iArr[i5] = this.f25943a.nextInt(this.f25944b.length + 1);
                int i6 = i5 + 1;
                int nextInt = this.f25943a.nextInt(i6);
                iArr2[i5] = iArr2[nextInt];
                iArr2[nextInt] = i5 + i2;
                i5 = i6;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[(this.f25944b.length + i3)];
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.f25944b;
                if (i4 >= iArr4.length + i3) {
                    return new DefaultShuffleOrder(iArr3, new Random(this.f25943a.nextLong()));
                }
                if (i7 >= i3 || i8 != iArr[i7]) {
                    int i9 = i8 + 1;
                    int i10 = iArr4[i8];
                    iArr3[i4] = i10;
                    if (i10 >= i2) {
                        iArr3[i4] = i10 + i3;
                    }
                    i8 = i9;
                } else {
                    iArr3[i4] = iArr2[i7];
                    i7++;
                }
                i4++;
            }
        }

        public int getLength() {
            return this.f25944b.length;
        }

        private DefaultShuffleOrder(int i2, Random random) {
            this(h(i2, random), random);
        }

        private DefaultShuffleOrder(int[] iArr, Random random) {
            this.f25944b = iArr;
            this.f25943a = random;
            this.f25945c = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.f25945c[iArr[i2]] = i2;
            }
        }
    }

    ShuffleOrder a(int i2, int i3);

    int b(int i2);

    int c(int i2);

    int d();

    ShuffleOrder e();

    int f();

    ShuffleOrder g(int i2, int i3);

    int getLength();
}
