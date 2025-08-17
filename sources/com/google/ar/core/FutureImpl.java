package com.google.ar.core;

class FutureImpl implements Future {
    final long nativeCallbackContext;
    final long nativeFuture;
    final long nativeSymbolTableHandle;
    final Session session;

    FutureImpl(Session session2, long j2, long j3) {
        this.session = session2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
        this.nativeFuture = j2;
        this.nativeCallbackContext = j3;
    }

    static native void nativeReleaseFuture(long j2, long j3);

    public boolean cancel() {
        return nativeCancel(this.session.nativeWrapperHandle, this.nativeFuture, this.nativeCallbackContext);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        nativeReleaseFuture(this.nativeSymbolTableHandle, this.nativeFuture);
        super.finalize();
    }

    public FutureState getState() {
        return FutureState.forNumber(nativeGetState(this.session.nativeWrapperHandle, this.nativeFuture));
    }

    /* access modifiers changed from: package-private */
    public native boolean nativeCancel(long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native int nativeGetState(long j2, long j3);
}
