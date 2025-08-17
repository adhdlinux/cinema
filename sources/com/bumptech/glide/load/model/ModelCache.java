package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<ModelKey<A>, B> f16718a;

    static final class ModelKey<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<ModelKey<?>> f16720d = Util.e(0);

        /* renamed from: a  reason: collision with root package name */
        private int f16721a;

        /* renamed from: b  reason: collision with root package name */
        private int f16722b;

        /* renamed from: c  reason: collision with root package name */
        private A f16723c;

        private ModelKey() {
        }

        static <A> ModelKey<A> a(A a2, int i2, int i3) {
            ModelKey<A> poll;
            Queue<ModelKey<?>> queue = f16720d;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new ModelKey<>();
            }
            poll.b(a2, i2, i3);
            return poll;
        }

        private void b(A a2, int i2, int i3) {
            this.f16723c = a2;
            this.f16722b = i2;
            this.f16721a = i3;
        }

        public void c() {
            Queue<ModelKey<?>> queue = f16720d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.f16722b == modelKey.f16722b && this.f16721a == modelKey.f16721a && this.f16723c.equals(modelKey.f16723c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f16721a * 31) + this.f16722b) * 31) + this.f16723c.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public B a(A a2, int i2, int i3) {
        ModelKey a3 = ModelKey.a(a2, i2, i3);
        B g2 = this.f16718a.g(a3);
        a3.c();
        return g2;
    }

    public void b(A a2, int i2, int i3, B b2) {
        this.f16718a.k(ModelKey.a(a2, i2, i3), b2);
    }

    public ModelCache(long j2) {
        this.f16718a = new LruCache<ModelKey<A>, B>(j2) {
            /* access modifiers changed from: protected */
            /* renamed from: n */
            public void j(ModelKey<A> modelKey, B b2) {
                modelKey.c();
            }
        };
    }
}
