package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Object> f16590a;

    /* renamed from: b  reason: collision with root package name */
    private final KeyPool f16591b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f16592c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, ArrayAdapterInterface<?>> f16593d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16594e;

    /* renamed from: f  reason: collision with root package name */
    private int f16595f;

    private static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f16596a;

        /* renamed from: b  reason: collision with root package name */
        int f16597b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f16598c;

        Key(KeyPool keyPool) {
            this.f16596a = keyPool;
        }

        public void a() {
            this.f16596a.c(this);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, Class<?> cls) {
            this.f16597b = i2;
            this.f16598c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f16597b == key.f16597b && this.f16598c == key.f16598c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int i3 = this.f16597b * 31;
            Class<?> cls = this.f16598c;
            if (cls != null) {
                i2 = cls.hashCode();
            } else {
                i2 = 0;
            }
            return i3 + i2;
        }

        public String toString() {
            return "Key{size=" + this.f16597b + "array=" + this.f16598c + '}';
        }
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        /* access modifiers changed from: package-private */
        public Key e(int i2, Class<?> cls) {
            Key key = (Key) b();
            key.b(i2, cls);
            return key;
        }
    }

    public LruArrayPool() {
        this.f16590a = new GroupedLinkedMap<>();
        this.f16591b = new KeyPool();
        this.f16592c = new HashMap();
        this.f16593d = new HashMap();
        this.f16594e = 4194304;
    }

    private void e(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> l2 = l(cls);
        Integer num = l2.get(Integer.valueOf(i2));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        } else if (num.intValue() == 1) {
            l2.remove(Integer.valueOf(i2));
        } else {
            l2.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void f() {
        g(this.f16594e);
    }

    private void g(int i2) {
        while (this.f16595f > i2) {
            Object f2 = this.f16590a.f();
            Preconditions.d(f2);
            ArrayAdapterInterface h2 = h(f2);
            this.f16595f -= h2.b(f2) * h2.a();
            e(h2.b(f2), f2.getClass());
            if (Log.isLoggable(h2.getTag(), 2)) {
                Log.v(h2.getTag(), "evicted: " + h2.b(f2));
            }
        }
    }

    private <T> ArrayAdapterInterface<T> h(T t2) {
        return i(t2.getClass());
    }

    private <T> ArrayAdapterInterface<T> i(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = this.f16593d.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f16593d.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    private <T> T j(Key key) {
        return this.f16590a.a(key);
    }

    private <T> T k(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> i2 = i(cls);
        T j2 = j(key);
        if (j2 != null) {
            this.f16595f -= i2.b(j2) * i2.a();
            e(i2.b(j2), cls);
        }
        if (j2 != null) {
            return j2;
        }
        if (Log.isLoggable(i2.getTag(), 2)) {
            Log.v(i2.getTag(), "Allocated " + key.f16597b + " bytes");
        }
        return i2.newArray(key.f16597b);
    }

    private NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f16592c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f16592c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i2 = this.f16595f;
        return i2 == 0 || this.f16594e / i2 >= 2;
    }

    private boolean n(int i2) {
        return i2 <= this.f16594e / 2;
    }

    private boolean o(int i2, Integer num) {
        return num != null && (m() || num.intValue() <= i2 * 8);
    }

    public synchronized void a(int i2) {
        if (i2 >= 40) {
            try {
                b();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 >= 20 || i2 == 15) {
            g(this.f16594e / 2);
        }
    }

    public synchronized void b() {
        g(0);
    }

    public synchronized <T> T c(int i2, Class<T> cls) {
        Key key;
        Integer ceilingKey = l(cls).ceilingKey(Integer.valueOf(i2));
        if (o(i2, ceilingKey)) {
            key = this.f16591b.e(ceilingKey.intValue(), cls);
        } else {
            key = this.f16591b.e(i2, cls);
        }
        return k(key, cls);
    }

    public synchronized <T> T d(int i2, Class<T> cls) {
        return k(this.f16591b.e(i2, cls), cls);
    }

    public synchronized <T> void put(T t2) {
        Class<?> cls = t2.getClass();
        ArrayAdapterInterface<?> i2 = i(cls);
        int b2 = i2.b(t2);
        int a2 = i2.a() * b2;
        if (n(a2)) {
            Key e2 = this.f16591b.e(b2, cls);
            this.f16590a.d(e2, t2);
            NavigableMap<Integer, Integer> l2 = l(cls);
            Integer num = l2.get(Integer.valueOf(e2.f16597b));
            Integer valueOf = Integer.valueOf(e2.f16597b);
            int i3 = 1;
            if (num != null) {
                i3 = 1 + num.intValue();
            }
            l2.put(valueOf, Integer.valueOf(i3));
            this.f16595f += a2;
            f();
        }
    }

    public LruArrayPool(int i2) {
        this.f16590a = new GroupedLinkedMap<>();
        this.f16591b = new KeyPool();
        this.f16592c = new HashMap();
        this.f16593d = new HashMap();
        this.f16594e = i2;
    }
}
