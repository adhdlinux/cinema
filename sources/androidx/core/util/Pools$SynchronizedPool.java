package androidx.core.util;

public class Pools$SynchronizedPool<T> extends Pools$SimplePool<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f2725c = new Object();

    public Pools$SynchronizedPool(int i2) {
        super(i2);
    }

    public T acquire() {
        T acquire;
        synchronized (this.f2725c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    public boolean release(T t2) {
        boolean release;
        synchronized (this.f2725c) {
            release = super.release(t2);
        }
        return release;
    }
}
