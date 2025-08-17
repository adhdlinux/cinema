package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f17006a = new ArrayList();

    private static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17007a;

        /* renamed from: b  reason: collision with root package name */
        final Encoder<T> f17008b;

        Entry(Class<T> cls, Encoder<T> encoder) {
            this.f17007a = cls;
            this.f17008b = encoder;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f17007a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, Encoder<T> encoder) {
        this.f17006a.add(new Entry(cls, encoder));
    }

    public synchronized <T> Encoder<T> b(Class<T> cls) {
        for (Entry next : this.f17006a) {
            if (next.a(cls)) {
                return next.f17008b;
            }
        }
        return null;
    }
}
