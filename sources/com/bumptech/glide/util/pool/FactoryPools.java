package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {

    /* renamed from: a  reason: collision with root package name */
    private static final Resetter<Object> f17157a = new Resetter<Object>() {
        public void a(Object obj) {
        }
    };

    public interface Factory<T> {
        T create();
    }

    private static final class FactoryPool<T> implements Pools$Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Factory<T> f17158a;

        /* renamed from: b  reason: collision with root package name */
        private final Resetter<T> f17159b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools$Pool<T> f17160c;

        FactoryPool(Pools$Pool<T> pools$Pool, Factory<T> factory, Resetter<T> resetter) {
            this.f17160c = pools$Pool;
            this.f17158a = factory;
            this.f17159b = resetter;
        }

        public T acquire() {
            T acquire = this.f17160c.acquire();
            if (acquire == null) {
                acquire = this.f17158a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).b().b(false);
            }
            return acquire;
        }

        public boolean release(T t2) {
            if (t2 instanceof Poolable) {
                ((Poolable) t2).b().b(true);
            }
            this.f17159b.a(t2);
            return this.f17160c.release(t2);
        }
    }

    public interface Poolable {
        StateVerifier b();
    }

    public interface Resetter<T> {
        void a(T t2);
    }

    private FactoryPools() {
    }

    private static <T extends Poolable> Pools$Pool<T> a(Pools$Pool<T> pools$Pool, Factory<T> factory) {
        return b(pools$Pool, factory, c());
    }

    private static <T> Pools$Pool<T> b(Pools$Pool<T> pools$Pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pools$Pool, factory, resetter);
    }

    private static <T> Resetter<T> c() {
        return f17157a;
    }

    public static <T extends Poolable> Pools$Pool<T> d(int i2, Factory<T> factory) {
        return a(new Pools$SynchronizedPool(i2), factory);
    }

    public static <T> Pools$Pool<List<T>> e() {
        return f(20);
    }

    public static <T> Pools$Pool<List<T>> f(int i2) {
        return b(new Pools$SynchronizedPool(i2), new Factory<List<T>>() {
            /* renamed from: a */
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() {
            /* renamed from: b */
            public void a(List<T> list) {
                list.clear();
            }
        });
    }
}
