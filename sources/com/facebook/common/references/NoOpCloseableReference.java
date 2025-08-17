package com.facebook.common.references;

import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NoOpCloseableReference<T> extends CloseableReference<T> {
    NoOpCloseableReference(T t2, ResourceReleaser<T> resourceReleaser, CloseableReference.LeakHandler leakHandler, Throwable th) {
        super(t2, resourceReleaser, leakHandler, th);
    }

    public CloseableReference<T> clone() {
        return this;
    }

    public void close() {
    }
}
