package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f17015a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<Entry<?, ?>>> f17016b = new HashMap();

    private static class Entry<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17017a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f17018b;

        /* renamed from: c  reason: collision with root package name */
        final ResourceDecoder<T, R> f17019c;

        public Entry(Class<T> cls, Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f17017a = cls;
            this.f17018b = cls2;
            this.f17019c = resourceDecoder;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            if (!this.f17017a.isAssignableFrom(cls) || !cls2.isAssignableFrom(this.f17018b)) {
                return false;
            }
            return true;
        }
    }

    private synchronized List<Entry<?, ?>> c(String str) {
        List<Entry<?, ?>> list;
        if (!this.f17015a.contains(str)) {
            this.f17015a.add(str);
        }
        list = this.f17016b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f17016b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        c(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    public synchronized <T, R> List<ResourceDecoder<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f17015a) {
            List<Entry> list = this.f17016b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2)) {
                        arrayList.add(entry.f17019c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f17015a) {
            List<Entry> list = this.f17016b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2) && !arrayList.contains(entry.f17018b)) {
                        arrayList.add(entry.f17018b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f17015a);
        this.f17015a.clear();
        for (String add : list) {
            this.f17015a.add(add);
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f17015a.add(str);
            }
        }
    }
}
