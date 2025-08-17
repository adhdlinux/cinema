package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.FalseOnNull;
import com.facebook.infer.annotation.Nullsafe;
import java.util.IdentityHashMap;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public class SharedReference<T> {
    private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
    private int mRefCount = 1;
    private final ResourceReleaser<T> mResourceReleaser;
    private T mValue;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t2, ResourceReleaser<T> resourceReleaser) {
        this.mValue = Preconditions.checkNotNull(t2);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
        addLiveReference(t2);
    }

    private static void addLiveReference(Object obj) {
        if (!CloseableReference.useGc() || (!(obj instanceof Bitmap) && !(obj instanceof HasBitmap))) {
            Map<Object, Integer> map = sLiveObjects;
            synchronized (map) {
                Integer num = map.get(obj);
                if (num == null) {
                    map.put(obj, 1);
                } else {
                    map.put(obj, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    private synchronized int decreaseRefCount() {
        boolean z2;
        int i2;
        ensureValid();
        if (this.mRefCount > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        i2 = this.mRefCount - 1;
        this.mRefCount = i2;
        return i2;
    }

    private void ensureValid() {
        if (!isValid(this)) {
            throw new NullReferenceException();
        }
    }

    private static void removeLiveReference(Object obj) {
        Map<Object, Integer> map = sLiveObjects;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                map.remove(obj);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public static String reportData() {
        return Objects.toStringHelper("SharedReference").add("live_objects_count", sLiveObjects.size()).toString();
    }

    public synchronized void addReference() {
        ensureValid();
        this.mRefCount++;
    }

    public synchronized boolean addReferenceIfValid() {
        if (!isValid()) {
            return false;
        }
        addReference();
        return true;
    }

    public void deleteReference() {
        T t2;
        if (decreaseRefCount() == 0) {
            synchronized (this) {
                t2 = this.mValue;
                this.mValue = null;
            }
            if (t2 != null) {
                this.mResourceReleaser.release(t2);
                removeLiveReference(t2);
            }
        }
    }

    public synchronized boolean deleteReferenceIfValid() {
        if (!isValid()) {
            return false;
        }
        deleteReference();
        return true;
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized int getRefCountTestOnly() {
        return this.mRefCount;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    @FalseOnNull
    public static boolean isValid(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }
}
