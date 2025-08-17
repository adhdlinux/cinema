package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {

    /* renamed from: b  reason: collision with root package name */
    private static final DataRewinder.Factory<?> f16322b = new DataRewinder.Factory<Object>() {
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public DataRewinder<Object> b(Object obj) {
            return new DefaultRewinder(obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, DataRewinder.Factory<?>> f16323a = new HashMap();

    private static final class DefaultRewinder implements DataRewinder<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f16324a;

        DefaultRewinder(Object obj) {
            this.f16324a = obj;
        }

        public Object a() {
            return this.f16324a;
        }

        public void b() {
        }
    }

    public synchronized <T> DataRewinder<T> a(T t2) {
        DataRewinder.Factory<?> factory;
        Preconditions.d(t2);
        factory = this.f16323a.get(t2.getClass());
        if (factory == null) {
            Iterator<DataRewinder.Factory<?>> it2 = this.f16323a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DataRewinder.Factory<?> next = it2.next();
                if (next.a().isAssignableFrom(t2.getClass())) {
                    factory = next;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = f16322b;
        }
        return factory.b(t2);
    }

    public synchronized void b(DataRewinder.Factory<?> factory) {
        this.f16323a.put(factory.a(), factory);
    }
}
