package org.apache.commons.lang3.builder;

import java.util.Comparator;

public class CompareToBuilder {

    /* renamed from: a  reason: collision with root package name */
    private int f41435a = 0;

    private void t(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            p((long[]) obj, (long[]) obj2);
        } else if (obj instanceof int[]) {
            o((int[]) obj, (int[]) obj2);
        } else if (obj instanceof short[]) {
            r((short[]) obj, (short[]) obj2);
        } else if (obj instanceof char[]) {
            l((char[]) obj, (char[]) obj2);
        } else if (obj instanceof byte[]) {
            k((byte[]) obj, (byte[]) obj2);
        } else if (obj instanceof double[]) {
            m((double[]) obj, (double[]) obj2);
        } else if (obj instanceof float[]) {
            n((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            s((boolean[]) obj, (boolean[]) obj2);
        } else {
            q((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public CompareToBuilder a(byte b2, byte b3) {
        int i2;
        if (this.f41435a != 0) {
            return this;
        }
        if (b2 < b3) {
            i2 = -1;
        } else if (b2 > b3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.f41435a = i2;
        return this;
    }

    public CompareToBuilder b(char c2, char c3) {
        int i2;
        if (this.f41435a != 0) {
            return this;
        }
        if (c2 < c3) {
            i2 = -1;
        } else if (c2 > c3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.f41435a = i2;
        return this;
    }

    public CompareToBuilder c(double d2, double d3) {
        if (this.f41435a != 0) {
            return this;
        }
        this.f41435a = Double.compare(d2, d3);
        return this;
    }

    public CompareToBuilder d(float f2, float f3) {
        if (this.f41435a != 0) {
            return this;
        }
        this.f41435a = Float.compare(f2, f3);
        return this;
    }

    public CompareToBuilder e(int i2, int i3) {
        int i4;
        if (this.f41435a != 0) {
            return this;
        }
        if (i2 < i3) {
            i4 = -1;
        } else if (i2 > i3) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        this.f41435a = i4;
        return this;
    }

    public CompareToBuilder f(long j2, long j3) {
        int i2;
        if (this.f41435a != 0) {
            return this;
        }
        int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i3 < 0) {
            i2 = -1;
        } else if (i3 > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.f41435a = i2;
        return this;
    }

    public CompareToBuilder g(Object obj, Object obj2) {
        return h(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder h(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.f41435a != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.f41435a = -1;
            return this;
        } else if (obj2 == null) {
            this.f41435a = 1;
            return this;
        } else {
            if (obj.getClass().isArray()) {
                t(obj, obj2, comparator);
            } else if (comparator == null) {
                this.f41435a = ((Comparable) obj).compareTo(obj2);
            } else {
                this.f41435a = comparator.compare(obj, obj2);
            }
            return this;
        }
    }

    public CompareToBuilder i(short s2, short s3) {
        int i2;
        if (this.f41435a != 0) {
            return this;
        }
        if (s2 < s3) {
            i2 = -1;
        } else if (s2 > s3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.f41435a = i2;
        return this;
    }

    public CompareToBuilder j(boolean z2, boolean z3) {
        if (this.f41435a != 0 || z2 == z3) {
            return this;
        }
        if (!z2) {
            this.f41435a = -1;
        } else {
            this.f41435a = 1;
        }
        return this;
    }

    public CompareToBuilder k(byte[] bArr, byte[] bArr2) {
        if (this.f41435a != 0 || bArr == bArr2) {
            return this;
        }
        int i2 = -1;
        if (bArr == null) {
            this.f41435a = -1;
            return this;
        } else if (bArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (bArr.length != bArr2.length) {
            if (bArr.length >= bArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < bArr.length && this.f41435a == 0; i3++) {
                a(bArr[i3], bArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder l(char[] cArr, char[] cArr2) {
        if (this.f41435a != 0 || cArr == cArr2) {
            return this;
        }
        int i2 = -1;
        if (cArr == null) {
            this.f41435a = -1;
            return this;
        } else if (cArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (cArr.length != cArr2.length) {
            if (cArr.length >= cArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < cArr.length && this.f41435a == 0; i3++) {
                b(cArr[i3], cArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder m(double[] dArr, double[] dArr2) {
        if (this.f41435a != 0 || dArr == dArr2) {
            return this;
        }
        int i2 = -1;
        if (dArr == null) {
            this.f41435a = -1;
            return this;
        } else if (dArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (dArr.length != dArr2.length) {
            if (dArr.length >= dArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < dArr.length && this.f41435a == 0; i3++) {
                c(dArr[i3], dArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder n(float[] fArr, float[] fArr2) {
        if (this.f41435a != 0 || fArr == fArr2) {
            return this;
        }
        int i2 = -1;
        if (fArr == null) {
            this.f41435a = -1;
            return this;
        } else if (fArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (fArr.length != fArr2.length) {
            if (fArr.length >= fArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < fArr.length && this.f41435a == 0; i3++) {
                d(fArr[i3], fArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder o(int[] iArr, int[] iArr2) {
        if (this.f41435a != 0 || iArr == iArr2) {
            return this;
        }
        int i2 = -1;
        if (iArr == null) {
            this.f41435a = -1;
            return this;
        } else if (iArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (iArr.length != iArr2.length) {
            if (iArr.length >= iArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < iArr.length && this.f41435a == 0; i3++) {
                e(iArr[i3], iArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder p(long[] jArr, long[] jArr2) {
        if (this.f41435a != 0 || jArr == jArr2) {
            return this;
        }
        int i2 = -1;
        if (jArr == null) {
            this.f41435a = -1;
            return this;
        } else if (jArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (jArr.length != jArr2.length) {
            if (jArr.length >= jArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < jArr.length && this.f41435a == 0; i3++) {
                f(jArr[i3], jArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder q(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.f41435a != 0 || objArr == objArr2) {
            return this;
        }
        int i2 = -1;
        if (objArr == null) {
            this.f41435a = -1;
            return this;
        } else if (objArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (objArr.length != objArr2.length) {
            if (objArr.length >= objArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < objArr.length && this.f41435a == 0; i3++) {
                h(objArr[i3], objArr2[i3], comparator);
            }
            return this;
        }
    }

    public CompareToBuilder r(short[] sArr, short[] sArr2) {
        if (this.f41435a != 0 || sArr == sArr2) {
            return this;
        }
        int i2 = -1;
        if (sArr == null) {
            this.f41435a = -1;
            return this;
        } else if (sArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (sArr.length != sArr2.length) {
            if (sArr.length >= sArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < sArr.length && this.f41435a == 0; i3++) {
                i(sArr[i3], sArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder s(boolean[] zArr, boolean[] zArr2) {
        if (this.f41435a != 0 || zArr == zArr2) {
            return this;
        }
        int i2 = -1;
        if (zArr == null) {
            this.f41435a = -1;
            return this;
        } else if (zArr2 == null) {
            this.f41435a = 1;
            return this;
        } else if (zArr.length != zArr2.length) {
            if (zArr.length >= zArr2.length) {
                i2 = 1;
            }
            this.f41435a = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < zArr.length && this.f41435a == 0; i3++) {
                j(zArr[i3], zArr2[i3]);
            }
            return this;
        }
    }

    public int u() {
        return this.f41435a;
    }
}
