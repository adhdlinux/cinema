package androidx.collection;

import com.applovin.impl.sdk.utils.JsonUtils;

public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f1713f = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1714b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f1715c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f1716d;

    /* renamed from: e  reason: collision with root package name */
    private int f1717e;

    public SparseArrayCompat() {
        this(10);
    }

    private void d() {
        int i2 = this.f1717e;
        int[] iArr = this.f1715c;
        Object[] objArr = this.f1716d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1713f) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1714b = false;
        this.f1717e = i3;
    }

    public void a(int i2, E e2) {
        int i3 = this.f1717e;
        if (i3 == 0 || i2 > this.f1715c[i3 - 1]) {
            if (this.f1714b && i3 >= this.f1715c.length) {
                d();
            }
            int i4 = this.f1717e;
            if (i4 >= this.f1715c.length) {
                int e3 = ContainerHelpers.e(i4 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.f1715c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1716d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1715c = iArr;
                this.f1716d = objArr;
            }
            this.f1715c[i4] = i2;
            this.f1716d[i4] = e2;
            this.f1717e = i4 + 1;
            return;
        }
        i(i2, e2);
    }

    public void b() {
        int i2 = this.f1717e;
        Object[] objArr = this.f1716d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1717e = 0;
        this.f1714b = false;
    }

    /* renamed from: c */
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f1715c = (int[]) this.f1715c.clone();
            sparseArrayCompat.f1716d = (Object[]) this.f1716d.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E e(int i2) {
        return f(i2, (Object) null);
    }

    public E f(int i2, E e2) {
        E e3;
        int a2 = ContainerHelpers.a(this.f1715c, this.f1717e, i2);
        if (a2 < 0 || (e3 = this.f1716d[a2]) == f1713f) {
            return e2;
        }
        return e3;
    }

    public int g(E e2) {
        if (this.f1714b) {
            d();
        }
        for (int i2 = 0; i2 < this.f1717e; i2++) {
            if (this.f1716d[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public int h(int i2) {
        if (this.f1714b) {
            d();
        }
        return this.f1715c[i2];
    }

    public void i(int i2, E e2) {
        int a2 = ContainerHelpers.a(this.f1715c, this.f1717e, i2);
        if (a2 >= 0) {
            this.f1716d[a2] = e2;
            return;
        }
        int i3 = ~a2;
        int i4 = this.f1717e;
        if (i3 < i4) {
            Object[] objArr = this.f1716d;
            if (objArr[i3] == f1713f) {
                this.f1715c[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f1714b && i4 >= this.f1715c.length) {
            d();
            i3 = ~ContainerHelpers.a(this.f1715c, this.f1717e, i2);
        }
        int i5 = this.f1717e;
        if (i5 >= this.f1715c.length) {
            int e3 = ContainerHelpers.e(i5 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f1715c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1716d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1715c = iArr;
            this.f1716d = objArr2;
        }
        int i6 = this.f1717e;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f1715c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f1716d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f1717e - i3);
        }
        this.f1715c[i3] = i2;
        this.f1716d[i3] = e2;
        this.f1717e++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f1716d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f1715c
            int r1 = r3.f1717e
            int r4 = androidx.collection.ContainerHelpers.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.f1716d
            r1 = r0[r4]
            java.lang.Object r2 = f1713f
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f1714b = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.j(int):void");
    }

    public int k() {
        if (this.f1714b) {
            d();
        }
        return this.f1717e;
    }

    public E l(int i2) {
        if (this.f1714b) {
            d();
        }
        return this.f1716d[i2];
    }

    public String toString() {
        if (k() <= 0) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f1717e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1717e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(h(i2));
            sb.append('=');
            Object l2 = l(i2);
            if (l2 != this) {
                sb.append(l2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public SparseArrayCompat(int i2) {
        this.f1714b = false;
        if (i2 == 0) {
            this.f1715c = ContainerHelpers.f1695a;
            this.f1716d = ContainerHelpers.f1697c;
            return;
        }
        int e2 = ContainerHelpers.e(i2);
        this.f1715c = new int[e2];
        this.f1716d = new Object[e2];
    }
}
