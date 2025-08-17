package com.bumptech.glide.util.pool;

public abstract class StateVerifier {

    private static class DefaultStateVerifier extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f17161a;

        DefaultStateVerifier() {
            super();
        }

        public void b(boolean z2) {
            this.f17161a = z2;
        }

        public void c() {
            if (this.f17161a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(boolean z2);

    public abstract void c();

    private StateVerifier() {
    }
}
