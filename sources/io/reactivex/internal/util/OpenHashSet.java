package io.reactivex.internal.util;

public final class OpenHashSet<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f40073a;

    /* renamed from: b  reason: collision with root package name */
    int f40074b;

    /* renamed from: c  reason: collision with root package name */
    int f40075c;

    /* renamed from: d  reason: collision with root package name */
    int f40076d;

    /* renamed from: e  reason: collision with root package name */
    T[] f40077e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    static int c(int i2) {
        int i3 = i2 * -1640531527;
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t2) {
        T t3;
        T[] tArr = this.f40077e;
        int i2 = this.f40074b;
        int c2 = c(t2.hashCode()) & i2;
        T t4 = tArr[c2];
        if (t4 != null) {
            if (t4.equals(t2)) {
                return false;
            }
            do {
                c2 = (c2 + 1) & i2;
                t3 = tArr[c2];
                if (t3 == null) {
                }
            } while (!t3.equals(t2));
            return false;
        }
        tArr[c2] = t2;
        int i3 = this.f40075c + 1;
        this.f40075c = i3;
        if (i3 >= this.f40076d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f40077e;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        T t2;
        T[] tArr = this.f40077e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = new Object[i2];
        int i4 = this.f40075c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                    t2 = tArr[length];
                } while (t2 == null);
                int c2 = c(t2.hashCode()) & i3;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i3;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
                i4 = i5;
            } else {
                this.f40074b = i3;
                this.f40076d = (int) (((float) i2) * this.f40073a);
                this.f40077e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t2) {
        T t3;
        T[] tArr = this.f40077e;
        int i2 = this.f40074b;
        int c2 = c(t2.hashCode()) & i2;
        T t4 = tArr[c2];
        if (t4 == null) {
            return false;
        }
        if (t4.equals(t2)) {
            return f(c2, tArr, i2);
        }
        do {
            c2 = (c2 + 1) & i2;
            t3 = tArr[c2];
            if (t3 == null) {
                return false;
            }
        } while (!t3.equals(t2));
        return f(c2, tArr, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i2, T[] tArr, int i3) {
        int i4;
        T t2;
        this.f40075c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t2 = tArr[i4];
                if (t2 == null) {
                    tArr[i2] = null;
                    return true;
                }
                int c2 = c(t2.hashCode()) & i3;
                if (i2 <= i4) {
                    if (i2 >= c2 || c2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 >= c2 && c2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t2;
            i2 = i4;
        }
    }

    public int g() {
        return this.f40075c;
    }

    public OpenHashSet(int i2, float f2) {
        this.f40073a = f2;
        int a2 = Pow2.a(i2);
        this.f40074b = a2 - 1;
        this.f40076d = (int) (f2 * ((float) a2));
        this.f40077e = new Object[a2];
    }
}
