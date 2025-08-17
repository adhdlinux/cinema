package com.google.ar.core;

import com.google.ar.core.Anchor;
import com.google.ar.core.annotations.UsedByNative;
import java.lang.ref.WeakReference;
import java.util.function.BiConsumer;

public class ResolveCloudAnchorFuture extends FutureImpl {

    static class CallbackWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f30248a;

        /* renamed from: b  reason: collision with root package name */
        private final long f30249b;

        /* renamed from: c  reason: collision with root package name */
        private final BiConsumer f30250c;

        public CallbackWrapper(Session session, BiConsumer biConsumer) {
            this.f30248a = new WeakReference(session);
            this.f30249b = session.nativeSymbolTableHandle;
            this.f30250c = biConsumer;
        }

        @UsedByNative("callback_context.cc")
        public void accept(long j2, int i2) {
            Session session = (Session) this.f30248a.get();
            if (session != null) {
                this.f30250c.accept(ResolveCloudAnchorFuture.makeAnchor(j2, session), Anchor.CloudAnchorState.forNumber(i2));
                return;
            }
            this.f30250c.accept((Object) null, Anchor.CloudAnchorState.ERROR_INTERNAL);
            if (j2 != 0) {
                Anchor.nativeReleaseAnchor(this.f30249b, j2);
            }
        }
    }

    ResolveCloudAnchorFuture(Session session, long j2, long j3) {
        super(session, j2, j3);
    }

    /* access modifiers changed from: private */
    public static Anchor makeAnchor(long j2, Session session) {
        if (j2 != 0) {
            return new Anchor(j2, session);
        }
        return null;
    }

    public /* bridge */ /* synthetic */ boolean cancel() {
        return super.cancel();
    }

    public Anchor getResultAnchor() {
        return makeAnchor(nativeGetResultAnchor(this.session.nativeWrapperHandle, this.nativeFuture), this.session);
    }

    public Anchor.CloudAnchorState getResultCloudAnchorState() {
        return Anchor.CloudAnchorState.forNumber(nativeGetResultCloudAnchorState(this.session.nativeWrapperHandle, this.nativeFuture));
    }

    public /* bridge */ /* synthetic */ FutureState getState() {
        return super.getState();
    }

    /* access modifiers changed from: package-private */
    public native long nativeGetResultAnchor(long j2, long j3);

    /* access modifiers changed from: package-private */
    public native int nativeGetResultCloudAnchorState(long j2, long j3);
}
