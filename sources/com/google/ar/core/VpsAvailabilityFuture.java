package com.google.ar.core;

import com.google.ar.core.annotations.UsedByNative;
import java.util.function.Consumer;

public class VpsAvailabilityFuture extends FutureImpl {

    static class CallbackWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final Consumer f30251a;

        public CallbackWrapper(Consumer consumer) {
            this.f30251a = consumer;
        }

        @UsedByNative("callback_context.cc")
        public void accept(int i2) {
            this.f30251a.accept(VpsAvailability.forNumber(i2));
        }
    }

    VpsAvailabilityFuture(Session session, long j2, long j3) {
        super(session, j2, j3);
    }

    public /* bridge */ /* synthetic */ boolean cancel() {
        return super.cancel();
    }

    public VpsAvailability getResult() {
        return VpsAvailability.forNumber(nativeGetResult(this.session.nativeWrapperHandle, this.nativeFuture));
    }

    public /* bridge */ /* synthetic */ FutureState getState() {
        return super.getState();
    }

    /* access modifiers changed from: package-private */
    public native int nativeGetResult(long j2, long j3);
}
