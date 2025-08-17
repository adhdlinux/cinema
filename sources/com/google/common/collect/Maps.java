package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Maps {

    private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            /* renamed from: b */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            /* renamed from: b */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        /* access modifiers changed from: package-private */
        public abstract Map<K, V> a();

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object j2 = Maps.j(a(), key);
            if (!Objects.a(j2, entry.getValue())) {
                return false;
            }
            if (j2 != null || a().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            return a().keySet().remove(((Map.Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.l(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.j(this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.l(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet g2 = Sets.g(collection.size());
                for (Object next : collection) {
                    if (contains(next) && (next instanceof Map.Entry)) {
                        g2.add(((Map.Entry) next).getKey());
                    }
                }
                return a().keySet().retainAll(g2);
            }
        }

        public int size() {
            return a().size();
        }
    }

    static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
        @Weak

        /* renamed from: b  reason: collision with root package name */
        final Map<K, V> f30627b;

        KeySet(Map<K, V> map) {
            this.f30627b = (Map) Preconditions.l(map);
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> a() {
            return this.f30627b;
        }

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public Iterator<K> iterator() {
            return Maps.f(a().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            a().remove(obj);
            return true;
        }

        public int size() {
            return a().size();
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        @Weak

        /* renamed from: b  reason: collision with root package name */
        final Map<K, V> f30628b;

        Values(Map<K, V> map) {
            this.f30628b = (Map) Preconditions.l(map);
        }

        /* access modifiers changed from: package-private */
        public final Map<K, V> a() {
            return this.f30628b;
        }

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public Iterator<V> iterator() {
            return Maps.n(a().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : a().entrySet()) {
                    if (Objects.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.l(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f2 = Sets.f();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        f2.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(f2);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.l(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f2 = Sets.f();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        f2.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(f2);
            }
        }

        public int size() {
            return a().size();
        }
    }

    static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f30629b;

        /* renamed from: c  reason: collision with root package name */
        private transient Set<K> f30630c;

        /* renamed from: d  reason: collision with root package name */
        private transient Collection<V> f30631d;

        ViewCachingAbstractMap() {
        }

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> a();

        /* access modifiers changed from: package-private */
        public Set<K> b() {
            return new KeySet(this);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> d() {
            return new Values(this);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f30629b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a2 = a();
            this.f30629b = a2;
            return a2;
        }

        public Set<K> keySet() {
            Set<K> set = this.f30630c;
            if (set != null) {
                return set;
            }
            Set<K> b2 = b();
            this.f30630c = b2;
            return b2;
        }

        public Collection<V> values() {
            Collection<V> collection = this.f30631d;
            if (collection != null) {
                return collection;
            }
            Collection<V> d2 = d();
            this.f30631d = d2;
            return d2;
        }
    }

    private Maps() {
    }

    static int a(int i2) {
        if (i2 < 3) {
            CollectPreconditions.b(i2, "expectedSize");
            return i2 + 1;
        } else if (i2 < 1073741824) {
            return (int) Math.ceil(((double) i2) / 0.75d);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    static boolean b(Map<?, ?> map, Object obj) {
        return Iterators.d(n(map.entrySet().iterator()), obj);
    }

    static boolean c(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> d(K k2, V v2) {
        return new ImmutableEntry(k2, v2);
    }

    static <K> Function<Map.Entry<K, ?>, K> e() {
        return EntryFunction.KEY;
    }

    static <K, V> Iterator<K> f(Iterator<Map.Entry<K, V>> it2) {
        return new TransformedIterator<Map.Entry<K, V>, K>(it2) {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public K a(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    public static <K, V> HashMap<K, V> g(int i2) {
        return new HashMap<>(a(i2));
    }

    public static <K, V> IdentityHashMap<K, V> h() {
        return new IdentityHashMap<>();
    }

    static boolean i(Map<?, ?> map, Object obj) {
        Preconditions.l(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V j(Map<?, V> map, Object obj) {
        Preconditions.l(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static <V> V k(Map<?, V> map, Object obj) {
        Preconditions.l(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static String l(Map<?, ?> map) {
        StringBuilder b2 = Collections2.b(map.size());
        b2.append('{');
        boolean z2 = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z2) {
                b2.append(", ");
            }
            b2.append(next.getKey());
            b2.append('=');
            b2.append(next.getValue());
            z2 = false;
        }
        b2.append('}');
        return b2.toString();
    }

    static <V> Function<Map.Entry<?, V>, V> m() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<V> n(Iterator<Map.Entry<K, V>> it2) {
        return new TransformedIterator<Map.Entry<K, V>, V>(it2) {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }
}
