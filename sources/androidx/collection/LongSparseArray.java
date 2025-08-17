package androidx.collection;

import com.applovin.impl.sdk.utils.JsonUtils;

public class LongSparseArray<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f1701f = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1702b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f1703c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f1704d;

    /* renamed from: e  reason: collision with root package name */
    private int f1705e;

    public LongSparseArray() {
        this(10);
    }

    private void e() {
        int i2 = this.f1705e;
        long[] jArr = this.f1703c;
        Object[] objArr = this.f1704d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1701f) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1702b = false;
        this.f1705e = i3;
    }

    public void a(long j2, E e2) {
        int i2 = this.f1705e;
        if (i2 == 0 || j2 > this.f1703c[i2 - 1]) {
            if (this.f1702b && i2 >= this.f1703c.length) {
                e();
            }
            int i3 = this.f1705e;
            if (i3 >= this.f1703c.length) {
                int f2 = ContainerHelpers.f(i3 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.f1703c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1704d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1703c = jArr;
                this.f1704d = objArr;
            }
            this.f1703c[i3] = j2;
            this.f1704d[i3] = e2;
            this.f1705e = i3 + 1;
            return;
        }
        k(j2, e2);
    }

    public void b() {
        int i2 = this.f1705e;
        Object[] objArr = this.f1704d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1705e = 0;
        this.f1702b = false;
    }

    /* renamed from: c */
    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f1703c = (long[]) this.f1703c.clone();
            longSparseArray.f1704d = (Object[]) this.f1704d.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean d(long j2) {
        return h(j2) >= 0;
    }

    public E f(long j2) {
        return g(j2, (Object) null);
    }

    public E g(long j2, E e2) {
        E e3;
        int b2 = ContainerHelpers.b(this.f1703c, this.f1705e, j2);
        if (b2 < 0 || (e3 = this.f1704d[b2]) == f1701f) {
            return e2;
        }
        return e3;
    }

    public int h(long j2) {
        if (this.f1702b) {
            e();
        }
        return ContainerHelpers.b(this.f1703c, this.f1705e, j2);
    }

    public boolean i() {
        return n() == 0;
    }

    public long j(int i2) {
        if (this.f1702b) {
            e();
        }
        return this.f1703c[i2];
    }

    public void k(long j2, E e2) {
        int b2 = ContainerHelpers.b(this.f1703c, this.f1705e, j2);
        if (b2 >= 0) {
            this.f1704d[b2] = e2;
            return;
        }
        int i2 = ~b2;
        int i3 = this.f1705e;
        if (i2 < i3) {
            Object[] objArr = this.f1704d;
            if (objArr[i2] == f1701f) {
                this.f1703c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1702b && i3 >= this.f1703c.length) {
            e();
            i2 = ~ContainerHelpers.b(this.f1703c, this.f1705e, j2);
        }
        int i4 = this.f1705e;
        if (i4 >= this.f1703c.length) {
            int f2 = ContainerHelpers.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f1703c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1704d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1703c = jArr;
            this.f1704d = objArr2;
        }
        int i5 = this.f1705e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f1703c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f1704d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f1705e - i2);
        }
        this.f1703c[i2] = j2;
        this.f1704d[i2] = e2;
        this.f1705e++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f1704d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f1703c
            int r1 = r2.f1705e
            int r3 = androidx.collection.ContainerHelpers.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f1704d
            r0 = r4[r3]
            java.lang.Object r1 = f1701f
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f1702b = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.l(long):void");
    }

    public void m(int i2) {
        Object[] objArr = this.f1704d;
        Object obj = objArr[i2];
        Object obj2 = f1701f;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f1702b = true;
        }
    }

    public int n() {
        if (this.f1702b) {
            e();
        }
        return this.f1705e;
    }

    public E o(int i2) {
        if (this.f1702b) {
            e();
        }
        return this.f1704d[i2];
    }

    public String toString() {
        if (n() <= 0) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f1705e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1705e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(j(i2));
            sb.append('=');
            Object o2 = o(i2);
            if (o2 != this) {
                sb.append(o2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public LongSparseArray(int i2) {
        this.f1702b = false;
        if (i2 == 0) {
            this.f1703c = ContainerHelpers.f1696b;
            this.f1704d = ContainerHelpers.f1697c;
            return;
        }
        int f2 = ContainerHelpers.f(i2);
        this.f1703c = new long[f2];
        this.f1704d = new Object[f2];
    }
}
