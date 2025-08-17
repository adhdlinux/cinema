package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: e  reason: collision with root package name */
    static final Map.Entry<?, ?>[] f30518e = new Map.Entry[0];
    @RetainedWith

    /* renamed from: b  reason: collision with root package name */
    private transient ImmutableSet<Map.Entry<K, V>> f30519b;
    @RetainedWith

    /* renamed from: c  reason: collision with root package name */
    private transient ImmutableSet<K> f30520c;
    @RetainedWith

    /* renamed from: d  reason: collision with root package name */
    private transient ImmutableCollection<V> f30521d;

    public static class Builder<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Comparator<? super V> f30522a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f30523b;

        /* renamed from: c  reason: collision with root package name */
        int f30524c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30525d;

        /* renamed from: e  reason: collision with root package name */
        DuplicateKey f30526e;

        static final class DuplicateKey {

            /* renamed from: a  reason: collision with root package name */
            private final Object f30527a;

            /* renamed from: b  reason: collision with root package name */
            private final Object f30528b;

            /* renamed from: c  reason: collision with root package name */
            private final Object f30529c;

            DuplicateKey(Object obj, Object obj2, Object obj3) {
                this.f30527a = obj;
                this.f30528b = obj2;
                this.f30529c = obj3;
            }

            /* access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f30527a + "=" + this.f30528b + " and " + this.f30527a + "=" + this.f30529c);
            }
        }

        public Builder() {
            this(4);
        }

        private ImmutableMap<K, V> b(boolean z2) {
            Object[] objArr;
            DuplicateKey duplicateKey;
            DuplicateKey duplicateKey2;
            if (!z2 || (duplicateKey2 = this.f30526e) == null) {
                int i2 = this.f30524c;
                if (this.f30522a == null) {
                    objArr = this.f30523b;
                } else {
                    if (this.f30525d) {
                        this.f30523b = Arrays.copyOf(this.f30523b, i2 * 2);
                    }
                    objArr = this.f30523b;
                    if (!z2) {
                        objArr = e(objArr, this.f30524c);
                        if (objArr.length < this.f30523b.length) {
                            i2 = objArr.length >>> 1;
                        }
                    }
                    i(objArr, i2, this.f30522a);
                }
                this.f30525d = true;
                RegularImmutableMap o2 = RegularImmutableMap.o(i2, objArr, this);
                if (!z2 || (duplicateKey = this.f30526e) == null) {
                    return o2;
                }
                throw duplicateKey.a();
            }
            throw duplicateKey2.a();
        }

        private void d(int i2) {
            int i3 = i2 * 2;
            Object[] objArr = this.f30523b;
            if (i3 > objArr.length) {
                this.f30523b = Arrays.copyOf(objArr, ImmutableCollection.Builder.c(objArr.length, i3));
                this.f30525d = false;
            }
        }

        private Object[] e(Object[] objArr, int i2) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                Object obj = objArr[i3 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i3);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[((i2 - bitSet.cardinality()) * 2)];
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2 * 2) {
                if (bitSet.get(i4 >>> 1)) {
                    i4 += 2;
                } else {
                    int i6 = i5 + 1;
                    int i7 = i4 + 1;
                    Object obj2 = objArr[i4];
                    Objects.requireNonNull(obj2);
                    objArr2[i5] = obj2;
                    i5 = i6 + 1;
                    i4 = i7 + 1;
                    Object obj3 = objArr[i7];
                    Objects.requireNonNull(obj3);
                    objArr2[i6] = obj3;
                }
            }
            return objArr2;
        }

        static <V> void i(Object[] objArr, int i2, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * 2;
                Object obj = objArr[i4];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i4 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i3] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i2, Ordering.b(comparator).f(Maps.m()));
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * 2;
                objArr[i6] = entryArr[i5].getKey();
                objArr[i6 + 1] = entryArr[i5].getValue();
            }
        }

        public ImmutableMap<K, V> a() {
            return c();
        }

        public ImmutableMap<K, V> c() {
            return b(true);
        }

        public Builder<K, V> f(K k2, V v2) {
            d(this.f30524c + 1);
            CollectPreconditions.a(k2, v2);
            Object[] objArr = this.f30523b;
            int i2 = this.f30524c;
            objArr[i2 * 2] = k2;
            objArr[(i2 * 2) + 1] = v2;
            this.f30524c = i2 + 1;
            return this;
        }

        public Builder<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f30524c + ((Collection) iterable).size());
            }
            for (Map.Entry g2 : iterable) {
                g(g2);
            }
            return this;
        }

        Builder(int i2) {
            this.f30523b = new Object[(i2 * 2)];
            this.f30524c = 0;
            this.f30525d = false;
        }
    }

    ImmutableMap() {
    }

    public static <K, V> Builder<K, V> a() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMap<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        int i2;
        if (iterable instanceof Collection) {
            i2 = ((Collection) iterable).size();
        } else {
            i2 = 4;
        }
        Builder builder = new Builder(i2);
        builder.h(iterable);
        return builder.a();
    }

    public static <K, V> ImmutableMap<K, V> d(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.i()) {
                return immutableMap;
            }
        }
        return b(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> k() {
        return RegularImmutableMap.f30642i;
    }

    public static <K, V> ImmutableMap<K, V> l(K k2, V v2) {
        CollectPreconditions.a(k2, v2);
        return RegularImmutableMap.n(1, new Object[]{k2, v2});
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<Map.Entry<K, V>> e();

    public boolean equals(Object obj) {
        return Maps.c(this, obj);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<K> f();

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<V> g();

    public abstract V get(Object obj);

    public final V getOrDefault(Object obj, V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    /* renamed from: h */
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f30519b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> e2 = e();
        this.f30519b = e2;
        return e2;
    }

    public int hashCode() {
        return Sets.d(entrySet());
    }

    /* access modifiers changed from: package-private */
    public abstract boolean i();

    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: j */
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f30520c;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> f2 = f();
        this.f30520c = f2;
        return f2;
    }

    /* renamed from: m */
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f30521d;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> g2 = g();
        this.f30521d = g2;
        return g2;
    }

    @Deprecated
    public final V put(K k2, V v2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.l(this);
    }
}
