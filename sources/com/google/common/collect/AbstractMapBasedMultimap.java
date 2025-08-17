package com.google.common.collect;

import WrappedCollection.WrappedIterator;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public transient Map<K, Collection<V>> f30434f;

    /* renamed from: g  reason: collision with root package name */
    private transient int f30435g;

    private class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* renamed from: e  reason: collision with root package name */
        final transient Map<K, Collection<V>> f30436e;

        class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            /* access modifiers changed from: package-private */
            public Map<K, Collection<V>> a() {
                return AsMap.this;
            }

            public boolean contains(Object obj) {
                return Collections2.c(AsMap.this.f30436e.entrySet(), obj);
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.v(entry.getKey());
                return true;
            }
        }

        class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: b  reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f30439b;

            /* renamed from: c  reason: collision with root package name */
            Collection<V> f30440c;

            AsMapIterator() {
                this.f30439b = AsMap.this.f30436e.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry next = this.f30439b.next();
                this.f30440c = (Collection) next.getValue();
                return AsMap.this.g(next);
            }

            public boolean hasNext() {
                return this.f30439b.hasNext();
            }

            public void remove() {
                boolean z2;
                if (this.f30440c != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.r(z2, "no calls to next() since the last call to remove()");
                this.f30439b.remove();
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, this.f30440c.size());
                this.f30440c.clear();
                this.f30440c = null;
            }
        }

        AsMap(Map<K, Collection<V>> map) {
            this.f30436e = map;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new AsMapEntries();
        }

        public void clear() {
            if (this.f30436e == AbstractMapBasedMultimap.this.f30434f) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.c(new AsMapIterator());
            }
        }

        public boolean containsKey(Object obj) {
            return Maps.i(this.f30436e, obj);
        }

        /* renamed from: e */
        public Collection<V> get(Object obj) {
            Collection collection = (Collection) Maps.j(this.f30436e, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.x(obj, collection);
        }

        public boolean equals(Object obj) {
            return this == obj || this.f30436e.equals(obj);
        }

        /* renamed from: f */
        public Collection<V> remove(Object obj) {
            Collection remove = this.f30436e.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> q2 = AbstractMapBasedMultimap.this.q();
            q2.addAll(remove);
            AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return q2;
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> g(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.d(key, AbstractMapBasedMultimap.this.x(key, entry.getValue()));
        }

        public int hashCode() {
            return this.f30436e.hashCode();
        }

        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public int size() {
            return this.f30436e.size();
        }

        public String toString() {
            return this.f30436e.toString();
        }
    }

    private abstract class Itr<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f30442b;

        /* renamed from: c  reason: collision with root package name */
        K f30443c = null;

        /* renamed from: d  reason: collision with root package name */
        Collection<V> f30444d = null;

        /* renamed from: e  reason: collision with root package name */
        Iterator<V> f30445e = Iterators.h();

        Itr() {
            this.f30442b = AbstractMapBasedMultimap.this.f30434f.entrySet().iterator();
        }

        /* access modifiers changed from: package-private */
        public abstract T a(K k2, V v2);

        public boolean hasNext() {
            return this.f30442b.hasNext() || this.f30445e.hasNext();
        }

        public T next() {
            if (!this.f30445e.hasNext()) {
                Map.Entry next = this.f30442b.next();
                this.f30443c = next.getKey();
                Collection<V> collection = (Collection) next.getValue();
                this.f30444d = collection;
                this.f30445e = collection.iterator();
            }
            return a(NullnessCasts.a(this.f30443c), this.f30445e.next());
        }

        public void remove() {
            this.f30445e.remove();
            Collection<V> collection = this.f30444d;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f30442b.remove();
            }
            AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
        }
    }

    private class KeySet extends Maps.KeySet<K, Collection<V>> {
        KeySet(Map<K, Collection<V>> map) {
            super(map);
        }

        public void clear() {
            Iterators.c(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return a().keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        public int hashCode() {
            return a().keySet().hashCode();
        }

        public Iterator<K> iterator() {
            final Iterator it2 = a().entrySet().iterator();
            return new Iterator<K>() {

                /* renamed from: b  reason: collision with root package name */
                Map.Entry<K, Collection<V>> f30448b;

                public boolean hasNext() {
                    return it2.hasNext();
                }

                public K next() {
                    Map.Entry<K, Collection<V>> entry = (Map.Entry) it2.next();
                    this.f30448b = entry;
                    return entry.getKey();
                }

                public void remove() {
                    boolean z2;
                    if (this.f30448b != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.r(z2, "no calls to next() since the last call to remove()");
                    Collection value = this.f30448b.getValue();
                    it2.remove();
                    AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, value.size());
                    value.clear();
                    this.f30448b = null;
                }
            };
        }

        public boolean remove(Object obj) {
            int i2;
            Collection collection = (Collection) a().remove(obj);
            if (collection != null) {
                i2 = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, i2);
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                return true;
            }
            return false;
        }
    }

    private final class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        NavigableAsMap(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        public Map.Entry<K, Collection<V>> ceilingEntry(K k2) {
            Map.Entry ceilingEntry = j().ceilingEntry(k2);
            if (ceilingEntry == null) {
                return null;
            }
            return g(ceilingEntry);
        }

        public K ceilingKey(K k2) {
            return j().ceilingKey(k2);
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(j().descendingMap());
        }

        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry firstEntry = j().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return g(firstEntry);
        }

        public Map.Entry<K, Collection<V>> floorEntry(K k2) {
            Map.Entry floorEntry = j().floorEntry(k2);
            if (floorEntry == null) {
                return null;
            }
            return g(floorEntry);
        }

        public K floorKey(K k2) {
            return j().floorKey(k2);
        }

        public Map.Entry<K, Collection<V>> higherEntry(K k2) {
            Map.Entry higherEntry = j().higherEntry(k2);
            if (higherEntry == null) {
                return null;
            }
            return g(higherEntry);
        }

        public K higherKey(K k2) {
            return j().higherKey(k2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public NavigableSet<K> h() {
            return new NavigableKeySet(j());
        }

        /* renamed from: l */
        public NavigableMap<K, Collection<V>> headMap(K k2) {
            return headMap(k2, false);
        }

        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry lastEntry = j().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return g(lastEntry);
        }

        public Map.Entry<K, Collection<V>> lowerEntry(K k2) {
            Map.Entry lowerEntry = j().lowerEntry(k2);
            if (lowerEntry == null) {
                return null;
            }
            return g(lowerEntry);
        }

        public K lowerKey(K k2) {
            return j().lowerKey(k2);
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it2) {
            if (!it2.hasNext()) {
                return null;
            }
            Map.Entry next = it2.next();
            Collection q2 = AbstractMapBasedMultimap.this.q();
            q2.addAll((Collection) next.getValue());
            it2.remove();
            return Maps.d(next.getKey(), AbstractMapBasedMultimap.this.w(q2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> j() {
            return (NavigableMap) super.j();
        }

        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(K k2, K k3) {
            return subMap(k2, true, k3, false);
        }

        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k2) {
            return tailMap(k2, true);
        }

        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        public NavigableMap<K, Collection<V>> headMap(K k2, boolean z2) {
            return new NavigableAsMap(j().headMap(k2, z2));
        }

        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        public NavigableMap<K, Collection<V>> subMap(K k2, boolean z2, K k3, boolean z3) {
            return new NavigableAsMap(j().subMap(k2, z2, k3, z3));
        }

        public NavigableMap<K, Collection<V>> tailMap(K k2, boolean z2) {
            return new NavigableAsMap(j().tailMap(k2, z2));
        }
    }

    private final class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* renamed from: c */
        public NavigableSet<K> headSet(K k2) {
            return headSet(k2, false);
        }

        public K ceiling(K k2) {
            return b().ceilingKey(k2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(b().descendingMap());
        }

        /* renamed from: e */
        public NavigableSet<K> subSet(K k2, K k3) {
            return subSet(k2, true, k3, false);
        }

        public K floor(K k2) {
            return b().floorKey(k2);
        }

        /* renamed from: g */
        public NavigableSet<K> tailSet(K k2) {
            return tailSet(k2, true);
        }

        public K higher(K k2) {
            return b().higherKey(k2);
        }

        public K lower(K k2) {
            return b().lowerKey(k2);
        }

        public K pollFirst() {
            return Iterators.p(iterator());
        }

        public K pollLast() {
            return Iterators.p(descendingIterator());
        }

        public NavigableSet<K> headSet(K k2, boolean z2) {
            return new NavigableKeySet(b().headMap(k2, z2));
        }

        public NavigableSet<K> subSet(K k2, boolean z2, K k3, boolean z3) {
            return new NavigableKeySet(b().subMap(k2, z2, k3, z3));
        }

        public NavigableSet<K> tailSet(K k2, boolean z2) {
            return new NavigableKeySet(b().tailMap(k2, z2));
        }
    }

    private class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        RandomAccessWrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, K k2, List<V> list, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k2, list, wrappedCollection);
        }
    }

    private class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {

        /* renamed from: g  reason: collision with root package name */
        SortedSet<K> f30453g;

        SortedAsMap(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        public K firstKey() {
            return j().firstKey();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public SortedSet<K> b() {
            return new SortedKeySet(j());
        }

        public SortedMap<K, Collection<V>> headMap(K k2) {
            return new SortedAsMap(j().headMap(k2));
        }

        /* renamed from: i */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f30453g;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> h2 = b();
            this.f30453g = h2;
            return h2;
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> j() {
            return (SortedMap) this.f30436e;
        }

        public K lastKey() {
            return j().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k2, K k3) {
            return new SortedAsMap(j().subMap(k2, k3));
        }

        public SortedMap<K, Collection<V>> tailMap(K k2) {
            return new SortedAsMap(j().tailMap(k2));
        }
    }

    private class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.a();
        }

        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K k2) {
            return new SortedKeySet(b().headMap(k2));
        }

        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k2, K k3) {
            return new SortedKeySet(b().subMap(k2, k3));
        }

        public SortedSet<K> tailSet(K k2) {
            return new SortedKeySet(b().tailMap(k2));
        }
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.d(map.isEmpty());
        this.f30434f = map;
    }

    static /* synthetic */ int l(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.f30435g;
        abstractMapBasedMultimap.f30435g = i2 + 1;
        return i2;
    }

    static /* synthetic */ int m(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.f30435g;
        abstractMapBasedMultimap.f30435g = i2 - 1;
        return i2;
    }

    static /* synthetic */ int n(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.f30435g + i2;
        abstractMapBasedMultimap.f30435g = i3;
        return i3;
    }

    static /* synthetic */ int o(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.f30435g - i2;
        abstractMapBasedMultimap.f30435g = i3;
        return i3;
    }

    /* access modifiers changed from: private */
    public static <E> Iterator<E> u(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* access modifiers changed from: private */
    public void v(Object obj) {
        Collection collection = (Collection) Maps.k(this.f30434f, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f30435g -= size;
        }
    }

    public Collection<Map.Entry<K, V>> a() {
        return super.a();
    }

    public void clear() {
        for (Collection<V> clear : this.f30434f.values()) {
            clear.clear();
        }
        this.f30434f.clear();
        this.f30435g = 0;
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> d() {
        return new AsMap(this.f30434f);
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> e() {
        return new AbstractMultimap.Entries();
    }

    /* access modifiers changed from: package-private */
    public Set<K> f() {
        return new KeySet(this.f30434f);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> g() {
        return new AbstractMultimap.Values();
    }

    public Collection<V> get(K k2) {
        Collection collection = this.f30434f.get(k2);
        if (collection == null) {
            collection = r(k2);
        }
        return x(k2, collection);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> h() {
        return new AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>(this) {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<K, V> a(K k2, V v2) {
                return Maps.d(k2, v2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> i() {
        return new AbstractMapBasedMultimap<K, V>.Itr<V>(this) {
            /* access modifiers changed from: package-private */
            public V a(K k2, V v2) {
                return v2;
            }
        };
    }

    public boolean put(K k2, V v2) {
        Collection collection = this.f30434f.get(k2);
        if (collection == null) {
            Collection r2 = r(k2);
            if (r2.add(v2)) {
                this.f30435g++;
                this.f30434f.put(k2, r2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v2)) {
            return false;
        } else {
            this.f30435g++;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Collection<V> q();

    /* access modifiers changed from: package-private */
    public Collection<V> r(K k2) {
        return q();
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> s() {
        Map<K, Collection<V>> map = this.f30434f;
        if (map instanceof NavigableMap) {
            return new NavigableAsMap((NavigableMap) this.f30434f);
        }
        if (map instanceof SortedMap) {
            return new SortedAsMap((SortedMap) this.f30434f);
        }
        return new AsMap(this.f30434f);
    }

    public int size() {
        return this.f30435g;
    }

    /* access modifiers changed from: package-private */
    public final Set<K> t() {
        Map<K, Collection<V>> map = this.f30434f;
        if (map instanceof NavigableMap) {
            return new NavigableKeySet((NavigableMap) this.f30434f);
        }
        if (map instanceof SortedMap) {
            return new SortedKeySet((SortedMap) this.f30434f);
        }
        return new KeySet(this.f30434f);
    }

    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> w(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> x(K k2, Collection<V> collection) {
        return new WrappedCollection(k2, collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    /* access modifiers changed from: package-private */
    public final List<V> y(K k2, List<V> list, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
        if (list instanceof RandomAccess) {
            return new RandomAccessWrappedList(this, k2, list, wrappedCollection);
        }
        return new WrappedList(k2, list, wrappedCollection);
    }

    class WrappedCollection extends AbstractCollection<V> {

        /* renamed from: b  reason: collision with root package name */
        final K f30456b;

        /* renamed from: c  reason: collision with root package name */
        Collection<V> f30457c;

        /* renamed from: d  reason: collision with root package name */
        final AbstractMapBasedMultimap<K, V>.WrappedCollection f30458d;

        /* renamed from: e  reason: collision with root package name */
        final Collection<V> f30459e;

        WrappedCollection(K k2, Collection<V> collection, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            Collection<V> collection2;
            this.f30456b = k2;
            this.f30457c = collection;
            this.f30458d = wrappedCollection;
            if (wrappedCollection == null) {
                collection2 = null;
            } else {
                collection2 = wrappedCollection.c();
            }
            this.f30459e = collection2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.f30458d;
            if (wrappedCollection != null) {
                wrappedCollection.a();
            } else {
                AbstractMapBasedMultimap.this.f30434f.put(this.f30456b, this.f30457c);
            }
        }

        public boolean add(V v2) {
            e();
            boolean isEmpty = this.f30457c.isEmpty();
            boolean add = this.f30457c.add(v2);
            if (add) {
                AbstractMapBasedMultimap.l(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f30457c.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this, this.f30457c.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        /* access modifiers changed from: package-private */
        public AbstractMapBasedMultimap<K, V>.WrappedCollection b() {
            return this.f30458d;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return this.f30457c;
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.f30457c.clear();
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, size);
                g();
            }
        }

        public boolean contains(Object obj) {
            e();
            return this.f30457c.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f30457c.containsAll(collection);
        }

        /* access modifiers changed from: package-private */
        public K d() {
            return this.f30456b;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.f30458d;
            if (wrappedCollection != null) {
                wrappedCollection.e();
                if (this.f30458d.c() != this.f30459e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f30457c.isEmpty() && (collection = (Collection) AbstractMapBasedMultimap.this.f30434f.get(this.f30456b)) != null) {
                this.f30457c = collection;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f30457c.equals(obj);
        }

        /* access modifiers changed from: package-private */
        public void g() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.f30458d;
            if (wrappedCollection != null) {
                wrappedCollection.g();
            } else if (this.f30457c.isEmpty()) {
                AbstractMapBasedMultimap.this.f30434f.remove(this.f30456b);
            }
        }

        public int hashCode() {
            e();
            return this.f30457c.hashCode();
        }

        public Iterator<V> iterator() {
            e();
            return new WrappedIterator();
        }

        public boolean remove(Object obj) {
            e();
            boolean remove = this.f30457c.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
                g();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f30457c.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this, this.f30457c.size() - size);
                g();
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.l(collection);
            int size = size();
            boolean retainAll = this.f30457c.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this, this.f30457c.size() - size);
                g();
            }
            return retainAll;
        }

        public int size() {
            e();
            return this.f30457c.size();
        }

        public String toString() {
            e();
            return this.f30457c.toString();
        }

        class WrappedIterator implements Iterator<V> {

            /* renamed from: b  reason: collision with root package name */
            final Iterator<V> f30461b;

            /* renamed from: c  reason: collision with root package name */
            final Collection<V> f30462c;

            WrappedIterator() {
                Collection<V> collection = WrappedCollection.this.f30457c;
                this.f30462c = collection;
                this.f30461b = AbstractMapBasedMultimap.u(collection);
            }

            /* access modifiers changed from: package-private */
            public Iterator<V> a() {
                b();
                return this.f30461b;
            }

            /* access modifiers changed from: package-private */
            public void b() {
                WrappedCollection.this.e();
                if (WrappedCollection.this.f30457c != this.f30462c) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                b();
                return this.f30461b.hasNext();
            }

            public V next() {
                b();
                return this.f30461b.next();
            }

            public void remove() {
                this.f30461b.remove();
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
                WrappedCollection.this.g();
            }

            WrappedIterator(Iterator<V> it2) {
                this.f30462c = WrappedCollection.this.f30457c;
                this.f30461b = it2;
            }
        }
    }

    class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {

        private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            /* JADX WARNING: type inference failed for: r1v0, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedList$WrappedListIterator, com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator] */
            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            public void add(V v2) {
                boolean isEmpty = WrappedList.this.isEmpty();
                c().add(v2);
                AbstractMapBasedMultimap.l(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    WrappedList.this.a();
                }
            }

            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            public int nextIndex() {
                return c().nextIndex();
            }

            public V previous() {
                return c().previous();
            }

            public int previousIndex() {
                return c().previousIndex();
            }

            public void set(V v2) {
                c().set(v2);
            }

            public WrappedListIterator(int i2) {
                super(WrappedList.this.h().listIterator(i2));
            }
        }

        WrappedList(K k2, List<V> list, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k2, list, wrappedCollection);
        }

        public void add(int i2, V v2) {
            e();
            boolean isEmpty = c().isEmpty();
            h().add(i2, v2);
            AbstractMapBasedMultimap.l(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        public boolean addAll(int i2, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = h().addAll(i2, collection);
            if (addAll) {
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        public V get(int i2) {
            e();
            return h().get(i2);
        }

        /* access modifiers changed from: package-private */
        public List<V> h() {
            return (List) c();
        }

        public int indexOf(Object obj) {
            e();
            return h().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            e();
            return h().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            e();
            return new WrappedListIterator();
        }

        public V remove(int i2) {
            e();
            V remove = h().remove(i2);
            AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
            g();
            return remove;
        }

        public V set(int i2, V v2) {
            e();
            return h().set(i2, v2);
        }

        public List<V> subList(int i2, int i3) {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
            e();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object d2 = d();
            List subList = h().subList(i2, i3);
            if (b() == null) {
                wrappedCollection = this;
            } else {
                wrappedCollection = b();
            }
            return abstractMapBasedMultimap.y(d2, subList, wrappedCollection);
        }

        public ListIterator<V> listIterator(int i2) {
            e();
            return new WrappedListIterator(i2);
        }
    }
}
