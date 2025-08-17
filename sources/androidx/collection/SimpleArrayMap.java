package androidx.collection;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {

    /* renamed from: e  reason: collision with root package name */
    static Object[] f1706e;

    /* renamed from: f  reason: collision with root package name */
    static int f1707f;

    /* renamed from: g  reason: collision with root package name */
    static Object[] f1708g;

    /* renamed from: h  reason: collision with root package name */
    static int f1709h;

    /* renamed from: b  reason: collision with root package name */
    int[] f1710b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f1711c;

    /* renamed from: d  reason: collision with root package name */
    int f1712d;

    public SimpleArrayMap() {
        this.f1710b = ContainerHelpers.f1695a;
        this.f1711c = ContainerHelpers.f1697c;
        this.f1712d = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = f1708g;
                if (objArr != null) {
                    this.f1711c = objArr;
                    f1708g = (Object[]) objArr[0];
                    this.f1710b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1709h--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = f1706e;
                if (objArr2 != null) {
                    this.f1711c = objArr2;
                    f1706e = (Object[]) objArr2[0];
                    this.f1710b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1707f--;
                    return;
                }
            }
        }
        this.f1710b = new int[i2];
        this.f1711c = new Object[(i2 << 1)];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return ContainerHelpers.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void e(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (f1709h < 10) {
                    objArr[0] = f1708g;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1708g = objArr;
                    f1709h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (f1707f < 10) {
                    objArr[0] = f1706e;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1706e = objArr;
                    f1707f++;
                }
            }
        }
    }

    public void clear() {
        int i2 = this.f1712d;
        if (i2 > 0) {
            int[] iArr = this.f1710b;
            Object[] objArr = this.f1711c;
            this.f1710b = ContainerHelpers.f1695a;
            this.f1711c = ContainerHelpers.f1697c;
            this.f1712d = 0;
            e(iArr, objArr, i2);
        }
        if (this.f1712d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public void d(int i2) {
        int i3 = this.f1712d;
        int[] iArr = this.f1710b;
        if (iArr.length < i2) {
            Object[] objArr = this.f1711c;
            a(i2);
            if (this.f1712d > 0) {
                System.arraycopy(iArr, 0, this.f1710b, 0, i3);
                System.arraycopy(objArr, 0, this.f1711c, 0, i3 << 1);
            }
            e(iArr, objArr, i3);
        }
        if (this.f1712d != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                if (size() != simpleArrayMap.size()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f1712d; i2++) {
                    Object j2 = j(i2);
                    Object n2 = n(i2);
                    Object obj2 = simpleArrayMap.get(j2);
                    if (n2 == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(j2)) {
                            return false;
                        }
                    } else if (!n2.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size()) {
                    return false;
                }
                for (int i3 = 0; i3 < this.f1712d; i3++) {
                    Object j3 = j(i3);
                    Object n3 = n(i3);
                    Object obj3 = map.get(j3);
                    if (n3 == null) {
                        if (obj3 != null || !map.containsKey(j3)) {
                            return false;
                        }
                    } else if (!n3.equals(obj3)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public int f(Object obj, int i2) {
        int i3 = this.f1712d;
        if (i3 == 0) {
            return -1;
        }
        int b2 = b(this.f1710b, i3, i2);
        if (b2 < 0 || obj.equals(this.f1711c[b2 << 1])) {
            return b2;
        }
        int i4 = b2 + 1;
        while (i4 < i3 && this.f1710b[i4] == i2) {
            if (obj.equals(this.f1711c[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = b2 - 1;
        while (i5 >= 0 && this.f1710b[i5] == i2) {
            if (obj.equals(this.f1711c[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public int g(Object obj) {
        return obj == null ? h() : f(obj, obj.hashCode());
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v2) {
        int g2 = g(obj);
        if (g2 >= 0) {
            return this.f1711c[(g2 << 1) + 1];
        }
        return v2;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        int i2 = this.f1712d;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.f1710b, i2, 0);
        if (b2 < 0 || this.f1711c[b2 << 1] == null) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.f1710b[i3] == 0) {
            if (this.f1711c[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = b2 - 1;
        while (i4 >= 0 && this.f1710b[i4] == 0) {
            if (this.f1711c[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public int hashCode() {
        int i2;
        int[] iArr = this.f1710b;
        Object[] objArr = this.f1711c;
        int i3 = this.f1712d;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            int i7 = iArr[i5];
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = obj.hashCode();
            }
            i6 += i2 ^ i7;
            i5++;
            i4 += 2;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public int i(Object obj) {
        int i2 = this.f1712d * 2;
        Object[] objArr = this.f1711c;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.f1712d <= 0;
    }

    public K j(int i2) {
        return this.f1711c[i2 << 1];
    }

    public void k(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i2 = simpleArrayMap.f1712d;
        d(this.f1712d + i2);
        if (this.f1712d != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(simpleArrayMap.j(i3), simpleArrayMap.n(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(simpleArrayMap.f1710b, 0, this.f1710b, 0, i2);
            System.arraycopy(simpleArrayMap.f1711c, 0, this.f1711c, 0, i2 << 1);
            this.f1712d = i2;
        }
    }

    public V l(int i2) {
        V[] vArr = this.f1711c;
        int i3 = i2 << 1;
        V v2 = vArr[i3 + 1];
        int i4 = this.f1712d;
        if (i4 <= 1) {
            clear();
        } else {
            int i5 = i4 - 1;
            int[] iArr = this.f1710b;
            int i6 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i5) {
                    int i7 = i2 + 1;
                    int i8 = i5 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr = this.f1711c;
                    System.arraycopy(objArr, i7 << 1, objArr, i3, i8 << 1);
                }
                Object[] objArr2 = this.f1711c;
                int i9 = i5 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i4 > 8) {
                    i6 = i4 + (i4 >> 1);
                }
                a(i6);
                if (i4 == this.f1712d) {
                    if (i2 > 0) {
                        System.arraycopy(iArr, 0, this.f1710b, 0, i2);
                        System.arraycopy(vArr, 0, this.f1711c, 0, i3);
                    }
                    if (i2 < i5) {
                        int i10 = i2 + 1;
                        int i11 = i5 - i2;
                        System.arraycopy(iArr, i10, this.f1710b, i2, i11);
                        System.arraycopy(vArr, i10 << 1, this.f1711c, i3, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i4 == this.f1712d) {
                this.f1712d = i5;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return v2;
    }

    public V m(int i2, V v2) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.f1711c;
        V v3 = vArr[i3];
        vArr[i3] = v2;
        return v3;
    }

    public V n(int i2) {
        return this.f1711c[(i2 << 1) + 1];
    }

    public V put(K k2, V v2) {
        int i2;
        int i3;
        int i4 = this.f1712d;
        if (k2 == null) {
            i3 = h();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = f(k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            V[] vArr = this.f1711c;
            V v3 = vArr[i5];
            vArr[i5] = v2;
            return v3;
        }
        int i6 = ~i3;
        int[] iArr = this.f1710b;
        if (i4 >= iArr.length) {
            int i7 = 8;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.f1711c;
            a(i7);
            if (i4 == this.f1712d) {
                int[] iArr2 = this.f1710b;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f1711c, 0, objArr.length);
                }
                e(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f1710b;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr2 = this.f1711c;
            System.arraycopy(objArr2, i6 << 1, objArr2, i8 << 1, (this.f1712d - i6) << 1);
        }
        int i9 = this.f1712d;
        if (i4 == i9) {
            int[] iArr4 = this.f1710b;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr3 = this.f1711c;
                int i10 = i6 << 1;
                objArr3[i10] = k2;
                objArr3[i10 + 1] = v2;
                this.f1712d = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v2) {
        V v3 = get(k2);
        if (v3 == null) {
            return put(k2, v2);
        }
        return v3;
    }

    public V remove(Object obj) {
        int g2 = g(obj);
        if (g2 >= 0) {
            return l(g2);
        }
        return null;
    }

    public V replace(K k2, V v2) {
        int g2 = g(k2);
        if (g2 >= 0) {
            return m(g2, v2);
        }
        return null;
    }

    public int size() {
        return this.f1712d;
    }

    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f1712d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1712d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object j2 = j(i2);
            if (j2 != this) {
                sb.append(j2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object n2 = n(i2);
            if (n2 != this) {
                sb.append(n2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int g2 = g(obj);
        if (g2 < 0) {
            return false;
        }
        Object n2 = n(g2);
        if (obj2 != n2 && (obj2 == null || !obj2.equals(n2))) {
            return false;
        }
        l(g2);
        return true;
    }

    public boolean replace(K k2, V v2, V v3) {
        int g2 = g(k2);
        if (g2 < 0) {
            return false;
        }
        V n2 = n(g2);
        if (n2 != v2 && (v2 == null || !v2.equals(n2))) {
            return false;
        }
        m(g2, v3);
        return true;
    }

    public SimpleArrayMap(int i2) {
        if (i2 == 0) {
            this.f1710b = ContainerHelpers.f1695a;
            this.f1711c = ContainerHelpers.f1697c;
        } else {
            a(i2);
        }
        this.f1712d = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            k(simpleArrayMap);
        }
    }
}
