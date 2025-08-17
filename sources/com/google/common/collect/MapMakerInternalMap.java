package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* renamed from: k  reason: collision with root package name */
    static final WeakValueReference<Object, Object, DummyInternalEntry> f30571k = new WeakValueReference<Object, Object, DummyInternalEntry>() {
        /* renamed from: c */
        public WeakValueReference<Object, Object, DummyInternalEntry> b(ReferenceQueue<Object> referenceQueue, DummyInternalEntry dummyInternalEntry) {
            return this;
        }

        public void clear() {
        }

        /* renamed from: d */
        public DummyInternalEntry a() {
            return null;
        }

        public Object get() {
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final transient int f30572b;

    /* renamed from: c  reason: collision with root package name */
    final transient int f30573c;

    /* renamed from: d  reason: collision with root package name */
    final transient Segment<K, V, E, S>[] f30574d;

    /* renamed from: e  reason: collision with root package name */
    final int f30575e;

    /* renamed from: f  reason: collision with root package name */
    final Equivalence<Object> f30576f;

    /* renamed from: g  reason: collision with root package name */
    final transient InternalEntryHelper<K, V, E, S> f30577g;

    /* renamed from: h  reason: collision with root package name */
    transient Set<K> f30578h;

    /* renamed from: i  reason: collision with root package name */
    transient Collection<V> f30579i;

    /* renamed from: j  reason: collision with root package name */
    transient Set<Map.Entry<K, V>> f30580j;

    static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final K f30581a;

        /* renamed from: b  reason: collision with root package name */
        final int f30582b;

        AbstractStrongKeyEntry(K k2, int i2) {
            this.f30581a = k2;
            this.f30582b = i2;
        }

        public final int b() {
            return this.f30582b;
        }

        public E c() {
            return null;
        }

        public final K getKey() {
            return this.f30581a;
        }
    }

    static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final int f30583a;

        AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(k2, referenceQueue);
            this.f30583a = i2;
        }

        public final int b() {
            return this.f30583a;
        }

        public E c() {
            return null;
        }

        public final K getKey() {
            return get();
        }
    }

    static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        private DummyInternalEntry() {
            throw new AssertionError();
        }

        public int b() {
            throw new AssertionError();
        }

        /* renamed from: d */
        public DummyInternalEntry c() {
            throw new AssertionError();
        }

        public Object getKey() {
            throw new AssertionError();
        }

        public Object getValue() {
            throw new AssertionError();
        }
    }

    final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean contains(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x000f
                return r1
            L_0x000f:
                com.google.common.collect.MapMakerInternalMap r2 = com.google.common.collect.MapMakerInternalMap.this
                java.lang.Object r0 = r2.get(r0)
                if (r0 == 0) goto L_0x0028
                com.google.common.collect.MapMakerInternalMap r2 = com.google.common.collect.MapMakerInternalMap.this
                com.google.common.base.Equivalence r2 = r2.n()
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.d(r4, r0)
                if (r4 == 0) goto L_0x0028
                r1 = 1
            L_0x0028:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.EntrySet.contains(java.lang.Object):boolean");
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(MapMakerInternalMap.this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 == 0) goto L_0x001b
                com.google.common.collect.MapMakerInternalMap r2 = com.google.common.collect.MapMakerInternalMap.this
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.remove(r0, r4)
                if (r4 == 0) goto L_0x001b
                r1 = 1
            L_0x001b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.EntrySet.remove(java.lang.Object):boolean");
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    abstract class HashIterator<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        int f30585b;

        /* renamed from: c  reason: collision with root package name */
        int f30586c = -1;

        /* renamed from: d  reason: collision with root package name */
        Segment<K, V, E, S> f30587d;

        /* renamed from: e  reason: collision with root package name */
        AtomicReferenceArray<E> f30588e;

        /* renamed from: f  reason: collision with root package name */
        E f30589f;

        /* renamed from: g  reason: collision with root package name */
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry f30590g;

        /* renamed from: h  reason: collision with root package name */
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry f30591h;

        HashIterator() {
            this.f30585b = MapMakerInternalMap.this.f30574d.length - 1;
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f30590g = null;
            if (!d() && !e()) {
                while (true) {
                    int i2 = this.f30585b;
                    if (i2 >= 0) {
                        Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.f30574d;
                        this.f30585b = i2 - 1;
                        Segment<K, V, E, S> segment = segmentArr[i2];
                        this.f30587d = segment;
                        if (segment.f30595c != 0) {
                            AtomicReferenceArray<E> atomicReferenceArray = this.f30587d.f30598f;
                            this.f30588e = atomicReferenceArray;
                            this.f30586c = atomicReferenceArray.length() - 1;
                            if (e()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public boolean b(E e2) {
            try {
                Object key = e2.getKey();
                Object e3 = MapMakerInternalMap.this.e(e2);
                if (e3 != null) {
                    this.f30590g = new WriteThroughEntry(key, e3);
                    this.f30587d.r();
                    return true;
                }
                this.f30587d.r();
                return false;
            } catch (Throwable th) {
                this.f30587d.r();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public MapMakerInternalMap<K, V, E, S>.WriteThroughEntry c() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.f30590g;
            if (writeThroughEntry != null) {
                this.f30591h = writeThroughEntry;
                a();
                return this.f30591h;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            E e2 = this.f30589f;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.f30589f = e2.c();
                E e3 = this.f30589f;
                if (e3 == null) {
                    return false;
                }
                if (b(e3)) {
                    return true;
                }
                e2 = this.f30589f;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            while (true) {
                int i2 = this.f30586c;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f30588e;
                this.f30586c = i2 - 1;
                E e2 = (InternalEntry) atomicReferenceArray.get(i2);
                this.f30589f = e2;
                if (e2 != null && (b(e2) || d())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.f30590g != null;
        }

        public void remove() {
            boolean z2;
            if (this.f30591h != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            CollectPreconditions.c(z2);
            MapMakerInternalMap.this.remove(this.f30591h.getKey());
            this.f30591h = null;
        }
    }

    interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int b();

        E c();

        K getKey();

        V getValue();
    }

    interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2);

        E b(S s2, E e2, E e3);

        Strength c();

        void d(S s2, E e2, V v2);

        E e(S s2, K k2, int i2, E e2);
    }

    final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        KeyIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        public K next() {
            return c().getKey();
        }
    }

    final class KeySet extends SafeToArraySet<K> {
        KeySet() {
            super();
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public Iterator<K> iterator() {
            return new KeyIterator(MapMakerInternalMap.this);
        }

        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        public Object[] toArray() {
            return MapMakerInternalMap.l(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.l(this).toArray(tArr);
        }
    }

    static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        @Weak

        /* renamed from: b  reason: collision with root package name */
        final MapMakerInternalMap<K, V, E, S> f30594b;

        /* renamed from: c  reason: collision with root package name */
        volatile int f30595c;

        /* renamed from: d  reason: collision with root package name */
        int f30596d;

        /* renamed from: e  reason: collision with root package name */
        int f30597e;

        /* renamed from: f  reason: collision with root package name */
        volatile AtomicReferenceArray<E> f30598f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f30599g = new AtomicInteger();

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2) {
            this.f30594b = mapMakerInternalMap;
            m(q(i2));
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean n(E e2) {
            return e2.getValue() == null;
        }

        /* access modifiers changed from: package-private */
        public boolean A(K k2, int i2, V v2, V v3) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.b() != i2 || key == null || !this.f30594b.f30576f.d(k2, key)) {
                        internalEntry2 = internalEntry2.c();
                    } else {
                        Object value = internalEntry2.getValue();
                        if (value == null) {
                            if (n(internalEntry2)) {
                                this.f30596d++;
                                atomicReferenceArray.set(length, y(internalEntry, internalEntry2));
                                this.f30595c--;
                            }
                            return false;
                        } else if (this.f30594b.n().d(v2, value)) {
                            this.f30596d++;
                            E(internalEntry2, v3);
                            unlock();
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public void B() {
            C();
        }

        /* access modifiers changed from: package-private */
        public void C() {
            if (tryLock()) {
                try {
                    p();
                    this.f30599g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract S D();

        /* access modifiers changed from: package-private */
        public void E(E e2, V v2) {
            this.f30594b.f30577g.d(D(), e2, v2);
        }

        /* access modifiers changed from: package-private */
        public void F() {
            if (tryLock()) {
                try {
                    p();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f30595c != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, (Object) null);
                    }
                    o();
                    this.f30599g.set(0);
                    this.f30596d++;
                    this.f30595c = 0;
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public <T> void b(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj, int i2) {
            try {
                boolean z2 = false;
                if (this.f30595c != 0) {
                    InternalEntry k2 = k(obj, i2);
                    if (!(k2 == null || k2.getValue() == null)) {
                        z2 = true;
                    }
                    return z2;
                }
                r();
                return false;
            } finally {
                r();
            }
        }

        /* access modifiers changed from: package-private */
        public E d(E e2, E e3) {
            return this.f30594b.f30577g.b(D(), e2, e3);
        }

        /* access modifiers changed from: package-private */
        public void e(ReferenceQueue<K> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.f30594b.h((InternalEntry) poll);
                    i2++;
                } else {
                    return;
                }
            } while (i2 != 16);
        }

        /* access modifiers changed from: package-private */
        public void f(ReferenceQueue<V> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.f30594b.i((WeakValueReference) poll);
                    i2++;
                } else {
                    return;
                }
            } while (i2 != 16);
        }

        /* access modifiers changed from: package-private */
        public void g() {
            AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i2 = this.f30595c;
                AtomicReferenceArray<E> q2 = q(length << 1);
                this.f30597e = (q2.length() * 3) / 4;
                int length2 = q2.length() - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i3);
                    if (internalEntry != null) {
                        InternalEntry c2 = internalEntry.c();
                        int b2 = internalEntry.b() & length2;
                        if (c2 == null) {
                            q2.set(b2, internalEntry);
                        } else {
                            InternalEntry internalEntry2 = internalEntry;
                            while (c2 != null) {
                                int b3 = c2.b() & length2;
                                if (b3 != b2) {
                                    internalEntry2 = c2;
                                    b2 = b3;
                                }
                                c2 = c2.c();
                            }
                            q2.set(b2, internalEntry2);
                            while (internalEntry != internalEntry2) {
                                int b4 = internalEntry.b() & length2;
                                InternalEntry d2 = d(internalEntry, (InternalEntry) q2.get(b4));
                                if (d2 != null) {
                                    q2.set(b4, d2);
                                } else {
                                    i2--;
                                }
                                internalEntry = internalEntry.c();
                            }
                        }
                    }
                }
                this.f30598f = q2;
                this.f30595c = i2;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public V h(Object obj, int i2) {
            try {
                InternalEntry k2 = k(obj, i2);
                if (k2 == null) {
                    r();
                    return null;
                }
                V value = k2.getValue();
                if (value == null) {
                    F();
                }
                r();
                return value;
            } catch (Throwable th) {
                r();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public E i(Object obj, int i2) {
            if (this.f30595c == 0) {
                return null;
            }
            for (E j2 = j(i2); j2 != null; j2 = j2.c()) {
                if (j2.b() == i2) {
                    Object key = j2.getKey();
                    if (key == null) {
                        F();
                    } else if (this.f30594b.f30576f.d(obj, key)) {
                        return j2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public E j(int i2) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
            return (InternalEntry) atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        public E k(Object obj, int i2) {
            return i(obj, i2);
        }

        /* access modifiers changed from: package-private */
        public V l(E e2) {
            if (e2.getKey() == null) {
                F();
                return null;
            }
            V value = e2.getValue();
            if (value != null) {
                return value;
            }
            F();
            return null;
        }

        /* access modifiers changed from: package-private */
        public void m(AtomicReferenceArray<E> atomicReferenceArray) {
            this.f30597e = (atomicReferenceArray.length() * 3) / 4;
            this.f30598f = atomicReferenceArray;
        }

        /* access modifiers changed from: package-private */
        public void o() {
        }

        /* access modifiers changed from: package-private */
        public void p() {
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<E> q(int i2) {
            return new AtomicReferenceArray<>(i2);
        }

        /* access modifiers changed from: package-private */
        public void r() {
            if ((this.f30599g.incrementAndGet() & 63) == 0) {
                B();
            }
        }

        /* access modifiers changed from: package-private */
        public void s() {
            C();
        }

        /* access modifiers changed from: package-private */
        public V t(K k2, int i2, V v2, boolean z2) {
            lock();
            try {
                s();
                int i3 = this.f30595c + 1;
                if (i3 > this.f30597e) {
                    g();
                    i3 = this.f30595c + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.b() != i2 || key == null || !this.f30594b.f30576f.d(k2, key)) {
                        internalEntry2 = internalEntry2.c();
                    } else {
                        V value = internalEntry2.getValue();
                        if (value == null) {
                            this.f30596d++;
                            E(internalEntry2, v2);
                            this.f30595c = this.f30595c;
                            return null;
                        } else if (z2) {
                            unlock();
                            return value;
                        } else {
                            this.f30596d++;
                            E(internalEntry2, v2);
                            unlock();
                            return value;
                        }
                    }
                }
                this.f30596d++;
                E e2 = this.f30594b.f30577g.e(D(), k2, i2, internalEntry);
                E(e2, v2);
                atomicReferenceArray.set(length, e2);
                this.f30595c = i3;
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean u(E e2, int i2) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = i2 & (atomicReferenceArray.length() - 1);
                E e3 = (InternalEntry) atomicReferenceArray.get(length);
                for (E e4 = e3; e4 != null; e4 = e4.c()) {
                    if (e4 == e2) {
                        this.f30596d++;
                        atomicReferenceArray.set(length, y(e3, e4));
                        this.f30595c--;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean v(K k2, int i2, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.b() != i2 || key == null || !this.f30594b.f30576f.d(k2, key)) {
                        internalEntry2 = internalEntry2.c();
                    } else if (((WeakValueEntry) internalEntry2).a() == weakValueReference) {
                        this.f30596d++;
                        atomicReferenceArray.set(length, y(internalEntry, internalEntry2));
                        this.f30595c--;
                        return true;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public V w(Object obj, int i2) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.b() != i2 || key == null || !this.f30594b.f30576f.d(obj, key)) {
                        internalEntry2 = internalEntry2.c();
                    } else {
                        V value = internalEntry2.getValue();
                        if (value == null) {
                            if (!n(internalEntry2)) {
                                unlock();
                                return null;
                            }
                        }
                        this.f30596d++;
                        atomicReferenceArray.set(length, y(internalEntry, internalEntry2));
                        this.f30595c--;
                        return value;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean x(Object obj, int i2, Object obj2) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (true) {
                    boolean z2 = false;
                    if (internalEntry2 != null) {
                        Object key = internalEntry2.getKey();
                        if (internalEntry2.b() != i2 || key == null || !this.f30594b.f30576f.d(obj, key)) {
                            internalEntry2 = internalEntry2.c();
                        } else {
                            if (this.f30594b.n().d(obj2, internalEntry2.getValue())) {
                                z2 = true;
                            } else if (!n(internalEntry2)) {
                                unlock();
                                return false;
                            }
                            this.f30596d++;
                            atomicReferenceArray.set(length, y(internalEntry, internalEntry2));
                            this.f30595c--;
                            return z2;
                        }
                    } else {
                        unlock();
                        return false;
                    }
                }
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public E y(E e2, E e3) {
            int i2 = this.f30595c;
            E c2 = e3.c();
            while (e2 != e3) {
                E d2 = d(e2, c2);
                if (d2 != null) {
                    c2 = d2;
                } else {
                    i2--;
                }
                e2 = e2.c();
            }
            this.f30595c = i2;
            return c2;
        }

        /* access modifiers changed from: package-private */
        public V z(K k2, int i2, V v2) {
            lock();
            try {
                s();
                AtomicReferenceArray<E> atomicReferenceArray = this.f30598f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.b() != i2 || key == null || !this.f30594b.f30576f.d(k2, key)) {
                        internalEntry2 = internalEntry2.c();
                    } else {
                        V value = internalEntry2.getValue();
                        if (value == null) {
                            if (n(internalEntry2)) {
                                this.f30596d++;
                                atomicReferenceArray.set(length, y(internalEntry, internalEntry2));
                                this.f30595c--;
                            }
                            return null;
                        }
                        this.f30596d++;
                        E(internalEntry2, v2);
                        unlock();
                        return value;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }
    }

    enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.c();
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.f();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> b();
    }

    static class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public volatile V f30603c;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f30604a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> g() {
                return f30604a;
            }

            public Strength c() {
                return Strength.STRONG;
            }

            /* renamed from: f */
            public StrongKeyStrongValueEntry<K, V> b(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2) {
                StrongKeyStrongValueEntry<K, V> h2 = e(strongKeyStrongValueSegment, strongKeyStrongValueEntry.f30581a, strongKeyStrongValueEntry.f30582b, strongKeyStrongValueEntry2);
                Object unused = h2.f30603c = strongKeyStrongValueEntry.f30603c;
                return h2;
            }

            /* renamed from: h */
            public StrongKeyStrongValueEntry<K, V> e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k2, int i2, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                if (strongKeyStrongValueEntry == null) {
                    return new StrongKeyStrongValueEntry<>(k2, i2);
                }
                return new LinkedStrongKeyStrongValueEntry(k2, i2, strongKeyStrongValueEntry);
            }

            /* renamed from: i */
            public StrongKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: j */
            public void d(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, V v2) {
                Object unused = strongKeyStrongValueEntry.f30603c = v2;
            }
        }

        private static final class LinkedStrongKeyStrongValueEntry<K, V> extends StrongKeyStrongValueEntry<K, V> {

            /* renamed from: d  reason: collision with root package name */
            private final StrongKeyStrongValueEntry<K, V> f30605d;

            LinkedStrongKeyStrongValueEntry(K k2, int i2, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                super(k2, i2);
                this.f30605d = strongKeyStrongValueEntry;
            }

            /* renamed from: f */
            public StrongKeyStrongValueEntry<K, V> c() {
                return this.f30605d;
            }
        }

        public final V getValue() {
            return this.f30603c;
        }

        private StrongKeyStrongValueEntry(K k2, int i2) {
            super(k2, i2);
            this.f30603c = null;
        }
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: G */
        public StrongKeyStrongValueSegment<K, V> D() {
            return this;
        }
    }

    static class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> f30606c;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f30607a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> g() {
                return f30607a;
            }

            public Strength c() {
                return Strength.WEAK;
            }

            /* renamed from: f */
            public StrongKeyWeakValueEntry<K, V> b(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2) {
                if (Segment.n(strongKeyWeakValueEntry)) {
                    return null;
                }
                StrongKeyWeakValueEntry<K, V> h2 = e(strongKeyWeakValueSegment, strongKeyWeakValueEntry.f30581a, strongKeyWeakValueEntry.f30582b, strongKeyWeakValueEntry2);
                WeakValueReference unused = h2.f30606c = strongKeyWeakValueEntry.f30606c.b(strongKeyWeakValueSegment.f30609h, h2);
                return h2;
            }

            /* renamed from: h */
            public StrongKeyWeakValueEntry<K, V> e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k2, int i2, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                if (strongKeyWeakValueEntry == null) {
                    return new StrongKeyWeakValueEntry<>(k2, i2);
                }
                return new LinkedStrongKeyWeakValueEntry(k2, i2, strongKeyWeakValueEntry);
            }

            /* renamed from: i */
            public StrongKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: j */
            public void d(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, V v2) {
                WeakValueReference d2 = strongKeyWeakValueEntry.f30606c;
                WeakValueReference unused = strongKeyWeakValueEntry.f30606c = new WeakValueReferenceImpl(strongKeyWeakValueSegment.f30609h, v2, strongKeyWeakValueEntry);
                d2.clear();
            }
        }

        private static final class LinkedStrongKeyWeakValueEntry<K, V> extends StrongKeyWeakValueEntry<K, V> {

            /* renamed from: d  reason: collision with root package name */
            private final StrongKeyWeakValueEntry<K, V> f30608d;

            LinkedStrongKeyWeakValueEntry(K k2, int i2, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                super(k2, i2);
                this.f30608d = strongKeyWeakValueEntry;
            }

            /* renamed from: f */
            public StrongKeyWeakValueEntry<K, V> c() {
                return this.f30608d;
            }
        }

        public final WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> a() {
            return this.f30606c;
        }

        public final V getValue() {
            return this.f30606c.get();
        }

        private StrongKeyWeakValueEntry(K k2, int i2) {
            super(k2, i2);
            this.f30606c = MapMakerInternalMap.m();
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final ReferenceQueue<V> f30609h = new ReferenceQueue<>();

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: H */
        public StrongKeyWeakValueSegment<K, V> D() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            b(this.f30609h);
        }

        /* access modifiers changed from: package-private */
        public void p() {
            f(this.f30609h);
        }
    }

    final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        ValueIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        public V next() {
            return c().getValue();
        }
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public Iterator<V> iterator() {
            return new ValueIterator(MapMakerInternalMap.this);
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public Object[] toArray() {
            return MapMakerInternalMap.l(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.l(this).toArray(tArr);
        }
    }

    static class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public volatile V f30611b;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f30612a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> g() {
                return f30612a;
            }

            public Strength c() {
                return Strength.STRONG;
            }

            /* renamed from: f */
            public WeakKeyStrongValueEntry<K, V> b(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2) {
                K key = weakKeyStrongValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                WeakKeyStrongValueEntry<K, V> h2 = e(weakKeyStrongValueSegment, key, weakKeyStrongValueEntry.f30583a, weakKeyStrongValueEntry2);
                Object unused = h2.f30611b = weakKeyStrongValueEntry.f30611b;
                return h2;
            }

            /* renamed from: h */
            public WeakKeyStrongValueEntry<K, V> e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k2, int i2, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                if (weakKeyStrongValueEntry == null) {
                    return new WeakKeyStrongValueEntry<>(weakKeyStrongValueSegment.f30614h, k2, i2);
                }
                return new LinkedWeakKeyStrongValueEntry(weakKeyStrongValueSegment.f30614h, k2, i2, weakKeyStrongValueEntry);
            }

            /* renamed from: i */
            public WeakKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: j */
            public void d(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, V v2) {
                Object unused = weakKeyStrongValueEntry.f30611b = v2;
            }
        }

        private static final class LinkedWeakKeyStrongValueEntry<K, V> extends WeakKeyStrongValueEntry<K, V> {

            /* renamed from: c  reason: collision with root package name */
            private final WeakKeyStrongValueEntry<K, V> f30613c;

            /* renamed from: f */
            public WeakKeyStrongValueEntry<K, V> c() {
                return this.f30613c;
            }

            private LinkedWeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                super(referenceQueue, k2, i2);
                this.f30613c = weakKeyStrongValueEntry;
            }
        }

        public final V getValue() {
            return this.f30611b;
        }

        private WeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(referenceQueue, k2, i2);
            this.f30611b = null;
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final ReferenceQueue<K> f30614h = new ReferenceQueue<>();

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: H */
        public WeakKeyStrongValueSegment<K, V> D() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            b(this.f30614h);
        }

        /* access modifiers changed from: package-private */
        public void p() {
            e(this.f30614h);
        }
    }

    static class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> f30615b = MapMakerInternalMap.m();

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f30616a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> g() {
                return f30616a;
            }

            public Strength c() {
                return Strength.WEAK;
            }

            /* renamed from: f */
            public WeakKeyWeakValueEntry<K, V> b(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2) {
                K key = weakKeyWeakValueEntry.getKey();
                if (key == null || Segment.n(weakKeyWeakValueEntry)) {
                    return null;
                }
                WeakKeyWeakValueEntry<K, V> h2 = e(weakKeyWeakValueSegment, key, weakKeyWeakValueEntry.f30583a, weakKeyWeakValueEntry2);
                WeakValueReference unused = h2.f30615b = weakKeyWeakValueEntry.f30615b.b(weakKeyWeakValueSegment.f30619i, h2);
                return h2;
            }

            /* renamed from: h */
            public WeakKeyWeakValueEntry<K, V> e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k2, int i2, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                if (weakKeyWeakValueEntry == null) {
                    return new WeakKeyWeakValueEntry<>(weakKeyWeakValueSegment.f30618h, k2, i2);
                }
                return new LinkedWeakKeyWeakValueEntry(weakKeyWeakValueSegment.f30618h, k2, i2, weakKeyWeakValueEntry);
            }

            /* renamed from: i */
            public WeakKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: j */
            public void d(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, V v2) {
                WeakValueReference d2 = weakKeyWeakValueEntry.f30615b;
                WeakValueReference unused = weakKeyWeakValueEntry.f30615b = new WeakValueReferenceImpl(weakKeyWeakValueSegment.f30619i, v2, weakKeyWeakValueEntry);
                d2.clear();
            }
        }

        private static final class LinkedWeakKeyWeakValueEntry<K, V> extends WeakKeyWeakValueEntry<K, V> {

            /* renamed from: c  reason: collision with root package name */
            private final WeakKeyWeakValueEntry<K, V> f30617c;

            LinkedWeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                super(referenceQueue, k2, i2);
                this.f30617c = weakKeyWeakValueEntry;
            }

            /* renamed from: f */
            public WeakKeyWeakValueEntry<K, V> c() {
                return this.f30617c;
            }
        }

        WeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(referenceQueue, k2, i2);
        }

        public final WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> a() {
            return this.f30615b;
        }

        public final V getValue() {
            return this.f30615b.get();
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final ReferenceQueue<K> f30618h = new ReferenceQueue<>();
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public final ReferenceQueue<V> f30619i = new ReferenceQueue<>();

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: I */
        public WeakKeyWeakValueSegment<K, V> D() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            b(this.f30618h);
        }

        /* access modifiers changed from: package-private */
        public void p() {
            e(this.f30618h);
            f(this.f30619i);
        }
    }

    interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference<K, V, E> a();
    }

    interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        E a();

        WeakValueReference<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        V get();
    }

    static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        @Weak

        /* renamed from: a  reason: collision with root package name */
        final E f30620a;

        WeakValueReferenceImpl(ReferenceQueue<V> referenceQueue, V v2, E e2) {
            super(v2, referenceQueue);
            this.f30620a = e2;
        }

        public E a() {
            return this.f30620a;
        }

        public WeakValueReference<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            return new WeakValueReferenceImpl(referenceQueue, get(), e2);
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final K f30621b;

        /* renamed from: c  reason: collision with root package name */
        V f30622c;

        WriteThroughEntry(K k2, V v2) {
            this.f30621b = k2;
            this.f30622c = v2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f30621b.equals(entry.getKey()) || !this.f30622c.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f30621b;
        }

        public V getValue() {
            return this.f30622c;
        }

        public int hashCode() {
            return this.f30621b.hashCode() ^ this.f30622c.hashCode();
        }

        public V setValue(V v2) {
            V put = MapMakerInternalMap.this.put(this.f30621b, v2);
            this.f30622c = v2;
            return put;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.f30575e = Math.min(mapMaker.a(), 65536);
        this.f30576f = mapMaker.c();
        this.f30577g = internalEntryHelper;
        int min = Math.min(mapMaker.b(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.f30575e) {
            i5++;
            i4 <<= 1;
        }
        this.f30573c = 32 - i5;
        this.f30572b = i4 - 1;
        this.f30574d = g(i4);
        int i6 = min / i4;
        while (i3 < (i4 * i6 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.f30574d;
            if (i2 < segmentArr.length) {
                segmentArr[i2] = d(i3);
                i2++;
            } else {
                return;
            }
        }
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> b(MapMaker mapMaker) {
        Strength d2 = mapMaker.d();
        Strength strength = Strength.STRONG;
        if (d2 == strength && mapMaker.e() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyStrongValueEntry.Helper.g());
        }
        if (mapMaker.d() == strength && mapMaker.e() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyWeakValueEntry.Helper.g());
        }
        Strength d3 = mapMaker.d();
        Strength strength2 = Strength.WEAK;
        if (d3 == strength2 && mapMaker.e() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyStrongValueEntry.Helper.g());
        }
        if (mapMaker.d() == strength2 && mapMaker.e() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyWeakValueEntry.Helper.g());
        }
        throw new AssertionError();
    }

    static int j(int i2) {
        int i3 = i2 + ((i2 << 15) ^ -12931);
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* access modifiers changed from: private */
    public static <E> ArrayList<E> l(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> m() {
        return f30571k;
    }

    public void clear() {
        for (Segment<K, V, E, S> a2 : this.f30574d) {
            a2.a();
        }
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int f2 = f(obj);
        return k(f2).c(obj, f2);
    }

    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.f30574d;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (Segment<K, V, E, S> segment : segmentArr) {
                int i3 = segment.f30595c;
                AtomicReferenceArray<E> atomicReferenceArray = segment.f30598f;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i4); internalEntry != null; internalEntry = internalEntry.c()) {
                        V l2 = segment.l(internalEntry);
                        if (l2 != null && n().d(obj2, l2)) {
                            return true;
                        }
                    }
                }
                j3 += (long) segment.f30596d;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V, E, S> d(int i2) {
        return this.f30577g.a(this, i2);
    }

    /* access modifiers changed from: package-private */
    public V e(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return e2.getValue();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f30580j;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.f30580j = entrySet;
        return entrySet;
    }

    /* access modifiers changed from: package-private */
    public int f(Object obj) {
        return j(this.f30576f.e(obj));
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V, E, S>[] g(int i2) {
        return new Segment[i2];
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int f2 = f(obj);
        return k(f2).h(obj, f2);
    }

    /* access modifiers changed from: package-private */
    public void h(E e2) {
        int b2 = e2.b();
        k(b2).u(e2, b2);
    }

    /* access modifiers changed from: package-private */
    public void i(WeakValueReference<K, V, E> weakValueReference) {
        E a2 = weakValueReference.a();
        int b2 = a2.b();
        k(b2).v(a2.getKey(), b2, weakValueReference);
    }

    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.f30574d;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].f30595c != 0) {
                return false;
            }
            j2 += (long) segmentArr[i2].f30596d;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].f30595c != 0) {
                return false;
            }
            j2 -= (long) segmentArr[i3].f30596d;
        }
        if (j2 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V, E, S> k(int i2) {
        return this.f30574d[(i2 >>> this.f30573c) & this.f30572b];
    }

    public Set<K> keySet() {
        Set<K> set = this.f30578h;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f30578h = keySet;
        return keySet;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> n() {
        return this.f30577g.c().b();
    }

    public V put(K k2, V v2) {
        Preconditions.l(k2);
        Preconditions.l(v2);
        int f2 = f(k2);
        return k(f2).t(k2, f2, v2, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V putIfAbsent(K k2, V v2) {
        Preconditions.l(k2);
        Preconditions.l(v2);
        int f2 = f(k2);
        return k(f2).t(k2, f2, v2, true);
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int f2 = f(obj);
        return k(f2).w(obj, f2);
    }

    public boolean replace(K k2, V v2, V v3) {
        Preconditions.l(k2);
        Preconditions.l(v3);
        if (v2 == null) {
            return false;
        }
        int f2 = f(k2);
        return k(f2).A(k2, f2, v2, v3);
    }

    public int size() {
        Segment<K, V, E, S>[] segmentArr = this.f30574d;
        long j2 = 0;
        for (Segment<K, V, E, S> segment : segmentArr) {
            j2 += (long) segment.f30595c;
        }
        return Ints.m(j2);
    }

    public Collection<V> values() {
        Collection<V> collection = this.f30579i;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.f30579i = values;
        return values;
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int f2 = f(obj);
        return k(f2).x(obj, f2, obj2);
    }

    public V replace(K k2, V v2) {
        Preconditions.l(k2);
        Preconditions.l(v2);
        int f2 = f(k2);
        return k(f2).z(k2, f2, v2);
    }
}
