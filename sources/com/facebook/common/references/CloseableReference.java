package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.FalseOnNull;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class CloseableReference<T> implements Cloneable, Closeable {
    private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() {
        public void release(Closeable closeable) {
            try {
                Closeables.close(closeable, true);
            } catch (IOException unused) {
            }
        }
    };
    private static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler() {
        public void reportLeak(SharedReference<Object> sharedReference, Throwable th) {
            String str;
            Object obj = sharedReference.get();
            Class access$000 = CloseableReference.TAG;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            if (obj == null) {
                str = null;
            } else {
                str = obj.getClass().getName();
            }
            objArr[2] = str;
            FLog.w((Class<?>) access$000, "Finalized without closing: %x %x (type = %s)", objArr);
        }

        public boolean requiresStacktrace() {
            return false;
        }
    };
    public static final int REF_TYPE_DEFAULT = 0;
    public static final int REF_TYPE_FINALIZER = 1;
    public static final int REF_TYPE_NOOP = 3;
    public static final int REF_TYPE_REF_COUNT = 2;
    /* access modifiers changed from: private */
    public static Class<CloseableReference> TAG = CloseableReference.class;
    @CloseableRefType
    private static int sBitmapCloseableRefType;
    protected boolean mIsClosed = false;
    protected final LeakHandler mLeakHandler;
    protected final SharedReference<T> mSharedReference;
    protected final Throwable mStacktrace;

    public @interface CloseableRefType {
    }

    public interface LeakHandler {
        void reportLeak(SharedReference<Object> sharedReference, Throwable th);

        boolean requiresStacktrace();
    }

    protected CloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler, Throwable th) {
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public static void closeSafely(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static <T extends Closeable> CloseableReference<T> of(@PropagatesNullable T t2) {
        return of(t2, DEFAULT_CLOSEABLE_RELEASER);
    }

    public static void setDisableCloseableReferencesForBitmaps(@CloseableRefType int i2) {
        sBitmapCloseableRefType = i2;
    }

    public static boolean useGc() {
        return sBitmapCloseableRefType == 3;
    }

    public abstract CloseableReference<T> clone();

    public synchronized CloseableReference<T> cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return clone();
    }

    public void close() {
        synchronized (this) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
                this.mSharedReference.deleteReference();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    super.finalize();
                    return;
                }
                this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public synchronized T get() {
        boolean z2;
        if (!this.mIsClosed) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        return Preconditions.checkNotNull(this.mSharedReference.get());
    }

    public synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        return this.mSharedReference;
    }

    public int getValueHash() {
        if (isValid()) {
            return System.identityHashCode(this.mSharedReference.get());
        }
        return 0;
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public static void closeSafely(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference closeSafely : iterable) {
                closeSafely((CloseableReference<?>) closeSafely);
            }
        }
    }

    @FalseOnNull
    public static boolean isValid(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t2, ResourceReleaser<T> resourceReleaser) {
        return of(t2, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }

    public static <T extends Closeable> CloseableReference<T> of(@PropagatesNullable T t2, LeakHandler leakHandler) {
        Throwable th = null;
        if (t2 == null) {
            return null;
        }
        ResourceReleaser<Closeable> resourceReleaser = DEFAULT_CLOSEABLE_RELEASER;
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return of(t2, resourceReleaser, leakHandler, th);
    }

    public static <T> CloseableReference<T> cloneOrNull(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (CloseableReference<T> cloneOrNull : collection) {
            arrayList.add(cloneOrNull(cloneOrNull));
        }
        return arrayList;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t2, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        Throwable th = null;
        if (t2 == null) {
            return null;
        }
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return of(t2, resourceReleaser, leakHandler, th);
    }

    protected CloseableReference(T t2, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        this.mSharedReference = new SharedReference<>(t2, resourceReleaser);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t2, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        if (t2 == null) {
            return null;
        }
        if ((t2 instanceof Bitmap) || (t2 instanceof HasBitmap)) {
            int i2 = sBitmapCloseableRefType;
            if (i2 == 1) {
                return new FinalizerCloseableReference(t2, resourceReleaser, leakHandler, th);
            }
            if (i2 == 2) {
                return new RefCountCloseableReference(t2, resourceReleaser, leakHandler, th);
            }
            if (i2 == 3) {
                return new NoOpCloseableReference(t2, resourceReleaser, leakHandler, th);
            }
        }
        return new DefaultCloseableReference(t2, resourceReleaser, leakHandler, th);
    }
}
