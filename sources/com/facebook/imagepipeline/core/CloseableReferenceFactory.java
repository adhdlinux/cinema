package com.facebook.imagepipeline.core;

import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;

@Nullsafe(Nullsafe.Mode.STRICT)
public class CloseableReferenceFactory {
    private final CloseableReference.LeakHandler mLeakHandler;

    public CloseableReferenceFactory(final CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
        this.mLeakHandler = new CloseableReference.LeakHandler() {
            public void reportLeak(SharedReference<Object> sharedReference, Throwable th) {
                String str;
                closeableReferenceLeakTracker.trackCloseableReferenceLeak(sharedReference, th);
                Object obj = sharedReference.get();
                if (obj != null) {
                    str = obj.getClass().getName();
                } else {
                    str = "<value is null>";
                }
                FLog.w("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), str, CloseableReferenceFactory.getStackTraceString(th));
            }

            public boolean requiresStacktrace() {
                return closeableReferenceLeakTracker.isSet();
            }
        };
    }

    /* access modifiers changed from: private */
    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public <U extends Closeable> CloseableReference<U> create(U u2) {
        return CloseableReference.of(u2, this.mLeakHandler);
    }

    public <T> CloseableReference<T> create(T t2, ResourceReleaser<T> resourceReleaser) {
        return CloseableReference.of(t2, resourceReleaser, this.mLeakHandler);
    }
}
