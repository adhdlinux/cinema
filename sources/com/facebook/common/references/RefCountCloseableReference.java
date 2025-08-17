package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class RefCountCloseableReference<T> extends CloseableReference<T> {
    private RefCountCloseableReference(SharedReference<T> sharedReference, CloseableReference.LeakHandler leakHandler, Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    RefCountCloseableReference(T t2, ResourceReleaser<T> resourceReleaser, CloseableReference.LeakHandler leakHandler, Throwable th) {
        super(t2, resourceReleaser, leakHandler, th);
    }

    public CloseableReference<T> clone() {
        Preconditions.checkState(isValid());
        return new RefCountCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }
}
