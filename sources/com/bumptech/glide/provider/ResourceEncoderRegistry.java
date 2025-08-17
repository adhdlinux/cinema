package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f17020a = new ArrayList();

    private static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17021a;

        /* renamed from: b  reason: collision with root package name */
        final ResourceEncoder<T> f17022b;

        Entry(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.f17021a = cls;
            this.f17022b = resourceEncoder;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f17021a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        this.f17020a.add(new Entry(cls, resourceEncoder));
    }

    public synchronized <Z> ResourceEncoder<Z> b(Class<Z> cls) {
        int size = this.f17020a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Entry entry = this.f17020a.get(i2);
            if (entry.a(cls)) {
                return entry.f17022b;
            }
        }
        return null;
    }
}
