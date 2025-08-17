package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> f30530f;

    /* renamed from: g  reason: collision with root package name */
    final transient int f30531g;

    public static class Builder<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final Map<K, Collection<V>> f30539a = Platform.d();

        /* renamed from: b  reason: collision with root package name */
        Comparator<? super K> f30540b;

        /* renamed from: c  reason: collision with root package name */
        Comparator<? super V> f30541c;

        public ImmutableMultimap<K, V> a() {
            Collection entrySet = this.f30539a.entrySet();
            Comparator comparator = this.f30540b;
            if (comparator != null) {
                entrySet = Ordering.b(comparator).e().c(entrySet);
            }
            return ImmutableListMultimap.s(entrySet, this.f30541c);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> b() {
            return new ArrayList();
        }

        public Builder<K, V> c(K k2, V v2) {
            CollectPreconditions.a(k2, v2);
            Collection collection = this.f30539a.get(k2);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f30539a;
                Collection b2 = b();
                map.put(k2, b2);
                collection = b2;
            }
            collection.add(v2);
            return this;
        }
    }

    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        @Weak

        /* renamed from: c  reason: collision with root package name */
        final ImmutableMultimap<K, V> f30542c;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.f30542c = immutableMultimap;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f30542c.b(entry.getKey(), entry.getValue());
        }

        /* renamed from: h */
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.f30542c.h();
        }

        public int size() {
            return this.f30542c.size();
        }
    }

    private static final class Values<K, V> extends ImmutableCollection<V> {
        @Weak

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableMultimap<K, V> f30543c;

        Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f30543c = immutableMultimap;
        }

        /* access modifiers changed from: package-private */
        public int b(Object[] objArr, int i2) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> h2 = this.f30543c.f30530f.values().iterator();
            while (h2.hasNext()) {
                i2 = ((ImmutableCollection) h2.next()).b(objArr, i2);
            }
            return i2;
        }

        public boolean contains(Object obj) {
            return this.f30543c.c(obj);
        }

        /* renamed from: h */
        public UnmodifiableIterator<V> iterator() {
            return this.f30543c.i();
        }

        public int size() {
            return this.f30543c.size();
        }
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i2) {
        this.f30530f = immutableMap;
        this.f30531g = i2;
    }

    public /* bridge */ /* synthetic */ boolean b(Object obj, Object obj2) {
        return super.b(obj, obj2);
    }

    public boolean c(Object obj) {
        return obj != null && super.c(obj);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> d() {
        throw new AssertionError("should never be called");
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public Set<K> f() {
        throw new AssertionError("unreachable");
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: j */
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.f30530f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public ImmutableCollection<Map.Entry<K, V>> e() {
        return new EntryCollection(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public ImmutableCollection<V> g() {
        return new Values(this);
    }

    /* renamed from: m */
    public ImmutableCollection<Map.Entry<K, V>> a() {
        return (ImmutableCollection) super.a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public UnmodifiableIterator<Map.Entry<K, V>> h() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {

            /* renamed from: b  reason: collision with root package name */
            final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f30532b;

            /* renamed from: c  reason: collision with root package name */
            K f30533c = null;

            /* renamed from: d  reason: collision with root package name */
            Iterator<V> f30534d = Iterators.f();

            {
                this.f30532b = ImmutableMultimap.this.f30530f.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (!this.f30534d.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f30532b.next();
                    this.f30533c = entry.getKey();
                    this.f30534d = ((ImmutableCollection) entry.getValue()).iterator();
                }
                K k2 = this.f30533c;
                Objects.requireNonNull(k2);
                return Maps.d(k2, this.f30534d.next());
            }

            public boolean hasNext() {
                return this.f30534d.hasNext() || this.f30532b.hasNext();
            }
        };
    }

    /* renamed from: o */
    public abstract ImmutableCollection<V> get(K k2);

    /* renamed from: p */
    public ImmutableSet<K> keySet() {
        return this.f30530f.keySet();
    }

    @Deprecated
    public final boolean put(K k2, V v2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public UnmodifiableIterator<V> i() {
        return new UnmodifiableIterator<V>() {

            /* renamed from: b  reason: collision with root package name */
            Iterator<? extends ImmutableCollection<V>> f30536b;

            /* renamed from: c  reason: collision with root package name */
            Iterator<V> f30537c = Iterators.f();

            {
                this.f30536b = ImmutableMultimap.this.f30530f.values().iterator();
            }

            public boolean hasNext() {
                return this.f30537c.hasNext() || this.f30536b.hasNext();
            }

            public V next() {
                if (!this.f30537c.hasNext()) {
                    this.f30537c = ((ImmutableCollection) this.f30536b.next()).iterator();
                }
                return this.f30537c.next();
            }
        };
    }

    /* renamed from: r */
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f30531g;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
