package androidx.collection;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: e  reason: collision with root package name */
    private static Object[] f1681e;

    /* renamed from: f  reason: collision with root package name */
    private static int f1682f;

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f1683g;

    /* renamed from: h  reason: collision with root package name */
    private static int f1684h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f1685i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f1686j = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int[] f1687b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f1688c;

    /* renamed from: d  reason: collision with root package name */
    int f1689d;

    private class ElementIterator extends IndexBasedArrayIterator<E> {
        ElementIterator() {
            super(ArraySet.this.f1689d);
        }

        /* access modifiers changed from: protected */
        public E a(int i2) {
            return ArraySet.this.i(i2);
        }

        /* access modifiers changed from: protected */
        public void b(int i2) {
            ArraySet.this.h(i2);
        }
    }

    public ArraySet() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (f1686j) {
                Object[] objArr = f1683g;
                if (objArr != null) {
                    try {
                        this.f1688c = objArr;
                        f1683g = (Object[]) objArr[0];
                        int[] iArr = (int[]) objArr[1];
                        this.f1687b = iArr;
                        if (iArr != null) {
                            objArr[1] = null;
                            objArr[0] = null;
                            f1684h--;
                            return;
                        }
                    } catch (ClassCastException unused) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                    f1683g = null;
                    f1684h = 0;
                }
            }
        } else if (i2 == 4) {
            synchronized (f1685i) {
                Object[] objArr2 = f1681e;
                if (objArr2 != null) {
                    try {
                        this.f1688c = objArr2;
                        f1681e = (Object[]) objArr2[0];
                        int[] iArr2 = (int[]) objArr2[1];
                        this.f1687b = iArr2;
                        if (iArr2 != null) {
                            objArr2[1] = null;
                            objArr2[0] = null;
                            f1682f--;
                            return;
                        }
                    } catch (ClassCastException unused2) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                    f1681e = null;
                    f1682f = 0;
                }
            }
        }
        this.f1687b = new int[i2];
        this.f1688c = new Object[i2];
    }

    private int b(int i2) {
        try {
            return ContainerHelpers.a(this.f1687b, this.f1689d, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (f1686j) {
                if (f1684h < 10) {
                    objArr[0] = f1683g;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1683g = objArr;
                    f1684h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (f1685i) {
                if (f1682f < 10) {
                    objArr[0] = f1681e;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1681e = objArr;
                    f1682f++;
                }
            }
        }
    }

    private int e(Object obj, int i2) {
        int i3 = this.f1689d;
        if (i3 == 0) {
            return -1;
        }
        int b2 = b(i2);
        if (b2 < 0 || obj.equals(this.f1688c[b2])) {
            return b2;
        }
        int i4 = b2 + 1;
        while (i4 < i3 && this.f1687b[i4] == i2) {
            if (obj.equals(this.f1688c[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = b2 - 1;
        while (i5 >= 0 && this.f1687b[i5] == i2) {
            if (obj.equals(this.f1688c[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    private int g() {
        int i2 = this.f1689d;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(0);
        if (b2 < 0 || this.f1688c[b2] == null) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.f1687b[i3] == 0) {
            if (this.f1688c[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = b2 - 1;
        while (i4 >= 0 && this.f1687b[i4] == 0) {
            if (this.f1688c[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        int i4 = this.f1689d;
        if (e2 == null) {
            i3 = g();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = e(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i5 = ~i3;
        int[] iArr = this.f1687b;
        if (i4 >= iArr.length) {
            int i6 = 8;
            if (i4 >= 8) {
                i6 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.f1688c;
            a(i6);
            if (i4 == this.f1689d) {
                int[] iArr2 = this.f1687b;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f1688c, 0, objArr.length);
                }
                d(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i4) {
            int[] iArr3 = this.f1687b;
            int i7 = i5 + 1;
            int i8 = i4 - i5;
            System.arraycopy(iArr3, i5, iArr3, i7, i8);
            Object[] objArr2 = this.f1688c;
            System.arraycopy(objArr2, i5, objArr2, i7, i8);
        }
        int i9 = this.f1689d;
        if (i4 == i9) {
            int[] iArr4 = this.f1687b;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                this.f1688c[i5] = e2;
                this.f1689d = i9 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        c(this.f1689d + collection.size());
        boolean z2 = false;
        for (Object add : collection) {
            z2 |= add(add);
        }
        return z2;
    }

    public void c(int i2) {
        int i3 = this.f1689d;
        int[] iArr = this.f1687b;
        if (iArr.length < i2) {
            Object[] objArr = this.f1688c;
            a(i2);
            int i4 = this.f1689d;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f1687b, 0, i4);
                System.arraycopy(objArr, 0, this.f1688c, 0, this.f1689d);
            }
            d(iArr, objArr, this.f1689d);
        }
        if (this.f1689d != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f1689d;
        if (i2 != 0) {
            int[] iArr = this.f1687b;
            Object[] objArr = this.f1688c;
            this.f1687b = ContainerHelpers.f1695a;
            this.f1688c = ContainerHelpers.f1697c;
            this.f1689d = 0;
            d(iArr, objArr, i2);
        }
        if (this.f1689d != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f1689d) {
                try {
                    if (!set.contains(i(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E h(int i2) {
        int i3 = this.f1689d;
        E[] eArr = this.f1688c;
        E e2 = eArr[i2];
        if (i3 <= 1) {
            clear();
        } else {
            int i4 = i3 - 1;
            int[] iArr = this.f1687b;
            int i5 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i2 < i4) {
                    int i6 = i2 + 1;
                    int i7 = i4 - i2;
                    System.arraycopy(iArr, i6, iArr, i2, i7);
                    Object[] objArr = this.f1688c;
                    System.arraycopy(objArr, i6, objArr, i2, i7);
                }
                this.f1688c[i4] = null;
            } else {
                if (i3 > 8) {
                    i5 = i3 + (i3 >> 1);
                }
                a(i5);
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f1687b, 0, i2);
                    System.arraycopy(eArr, 0, this.f1688c, 0, i2);
                }
                if (i2 < i4) {
                    int i8 = i2 + 1;
                    int i9 = i4 - i2;
                    System.arraycopy(iArr, i8, this.f1687b, i2, i9);
                    System.arraycopy(eArr, i8, this.f1688c, i2, i9);
                }
            }
            if (i3 == this.f1689d) {
                this.f1689d = i4;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e2;
    }

    public int hashCode() {
        int[] iArr = this.f1687b;
        int i2 = this.f1689d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public E i(int i2) {
        return this.f1688c[i2];
    }

    public int indexOf(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1689d <= 0;
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        h(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z2 = false;
        for (Object remove : collection) {
            z2 |= remove(remove);
        }
        return z2;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z2 = false;
        for (int i2 = this.f1689d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f1688c[i2])) {
                h(i2);
                z2 = true;
            }
        }
        return z2;
    }

    public int size() {
        return this.f1689d;
    }

    public Object[] toArray() {
        int i2 = this.f1689d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f1688c, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f1689d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1689d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int i2) {
        if (i2 == 0) {
            this.f1687b = ContainerHelpers.f1695a;
            this.f1688c = ContainerHelpers.f1697c;
        } else {
            a(i2);
        }
        this.f1689d = 0;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1689d) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1689d);
        }
        System.arraycopy(this.f1688c, 0, tArr, 0, this.f1689d);
        int length = tArr.length;
        int i2 = this.f1689d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
