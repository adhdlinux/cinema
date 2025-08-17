package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Object f30476k = new Object();

    /* renamed from: b  reason: collision with root package name */
    private transient Object f30477b;

    /* renamed from: c  reason: collision with root package name */
    transient int[] f30478c;

    /* renamed from: d  reason: collision with root package name */
    transient Object[] f30479d;

    /* renamed from: e  reason: collision with root package name */
    transient Object[] f30480e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public transient int f30481f;

    /* renamed from: g  reason: collision with root package name */
    private transient int f30482g;

    /* renamed from: h  reason: collision with root package name */
    private transient Set<K> f30483h;

    /* renamed from: i  reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f30484i;

    /* renamed from: j  reason: collision with root package name */
    private transient Collection<V> f30485j;

    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map y2 = CompactHashMap.this.y();
            if (y2 != null) {
                return y2.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int j2 = CompactHashMap.this.F(entry.getKey());
            if (j2 == -1 || !Objects.a(CompactHashMap.this.Y(j2), entry.getValue())) {
                return false;
            }
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.A();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            r0 = com.google.common.collect.CompactHashMap.l(r9.f30489b);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r10) {
            /*
                r9 = this;
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                java.util.Map r0 = r0.y()
                if (r0 == 0) goto L_0x0011
                java.util.Set r0 = r0.entrySet()
                boolean r10 = r0.remove(r10)
                return r10
            L_0x0011:
                boolean r0 = r10 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0061
                java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                boolean r0 = r0.L()
                if (r0 == 0) goto L_0x0021
                return r1
            L_0x0021:
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                int r0 = r0.D()
                java.lang.Object r2 = r10.getKey()
                java.lang.Object r3 = r10.getValue()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object r5 = r10.P()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                int[] r6 = r10.N()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object[] r7 = r10.O()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object[] r8 = r10.Q()
                r4 = r0
                int r10 = com.google.common.collect.CompactHashing.f(r2, r3, r4, r5, r6, r7, r8)
                r2 = -1
                if (r10 != r2) goto L_0x0050
                return r1
            L_0x0050:
                com.google.common.collect.CompactHashMap r1 = com.google.common.collect.CompactHashMap.this
                r1.K(r10, r0)
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                com.google.common.collect.CompactHashMap.f(r10)
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                r10.E()
                r10 = 1
                return r10
            L_0x0061:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.EntrySetView.remove(java.lang.Object):boolean");
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    private abstract class Itr<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        int f30490b;

        /* renamed from: c  reason: collision with root package name */
        int f30491c;

        /* renamed from: d  reason: collision with root package name */
        int f30492d;

        private Itr() {
            this.f30490b = CompactHashMap.this.f30481f;
            this.f30491c = CompactHashMap.this.B();
            this.f30492d = -1;
        }

        private void a() {
            if (CompactHashMap.this.f30481f != this.f30490b) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract T b(int i2);

        /* access modifiers changed from: package-private */
        public void c() {
            this.f30490b += 32;
        }

        public boolean hasNext() {
            return this.f30491c >= 0;
        }

        public T next() {
            a();
            if (hasNext()) {
                int i2 = this.f30491c;
                this.f30492d = i2;
                T b2 = b(i2);
                this.f30491c = CompactHashMap.this.C(this.f30491c);
                return b2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z2;
            a();
            if (this.f30492d >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            CollectPreconditions.c(z2);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.I(this.f30492d));
            this.f30491c = CompactHashMap.this.p(this.f30491c, this.f30492d);
            this.f30492d = -1;
        }
    }

    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.J();
        }

        public boolean remove(Object obj) {
            Map y2 = CompactHashMap.this.y();
            if (y2 != null) {
                return y2.keySet().remove(obj);
            }
            if (CompactHashMap.this.M(obj) != CompactHashMap.f30476k) {
                return true;
            }
            return false;
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    final class MapEntry extends AbstractMapEntry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private final K f30495b;

        /* renamed from: c  reason: collision with root package name */
        private int f30496c;

        MapEntry(int i2) {
            this.f30495b = CompactHashMap.this.I(i2);
            this.f30496c = i2;
        }

        private void a() {
            int i2 = this.f30496c;
            if (i2 == -1 || i2 >= CompactHashMap.this.size() || !Objects.a(this.f30495b, CompactHashMap.this.I(this.f30496c))) {
                this.f30496c = CompactHashMap.this.F(this.f30495b);
            }
        }

        public K getKey() {
            return this.f30495b;
        }

        public V getValue() {
            Map y2 = CompactHashMap.this.y();
            if (y2 != null) {
                return NullnessCasts.a(y2.get(this.f30495b));
            }
            a();
            int i2 = this.f30496c;
            if (i2 == -1) {
                return NullnessCasts.b();
            }
            return CompactHashMap.this.Y(i2);
        }

        public V setValue(V v2) {
            Map y2 = CompactHashMap.this.y();
            if (y2 != null) {
                return NullnessCasts.a(y2.put(this.f30495b, v2));
            }
            a();
            int i2 = this.f30496c;
            if (i2 == -1) {
                CompactHashMap.this.put(this.f30495b, v2);
                return NullnessCasts.b();
            }
            V k2 = CompactHashMap.this.Y(i2);
            CompactHashMap.this.X(this.f30496c, v2);
            return k2;
        }
    }

    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.Z();
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        G(3);
    }

    /* access modifiers changed from: private */
    public int D() {
        return (1 << (this.f30481f & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public int F(Object obj) {
        if (L()) {
            return -1;
        }
        int c2 = Hashing.c(obj);
        int D = D();
        int h2 = CompactHashing.h(P(), c2 & D);
        if (h2 == 0) {
            return -1;
        }
        int b2 = CompactHashing.b(c2, D);
        do {
            int i2 = h2 - 1;
            int z2 = z(i2);
            if (CompactHashing.b(z2, D) == b2 && Objects.a(obj, I(i2))) {
                return i2;
            }
            h2 = CompactHashing.c(z2, D);
        } while (h2 != 0);
        return -1;
    }

    /* access modifiers changed from: private */
    public K I(int i2) {
        return O()[i2];
    }

    /* access modifiers changed from: private */
    public Object M(Object obj) {
        if (L()) {
            return f30476k;
        }
        int D = D();
        int f2 = CompactHashing.f(obj, (Object) null, D, P(), N(), O(), (Object[]) null);
        if (f2 == -1) {
            return f30476k;
        }
        Object Y = Y(f2);
        K(f2, D);
        this.f30482g--;
        E();
        return Y;
    }

    /* access modifiers changed from: private */
    public int[] N() {
        int[] iArr = this.f30478c;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* access modifiers changed from: private */
    public Object[] O() {
        Object[] objArr = this.f30479d;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* access modifiers changed from: private */
    public Object P() {
        Object obj = this.f30477b;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* access modifiers changed from: private */
    public Object[] Q() {
        Object[] objArr = this.f30480e;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void S(int i2) {
        int min;
        int length = N().length;
        if (i2 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            R(min);
        }
    }

    private int T(int i2, int i3, int i4, int i5) {
        Object a2 = CompactHashing.a(i3);
        int i6 = i3 - 1;
        if (i5 != 0) {
            CompactHashing.i(a2, i4 & i6, i5 + 1);
        }
        Object P = P();
        int[] N = N();
        for (int i7 = 0; i7 <= i2; i7++) {
            int h2 = CompactHashing.h(P, i7);
            while (h2 != 0) {
                int i8 = h2 - 1;
                int i9 = N[i8];
                int b2 = CompactHashing.b(i9, i2) | i7;
                int i10 = b2 & i6;
                int h3 = CompactHashing.h(a2, i10);
                CompactHashing.i(a2, i10, h2);
                N[i8] = CompactHashing.d(b2, h3, i6);
                h2 = CompactHashing.c(i9, i2);
            }
        }
        this.f30477b = a2;
        V(i6);
        return i6;
    }

    private void U(int i2, int i3) {
        N()[i2] = i3;
    }

    private void V(int i2) {
        this.f30481f = CompactHashing.d(this.f30481f, 32 - Integer.numberOfLeadingZeros(i2), 31);
    }

    private void W(int i2, K k2) {
        O()[i2] = k2;
    }

    /* access modifiers changed from: private */
    public void X(int i2, V v2) {
        Q()[i2] = v2;
    }

    /* access modifiers changed from: private */
    public V Y(int i2) {
        return Q()[i2];
    }

    static /* synthetic */ int f(CompactHashMap compactHashMap) {
        int i2 = compactHashMap.f30482g;
        compactHashMap.f30482g = i2 - 1;
        return i2;
    }

    public static <K, V> CompactHashMap<K, V> s() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> x(int i2) {
        return new CompactHashMap<>(i2);
    }

    private int z(int i2) {
        return N()[i2];
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> A() {
        Map y2 = y();
        if (y2 != null) {
            return y2.entrySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: d */
            public Map.Entry<K, V> b(int i2) {
                return new MapEntry(i2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public int B() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int C(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f30482g) {
            return i3;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void E() {
        this.f30481f += 32;
    }

    /* access modifiers changed from: package-private */
    public void G(int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.e(z2, "Expected size must be >= 0");
        this.f30481f = Ints.f(i2, 1, 1073741823);
    }

    /* access modifiers changed from: package-private */
    public void H(int i2, K k2, V v2, int i3, int i4) {
        U(i2, CompactHashing.d(i3, 0, i4));
        W(i2, k2);
        X(i2, v2);
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> J() {
        Map y2 = y();
        if (y2 != null) {
            return y2.keySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<K>() {
            /* access modifiers changed from: package-private */
            public K b(int i2) {
                return CompactHashMap.this.I(i2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void K(int i2, int i3) {
        Object P = P();
        int[] N = N();
        Object[] O = O();
        Object[] Q = Q();
        int size = size() - 1;
        if (i2 < size) {
            Object obj = O[size];
            O[i2] = obj;
            Q[i2] = Q[size];
            O[size] = null;
            Q[size] = null;
            N[i2] = N[size];
            N[size] = 0;
            int c2 = Hashing.c(obj) & i3;
            int h2 = CompactHashing.h(P, c2);
            int i4 = size + 1;
            if (h2 == i4) {
                CompactHashing.i(P, c2, i2 + 1);
                return;
            }
            while (true) {
                int i5 = h2 - 1;
                int i6 = N[i5];
                int c3 = CompactHashing.c(i6, i3);
                if (c3 == i4) {
                    N[i5] = CompactHashing.d(i6, i2 + 1, i3);
                    return;
                }
                h2 = c3;
            }
        } else {
            O[i2] = null;
            Q[i2] = null;
            N[i2] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return this.f30477b == null;
    }

    /* access modifiers changed from: package-private */
    public void R(int i2) {
        this.f30478c = Arrays.copyOf(N(), i2);
        this.f30479d = Arrays.copyOf(O(), i2);
        this.f30480e = Arrays.copyOf(Q(), i2);
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> Z() {
        Map y2 = y();
        if (y2 != null) {
            return y2.values().iterator();
        }
        return new CompactHashMap<K, V>.Itr<V>() {
            /* access modifiers changed from: package-private */
            public V b(int i2) {
                return CompactHashMap.this.Y(i2);
            }
        };
    }

    public void clear() {
        if (!L()) {
            E();
            Map y2 = y();
            if (y2 != null) {
                this.f30481f = Ints.f(size(), 3, 1073741823);
                y2.clear();
                this.f30477b = null;
                this.f30482g = 0;
                return;
            }
            Arrays.fill(O(), 0, this.f30482g, (Object) null);
            Arrays.fill(Q(), 0, this.f30482g, (Object) null);
            CompactHashing.g(P());
            Arrays.fill(N(), 0, this.f30482g, 0);
            this.f30482g = 0;
        }
    }

    public boolean containsKey(Object obj) {
        Map y2 = y();
        if (y2 != null) {
            return y2.containsKey(obj);
        }
        if (F(obj) != -1) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        Map y2 = y();
        if (y2 != null) {
            return y2.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.f30482g; i2++) {
            if (Objects.a(obj, Y(i2))) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f30484i;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> t2 = t();
        this.f30484i = t2;
        return t2;
    }

    public V get(Object obj) {
        Map y2 = y();
        if (y2 != null) {
            return y2.get(obj);
        }
        int F = F(obj);
        if (F == -1) {
            return null;
        }
        o(F);
        return Y(F);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.f30483h;
        if (set != null) {
            return set;
        }
        Set<K> v2 = v();
        this.f30483h = v2;
        return v2;
    }

    /* access modifiers changed from: package-private */
    public void o(int i2) {
    }

    /* access modifiers changed from: package-private */
    public int p(int i2, int i3) {
        return i2 - 1;
    }

    public V put(K k2, V v2) {
        int i2;
        int T;
        if (L()) {
            q();
        }
        Map y2 = y();
        if (y2 != null) {
            return y2.put(k2, v2);
        }
        int[] N = N();
        Object[] O = O();
        V[] Q = Q();
        int i3 = this.f30482g;
        int i4 = i3 + 1;
        int c2 = Hashing.c(k2);
        int D = D();
        int i5 = c2 & D;
        int h2 = CompactHashing.h(P(), i5);
        if (h2 != 0) {
            int b2 = CompactHashing.b(c2, D);
            int i6 = 0;
            while (true) {
                int i7 = h2 - 1;
                int i8 = N[i7];
                if (CompactHashing.b(i8, D) != b2 || !Objects.a(k2, O[i7])) {
                    int c3 = CompactHashing.c(i8, D);
                    i6++;
                    if (c3 != 0) {
                        h2 = c3;
                    } else if (i6 >= 9) {
                        return r().put(k2, v2);
                    } else {
                        if (i4 > D) {
                            T = T(D, CompactHashing.e(D), c2, i3);
                        } else {
                            N[i7] = CompactHashing.d(i8, i4, D);
                        }
                    }
                } else {
                    V v3 = Q[i7];
                    Q[i7] = v2;
                    o(i7);
                    return v3;
                }
            }
            i2 = D;
            S(i4);
            H(i3, k2, v2, c2, i2);
            this.f30482g = i4;
            E();
            return null;
        } else if (i4 > D) {
            T = T(D, CompactHashing.e(D), c2, i3);
        } else {
            CompactHashing.i(P(), i5, i4);
            i2 = D;
            S(i4);
            H(i3, k2, v2, c2, i2);
            this.f30482g = i4;
            E();
            return null;
        }
        i2 = T;
        S(i4);
        H(i3, k2, v2, c2, i2);
        this.f30482g = i4;
        E();
        return null;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        Preconditions.r(L(), "Arrays already allocated");
        int i2 = this.f30481f;
        int j2 = CompactHashing.j(i2);
        this.f30477b = CompactHashing.a(j2);
        V(j2 - 1);
        this.f30478c = new int[i2];
        this.f30479d = new Object[i2];
        this.f30480e = new Object[i2];
        return i2;
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> r() {
        Map<K, V> u2 = u(D() + 1);
        int B = B();
        while (B >= 0) {
            u2.put(I(B), Y(B));
            B = C(B);
        }
        this.f30477b = u2;
        this.f30478c = null;
        this.f30479d = null;
        this.f30480e = null;
        E();
        return u2;
    }

    public V remove(Object obj) {
        Map y2 = y();
        if (y2 != null) {
            return y2.remove(obj);
        }
        V M = M(obj);
        if (M == f30476k) {
            return null;
        }
        return M;
    }

    public int size() {
        Map y2 = y();
        if (y2 != null) {
            return y2.size();
        }
        return this.f30482g;
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> t() {
        return new EntrySetView();
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> u(int i2) {
        return new LinkedHashMap(i2, 1.0f);
    }

    /* access modifiers changed from: package-private */
    public Set<K> v() {
        return new KeySetView();
    }

    public Collection<V> values() {
        Collection<V> collection = this.f30485j;
        if (collection != null) {
            return collection;
        }
        Collection<V> w2 = w();
        this.f30485j = w2;
        return w2;
    }

    /* access modifiers changed from: package-private */
    public Collection<V> w() {
        return new ValuesView();
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> y() {
        Object obj = this.f30477b;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    CompactHashMap(int i2) {
        G(i2);
    }
}
