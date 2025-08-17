package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.Nullsafe;
import java.util.HashSet;
import java.util.Set;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {
    private final Set<T> mCurrentItems = new HashSet();
    private final BucketMap<T> mMap = new BucketMap<>();

    private T maybeRemoveFromCurrentItems(T t2) {
        if (t2 != null) {
            synchronized (this) {
                this.mCurrentItems.remove(t2);
            }
        }
        return t2;
    }

    public T get(int i2) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(i2));
    }

    public T pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    public void put(T t2) {
        boolean add;
        synchronized (this) {
            add = this.mCurrentItems.add(t2);
        }
        if (add) {
            this.mMap.release(getSize(t2), t2);
        }
    }

    /* access modifiers changed from: package-private */
    public int valueCount() {
        return this.mMap.valueCount();
    }
}
