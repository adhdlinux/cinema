package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMappedMarker {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f40327n = new Companion((DefaultConstructorMarker) null);

    /* renamed from: o  reason: collision with root package name */
    private static final MapBuilder f40328o;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public K[] f40329b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public V[] f40330c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int[] f40331d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f40332e;

    /* renamed from: f  reason: collision with root package name */
    private int f40333f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f40334g;

    /* renamed from: h  reason: collision with root package name */
    private int f40335h;

    /* renamed from: i  reason: collision with root package name */
    private int f40336i;

    /* renamed from: j  reason: collision with root package name */
    private MapBuilderKeys<K> f40337j;

    /* renamed from: k  reason: collision with root package name */
    private MapBuilderValues<V> f40338k;

    /* renamed from: l  reason: collision with root package name */
    private MapBuilderEntries<K, V> f40339l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f40340m;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int c(int i2) {
            return Integer.highestOneBit(RangesKt___RangesKt.b(i2, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int d(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }
    }

    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMappedMarker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.f(mapBuilder, "map");
        }

        /* renamed from: h */
        public EntryRef<K, V> next() {
            if (a() < d().f40334g) {
                int a2 = a();
                f(a2 + 1);
                g(a2);
                EntryRef<K, V> entryRef = new EntryRef<>(d(), b());
                e();
                return entryRef;
            }
            throw new NoSuchElementException();
        }

        public final void i(StringBuilder sb) {
            Intrinsics.f(sb, "sb");
            if (a() < d().f40334g) {
                int a2 = a();
                f(a2 + 1);
                g(a2);
                Object obj = d().f40329b[b()];
                if (Intrinsics.a(obj, d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] f2 = d().f40330c;
                Intrinsics.c(f2);
                Object obj2 = f2[b()];
                if (Intrinsics.a(obj2, d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                e();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int j() {
            int i2;
            if (a() < d().f40334g) {
                int a2 = a();
                f(a2 + 1);
                g(a2);
                Object obj = d().f40329b[b()];
                int i3 = 0;
                if (obj != null) {
                    i2 = obj.hashCode();
                } else {
                    i2 = 0;
                }
                Object[] f2 = d().f40330c;
                Intrinsics.c(f2);
                Object obj2 = f2[b()];
                if (obj2 != null) {
                    i3 = obj2.hashCode();
                }
                int i4 = i2 ^ i3;
                e();
                return i4;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private final MapBuilder<K, V> f40341b;

        /* renamed from: c  reason: collision with root package name */
        private final int f40342c;

        public EntryRef(MapBuilder<K, V> mapBuilder, int i2) {
            Intrinsics.f(mapBuilder, "map");
            this.f40341b = mapBuilder;
            this.f40342c = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (!Intrinsics.a(entry.getKey(), getKey()) || !Intrinsics.a(entry.getValue(), getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public K getKey() {
            return this.f40341b.f40329b[this.f40342c];
        }

        public V getValue() {
            V[] f2 = this.f40341b.f40330c;
            Intrinsics.c(f2);
            return f2[this.f40342c];
        }

        public int hashCode() {
            Object key = getKey();
            int i2 = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v2) {
            this.f40341b.k();
            V[] a2 = this.f40341b.i();
            int i2 = this.f40342c;
            V v3 = a2[i2];
            a2[i2] = v2;
            return v3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    public static class Itr<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private final MapBuilder<K, V> f40343b;

        /* renamed from: c  reason: collision with root package name */
        private int f40344c;

        /* renamed from: d  reason: collision with root package name */
        private int f40345d = -1;

        public Itr(MapBuilder<K, V> mapBuilder) {
            Intrinsics.f(mapBuilder, "map");
            this.f40343b = mapBuilder;
            e();
        }

        public final int a() {
            return this.f40344c;
        }

        public final int b() {
            return this.f40345d;
        }

        public final MapBuilder<K, V> d() {
            return this.f40343b;
        }

        public final void e() {
            while (this.f40344c < this.f40343b.f40334g) {
                int[] e2 = this.f40343b.f40331d;
                int i2 = this.f40344c;
                if (e2[i2] < 0) {
                    this.f40344c = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public final void f(int i2) {
            this.f40344c = i2;
        }

        public final void g(int i2) {
            this.f40345d = i2;
        }

        public final boolean hasNext() {
            return this.f40344c < this.f40343b.f40334g;
        }

        public final void remove() {
            boolean z2;
            if (this.f40345d != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f40343b.k();
                this.f40343b.J(this.f40345d);
                this.f40345d = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMappedMarker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.f(mapBuilder, "map");
        }

        public K next() {
            if (a() < d().f40334g) {
                int a2 = a();
                f(a2 + 1);
                g(a2);
                K k2 = d().f40329b[b()];
                e();
                return k2;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMappedMarker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.f(mapBuilder, "map");
        }

        public V next() {
            if (a() < d().f40334g) {
                int a2 = a();
                f(a2 + 1);
                g(a2);
                V[] f2 = d().f40330c;
                Intrinsics.c(f2);
                V v2 = f2[b()];
                e();
                return v2;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.f40340m = true;
        f40328o = mapBuilder;
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.f40329b = kArr;
        this.f40330c = vArr;
        this.f40331d = iArr;
        this.f40332e = iArr2;
        this.f40333f = i2;
        this.f40334g = i3;
        this.f40335h = f40327n.d(w());
    }

    private final int A(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * -1640531527) >>> this.f40335h;
    }

    private final boolean C(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z2 = false;
        if (collection.isEmpty()) {
            return false;
        }
        q(collection.size());
        for (Map.Entry D : collection) {
            if (D(D)) {
                z2 = true;
            }
        }
        return z2;
    }

    private final boolean D(Map.Entry<? extends K, ? extends V> entry) {
        int h2 = h(entry.getKey());
        Object[] i2 = i();
        if (h2 >= 0) {
            i2[h2] = entry.getValue();
            return true;
        }
        int i3 = (-h2) - 1;
        if (Intrinsics.a(entry.getValue(), i2[i3])) {
            return false;
        }
        i2[i3] = entry.getValue();
        return true;
    }

    private final boolean E(int i2) {
        int A = A(this.f40329b[i2]);
        int i3 = this.f40333f;
        while (true) {
            int[] iArr = this.f40332e;
            if (iArr[A] == 0) {
                iArr[A] = i2 + 1;
                this.f40331d[i2] = A;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            int i4 = A - 1;
            if (A == 0) {
                A = w() - 1;
            } else {
                A = i4;
            }
        }
    }

    private final void F(int i2) {
        if (this.f40334g > size()) {
            l();
        }
        int i3 = 0;
        if (i2 != w()) {
            this.f40332e = new int[i2];
            this.f40335h = f40327n.d(i2);
        } else {
            ArraysKt___ArraysJvmKt.j(this.f40332e, 0, 0, w());
        }
        while (i3 < this.f40334g) {
            int i4 = i3 + 1;
            if (E(i3)) {
                i3 = i4;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void H(int i2) {
        int d2 = RangesKt___RangesKt.d(this.f40333f * 2, w() / 2);
        int i3 = 0;
        int i4 = i2;
        do {
            int i5 = i2 - 1;
            if (i2 == 0) {
                i2 = w() - 1;
            } else {
                i2 = i5;
            }
            i3++;
            if (i3 > this.f40333f) {
                this.f40332e[i4] = 0;
                return;
            }
            int[] iArr = this.f40332e;
            int i6 = iArr[i2];
            if (i6 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i6 < 0) {
                iArr[i4] = -1;
            } else {
                int i7 = i6 - 1;
                if (((A(this.f40329b[i7]) - i2) & (w() - 1)) >= i3) {
                    this.f40332e[i4] = i6;
                    this.f40331d[i7] = i4;
                }
                d2--;
            }
            i4 = i2;
            i3 = 0;
            d2--;
        } while (d2 >= 0);
        this.f40332e[i4] = -1;
    }

    /* access modifiers changed from: private */
    public final void J(int i2) {
        ListBuilderKt.c(this.f40329b, i2);
        H(this.f40331d[i2]);
        this.f40331d[i2] = -1;
        this.f40336i = size() - 1;
    }

    private final boolean L(int i2) {
        int u2 = u();
        int i3 = this.f40334g;
        int i4 = u2 - i3;
        int size = i3 - size();
        if (i4 >= i2 || i4 + size < i2 || size < u() / 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final V[] i() {
        V[] vArr = this.f40330c;
        if (vArr != null) {
            return vArr;
        }
        V[] a2 = ListBuilderKt.a(u());
        this.f40330c = a2;
        return a2;
    }

    private final void l() {
        int i2;
        V[] vArr = this.f40330c;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.f40334g;
            if (i3 >= i2) {
                break;
            }
            if (this.f40331d[i3] >= 0) {
                K[] kArr = this.f40329b;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        ListBuilderKt.d(this.f40329b, i4, i2);
        if (vArr != null) {
            ListBuilderKt.d(vArr, i4, this.f40334g);
        }
        this.f40334g = i4;
    }

    private final boolean o(Map<?, ?> map) {
        return size() == map.size() && m(map.entrySet());
    }

    private final void p(int i2) {
        V[] vArr;
        if (i2 < 0) {
            throw new OutOfMemoryError();
        } else if (i2 > u()) {
            int u2 = (u() * 3) / 2;
            if (i2 <= u2) {
                i2 = u2;
            }
            this.f40329b = ListBuilderKt.b(this.f40329b, i2);
            V[] vArr2 = this.f40330c;
            if (vArr2 != null) {
                vArr = ListBuilderKt.b(vArr2, i2);
            } else {
                vArr = null;
            }
            this.f40330c = vArr;
            int[] copyOf = Arrays.copyOf(this.f40331d, i2);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f40331d = copyOf;
            int a2 = f40327n.c(i2);
            if (a2 > w()) {
                F(a2);
            }
        }
    }

    private final void q(int i2) {
        if (L(i2)) {
            F(w());
        } else {
            p(this.f40334g + i2);
        }
    }

    private final int s(K k2) {
        int A = A(k2);
        int i2 = this.f40333f;
        while (true) {
            int i3 = this.f40332e[A];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (Intrinsics.a(this.f40329b[i4], k2)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            int i5 = A - 1;
            if (A == 0) {
                A = w() - 1;
            } else {
                A = i5;
            }
        }
    }

    private final int t(V v2) {
        int i2 = this.f40334g;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f40331d[i2] >= 0) {
                V[] vArr = this.f40330c;
                Intrinsics.c(vArr);
                if (Intrinsics.a(vArr[i2], v2)) {
                    return i2;
                }
            }
        }
    }

    private final int w() {
        return this.f40332e.length;
    }

    public final KeysItr<K, V> B() {
        return new KeysItr<>(this);
    }

    public final boolean G(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "entry");
        k();
        int s2 = s(entry.getKey());
        if (s2 < 0) {
            return false;
        }
        V[] vArr = this.f40330c;
        Intrinsics.c(vArr);
        if (!Intrinsics.a(vArr[s2], entry.getValue())) {
            return false;
        }
        J(s2);
        return true;
    }

    public final int I(K k2) {
        k();
        int s2 = s(k2);
        if (s2 < 0) {
            return -1;
        }
        J(s2);
        return s2;
    }

    public final boolean K(V v2) {
        k();
        int t2 = t(v2);
        if (t2 < 0) {
            return false;
        }
        J(t2);
        return true;
    }

    public final ValuesItr<K, V> M() {
        return new ValuesItr<>(this);
    }

    public void clear() {
        k();
        IntIterator e2 = new IntRange(0, this.f40334g - 1).iterator();
        while (e2.hasNext()) {
            int nextInt = e2.nextInt();
            int[] iArr = this.f40331d;
            int i2 = iArr[nextInt];
            if (i2 >= 0) {
                this.f40332e[i2] = 0;
                iArr[nextInt] = -1;
            }
        }
        ListBuilderKt.d(this.f40329b, 0, this.f40334g);
        V[] vArr = this.f40330c;
        if (vArr != null) {
            ListBuilderKt.d(vArr, 0, this.f40334g);
        }
        this.f40336i = 0;
        this.f40334g = 0;
    }

    public boolean containsKey(Object obj) {
        return s(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return t(obj) >= 0;
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return v();
    }

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof Map) && o((Map) obj))) {
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int s2 = s(obj);
        if (s2 < 0) {
            return null;
        }
        V[] vArr = this.f40330c;
        Intrinsics.c(vArr);
        return vArr[s2];
    }

    public final int h(K k2) {
        k();
        while (true) {
            int A = A(k2);
            int d2 = RangesKt___RangesKt.d(this.f40333f * 2, w() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.f40332e[A];
                if (i3 <= 0) {
                    if (this.f40334g >= u()) {
                        q(1);
                    } else {
                        int i4 = this.f40334g;
                        int i5 = i4 + 1;
                        this.f40334g = i5;
                        this.f40329b[i4] = k2;
                        this.f40331d[i4] = A;
                        this.f40332e[A] = i5;
                        this.f40336i = size() + 1;
                        if (i2 > this.f40333f) {
                            this.f40333f = i2;
                        }
                        return i4;
                    }
                } else if (Intrinsics.a(this.f40329b[i3 - 1], k2)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > d2) {
                        F(w() * 2);
                        break;
                    }
                    int i6 = A - 1;
                    if (A == 0) {
                        A = w() - 1;
                    } else {
                        A = i6;
                    }
                }
            }
        }
    }

    public int hashCode() {
        EntriesItr r2 = r();
        int i2 = 0;
        while (r2.hasNext()) {
            i2 += r2.j();
        }
        return i2;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map<K, V> j() {
        k();
        this.f40340m = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = f40328o;
        Intrinsics.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void k() {
        if (this.f40340m) {
            throw new UnsupportedOperationException();
        }
    }

    public final /* bridge */ Set<K> keySet() {
        return x();
    }

    public final boolean m(Collection<?> collection) {
        Intrinsics.f(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!n((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean n(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "entry");
        int s2 = s(entry.getKey());
        if (s2 < 0) {
            return false;
        }
        V[] vArr = this.f40330c;
        Intrinsics.c(vArr);
        return Intrinsics.a(vArr[s2], entry.getValue());
    }

    public V put(K k2, V v2) {
        k();
        int h2 = h(k2);
        V[] i2 = i();
        if (h2 < 0) {
            int i3 = (-h2) - 1;
            V v3 = i2[i3];
            i2[i3] = v2;
            return v3;
        }
        i2[h2] = v2;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "from");
        k();
        C(map.entrySet());
    }

    public final EntriesItr<K, V> r() {
        return new EntriesItr<>(this);
    }

    public V remove(Object obj) {
        int I = I(obj);
        if (I < 0) {
            return null;
        }
        V[] vArr = this.f40330c;
        Intrinsics.c(vArr);
        V v2 = vArr[I];
        ListBuilderKt.c(vArr, I);
        return v2;
    }

    public final /* bridge */ int size() {
        return y();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr r2 = r();
        int i2 = 0;
        while (r2.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            r2.i(sb);
            i2++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "sb.toString()");
        return sb2;
    }

    public final int u() {
        return this.f40329b.length;
    }

    public Set<Map.Entry<K, V>> v() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.f40339l;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.f40339l = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    public final /* bridge */ Collection<V> values() {
        return z();
    }

    public Set<K> x() {
        MapBuilderKeys<K> mapBuilderKeys = this.f40337j;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.f40337j = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public int y() {
        return this.f40336i;
    }

    public Collection<V> z() {
        MapBuilderValues<V> mapBuilderValues = this.f40338k;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.f40338k = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i2) {
        this(ListBuilderKt.a(i2), (V[]) null, new int[i2], new int[f40327n.c(i2)], 2, 0);
    }
}
