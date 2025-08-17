package androidx.collection;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: i  reason: collision with root package name */
    ArrayMap<K, V>.EntrySet f1669i;

    /* renamed from: j  reason: collision with root package name */
    ArrayMap<K, V>.KeySet f1670j;

    /* renamed from: k  reason: collision with root package name */
    ArrayMap<K, V>.ValueCollection f1671k;

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        public int size() {
            return ArrayMap.this.f1712d;
        }
    }

    final class KeyIterator extends IndexBasedArrayIterator<K> {
        KeyIterator() {
            super(ArrayMap.this.f1712d);
        }

        /* access modifiers changed from: protected */
        public K a(int i2) {
            return ArrayMap.this.j(i2);
        }

        /* access modifiers changed from: protected */
        public void b(int i2) {
            ArrayMap.this.l(i2);
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        int f1675b;

        /* renamed from: c  reason: collision with root package name */
        int f1676c = -1;

        /* renamed from: d  reason: collision with root package name */
        boolean f1677d;

        MapIterator() {
            this.f1675b = ArrayMap.this.f1712d - 1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1676c++;
                this.f1677d = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f1677d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpers.c(entry.getKey(), ArrayMap.this.j(this.f1676c)) || !ContainerHelpers.c(entry.getValue(), ArrayMap.this.n(this.f1676c))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.f1677d) {
                return ArrayMap.this.j(this.f1676c);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1677d) {
                return ArrayMap.this.n(this.f1676c);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1676c < this.f1675b;
        }

        public int hashCode() {
            int i2;
            if (this.f1677d) {
                Object j2 = ArrayMap.this.j(this.f1676c);
                Object n2 = ArrayMap.this.n(this.f1676c);
                int i3 = 0;
                if (j2 == null) {
                    i2 = 0;
                } else {
                    i2 = j2.hashCode();
                }
                if (n2 != null) {
                    i3 = n2.hashCode();
                }
                return i2 ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f1677d) {
                ArrayMap.this.l(this.f1676c);
                this.f1676c--;
                this.f1675b--;
                this.f1677d = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v2) {
            if (this.f1677d) {
                return ArrayMap.this.m(this.f1676c, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class ValueIterator extends IndexBasedArrayIterator<V> {
        ValueIterator() {
            super(ArrayMap.this.f1712d);
        }

        /* access modifiers changed from: protected */
        public V a(int i2) {
            return ArrayMap.this.n(i2);
        }

        /* access modifiers changed from: protected */
        public void b(int i2) {
            ArrayMap.this.l(i2);
        }
    }

    public ArrayMap() {
    }

    static <T> boolean p(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        ArrayMap<K, V>.EntrySet entrySet = this.f1669i;
        if (entrySet != null) {
            return entrySet;
        }
        ArrayMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.f1669i = entrySet2;
        return entrySet2;
    }

    public Set<K> keySet() {
        ArrayMap<K, V>.KeySet keySet = this.f1670j;
        if (keySet != null) {
            return keySet;
        }
        ArrayMap<K, V>.KeySet keySet2 = new KeySet();
        this.f1670j = keySet2;
        return keySet2;
    }

    public boolean o(Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        d(this.f1712d + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean q(Collection<?> collection) {
        int i2 = this.f1712d;
        for (Object remove : collection) {
            remove(remove);
        }
        if (i2 != this.f1712d) {
            return true;
        }
        return false;
    }

    public boolean r(Collection<?> collection) {
        int i2 = this.f1712d;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (!collection.contains(j(i3))) {
                l(i3);
            }
        }
        if (i2 != this.f1712d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public <T> T[] s(T[] tArr, int i2) {
        int i3 = this.f1712d;
        if (tArr.length < i3) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            tArr[i4] = this.f1711c[(i4 << 1) + i2];
        }
        if (tArr.length > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }

    public Collection<V> values() {
        ArrayMap<K, V>.ValueCollection valueCollection = this.f1671k;
        if (valueCollection != null) {
            return valueCollection;
        }
        ArrayMap<K, V>.ValueCollection valueCollection2 = new ValueCollection();
        this.f1671k = valueCollection2;
        return valueCollection2;
    }

    public ArrayMap(int i2) {
        super(i2);
    }

    final class KeySet implements Set<K> {
        KeySet() {
        }

        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return ArrayMap.this.o(collection);
        }

        public boolean equals(Object obj) {
            return ArrayMap.p(this, obj);
        }

        public int hashCode() {
            int i2;
            int i3 = 0;
            for (int i4 = ArrayMap.this.f1712d - 1; i4 >= 0; i4--) {
                Object j2 = ArrayMap.this.j(i4);
                if (j2 == null) {
                    i2 = 0;
                } else {
                    i2 = j2.hashCode();
                }
                i3 += i2;
            }
            return i3;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        public boolean remove(Object obj) {
            int g2 = ArrayMap.this.g(obj);
            if (g2 < 0) {
                return false;
            }
            ArrayMap.this.l(g2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return ArrayMap.this.q(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return ArrayMap.this.r(collection);
        }

        public int size() {
            return ArrayMap.this.f1712d;
        }

        public Object[] toArray() {
            int i2 = ArrayMap.this.f1712d;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = ArrayMap.this.j(i3);
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            return ArrayMap.this.s(tArr, 0);
        }
    }

    final class ValueCollection implements Collection<V> {
        ValueCollection() {
        }

        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object obj) {
            return ArrayMap.this.i(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        public boolean remove(Object obj) {
            int i2 = ArrayMap.this.i(obj);
            if (i2 < 0) {
                return false;
            }
            ArrayMap.this.l(i2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i2 = ArrayMap.this.f1712d;
            int i3 = 0;
            boolean z2 = false;
            while (i3 < i2) {
                if (collection.contains(ArrayMap.this.n(i3))) {
                    ArrayMap.this.l(i3);
                    i3--;
                    i2--;
                    z2 = true;
                }
                i3++;
            }
            return z2;
        }

        public boolean retainAll(Collection<?> collection) {
            int i2 = ArrayMap.this.f1712d;
            int i3 = 0;
            boolean z2 = false;
            while (i3 < i2) {
                if (!collection.contains(ArrayMap.this.n(i3))) {
                    ArrayMap.this.l(i3);
                    i3--;
                    i2--;
                    z2 = true;
                }
                i3++;
            }
            return z2;
        }

        public int size() {
            return ArrayMap.this.f1712d;
        }

        public Object[] toArray() {
            int i2 = ArrayMap.this.f1712d;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = ArrayMap.this.n(i3);
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            return ArrayMap.this.s(tArr, 1);
        }
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
