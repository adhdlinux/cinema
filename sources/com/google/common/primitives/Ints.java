package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Ints extends IntsMethodsForWeb {

    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* renamed from: b  reason: collision with root package name */
        final int[] f30724b;

        /* renamed from: c  reason: collision with root package name */
        final int f30725c;

        /* renamed from: d  reason: collision with root package name */
        final int f30726d;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        /* renamed from: a */
        public Integer get(int i2) {
            Preconditions.j(i2, size());
            return Integer.valueOf(this.f30724b[this.f30725c + i2]);
        }

        /* renamed from: b */
        public Integer set(int i2, Integer num) {
            Preconditions.j(i2, size());
            int[] iArr = this.f30724b;
            int i3 = this.f30725c;
            int i4 = iArr[i3 + i2];
            iArr[i3 + i2] = ((Integer) Preconditions.l(num)).intValue();
            return Integer.valueOf(i4);
        }

        /* access modifiers changed from: package-private */
        public int[] c() {
            return Arrays.copyOfRange(this.f30724b, this.f30725c, this.f30726d);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.k(this.f30724b, ((Integer) obj).intValue(), this.f30725c, this.f30726d) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f30724b[this.f30725c + i2] != intArrayAsList.f30724b[intArrayAsList.f30725c + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.f30725c; i3 < this.f30726d; i3++) {
                i2 = (i2 * 31) + Ints.i(this.f30724b[i3]);
            }
            return i2;
        }

        public int indexOf(Object obj) {
            int a2;
            if (!(obj instanceof Integer) || (a2 = Ints.k(this.f30724b, ((Integer) obj).intValue(), this.f30725c, this.f30726d)) < 0) {
                return -1;
            }
            return a2 - this.f30725c;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int b2;
            if (!(obj instanceof Integer) || (b2 = Ints.l(this.f30724b, ((Integer) obj).intValue(), this.f30725c, this.f30726d)) < 0) {
                return -1;
            }
            return b2 - this.f30725c;
        }

        public int size() {
            return this.f30726d - this.f30725c;
        }

        public List<Integer> subList(int i2, int i3) {
            Preconditions.p(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            int[] iArr = this.f30724b;
            int i4 = this.f30725c;
            return new IntArrayAsList(iArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f30724b[this.f30725c]);
            int i2 = this.f30725c;
            while (true) {
                i2++;
                if (i2 < this.f30726d) {
                    sb.append(", ");
                    sb.append(this.f30724b[i2]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        IntArrayAsList(int[] iArr, int i2, int i3) {
            this.f30724b = iArr;
            this.f30725c = i2;
            this.f30726d = i3;
        }
    }

    private Ints() {
    }

    public static List<Integer> c(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new IntArrayAsList(iArr);
    }

    public static int d(long j2) {
        boolean z2;
        int i2 = (int) j2;
        if (((long) i2) == j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.g(z2, "Out of range: %s", j2);
        return i2;
    }

    public static int e(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int f(int i2, int i3, int i4) {
        boolean z2;
        if (i3 <= i4) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.f(z2, "min (%s) must be less than or equal to max (%s)", i3, i4);
        return Math.min(Math.max(i2, i3), i4);
    }

    public static int g(byte[] bArr) {
        boolean z2;
        if (bArr.length >= 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.f(z2, "array too small: %s < %s", bArr.length, 4);
        return h(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int h(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int i(int i2) {
        return i2;
    }

    public static int j(int[] iArr, int i2) {
        return k(iArr, i2, 0, iArr.length);
    }

    /* access modifiers changed from: private */
    public static int k(int[] iArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (iArr[i3] == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int l(int[] iArr, int i2, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (iArr[i5] == i2) {
                return i5;
            }
        }
        return -1;
    }

    public static int m(long j2) {
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    public static int[] n(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = ((Number) Preconditions.l(array[i2])).intValue();
        }
        return iArr;
    }

    public static Integer o(String str) {
        return p(str, 10);
    }

    public static Integer p(String str, int i2) {
        Long d2 = Longs.d(str, i2);
        if (d2 == null || d2.longValue() != ((long) d2.intValue())) {
            return null;
        }
        return Integer.valueOf(d2.intValue());
    }
}
