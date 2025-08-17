package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f16964a = new ArrayList();

    private static final class Entry<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f16965a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f16966b;

        /* renamed from: c  reason: collision with root package name */
        final ResourceTranscoder<Z, R> f16967c;

        Entry(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f16965a = cls;
            this.f16966b = cls2;
            this.f16967c = resourceTranscoder;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f16965a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f16966b);
        }
    }

    public synchronized <Z, R> ResourceTranscoder<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.b();
        }
        for (Entry next : this.f16964a) {
            if (next.a(cls, cls2)) {
                return next.f16967c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry<?, ?> a2 : this.f16964a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f16964a.add(new Entry(cls, cls2, resourceTranscoder));
    }
}
