package androidx.media3.exoplayer.mediacodec;

import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class f {
    public static /* synthetic */ boolean a(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
