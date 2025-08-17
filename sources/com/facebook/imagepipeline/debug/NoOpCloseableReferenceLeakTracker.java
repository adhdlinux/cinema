package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NoOpCloseableReferenceLeakTracker implements CloseableReferenceLeakTracker {
    public boolean isSet() {
        return false;
    }

    public void setListener(CloseableReferenceLeakTracker.Listener listener) {
    }

    public void trackCloseableReferenceLeak(SharedReference<Object> sharedReference, Throwable th) {
    }
}
