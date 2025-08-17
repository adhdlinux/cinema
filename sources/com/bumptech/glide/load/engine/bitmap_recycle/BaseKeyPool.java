package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f16583a = Util.e(20);

    BaseKeyPool() {
    }

    /* access modifiers changed from: package-private */
    public abstract T a();

    /* access modifiers changed from: package-private */
    public T b() {
        T t2 = (Poolable) this.f16583a.poll();
        if (t2 == null) {
            return a();
        }
        return t2;
    }

    public void c(T t2) {
        if (this.f16583a.size() < 20) {
            this.f16583a.offer(t2);
        }
    }
}
