package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f17146a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f17147b;

    /* renamed from: c  reason: collision with root package name */
    private long f17148c;

    /* renamed from: d  reason: collision with root package name */
    private long f17149d;

    public LruCache(long j2) {
        this.f17147b = j2;
        this.f17148c = j2;
    }

    private void f() {
        m(this.f17148c);
    }

    public void b() {
        m(0);
    }

    public synchronized Y g(T t2) {
        return this.f17146a.get(t2);
    }

    public synchronized long h() {
        return this.f17148c;
    }

    /* access modifiers changed from: protected */
    public int i(Y y2) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void j(T t2, Y y2) {
    }

    public synchronized Y k(T t2, Y y2) {
        long i2 = (long) i(y2);
        if (i2 >= this.f17148c) {
            j(t2, y2);
            return null;
        }
        if (y2 != null) {
            this.f17149d += i2;
        }
        Y put = this.f17146a.put(t2, y2);
        if (put != null) {
            this.f17149d -= (long) i(put);
            if (!put.equals(y2)) {
                j(t2, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(T t2) {
        Y remove;
        remove = this.f17146a.remove(t2);
        if (remove != null) {
            this.f17149d -= (long) i(remove);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public synchronized void m(long j2) {
        while (this.f17149d > j2) {
            Iterator<Map.Entry<T, Y>> it2 = this.f17146a.entrySet().iterator();
            Map.Entry next = it2.next();
            Object value = next.getValue();
            this.f17149d -= (long) i(value);
            Object key = next.getKey();
            it2.remove();
            j(key, value);
        }
    }
}
