package com.google.ar.core;

import com.google.ar.core.annotations.UsedByNative;
import java.util.Collection;

@UsedByNative("trackable_base_jni.cc")
class TrackableBase implements Trackable {
    long nativeHandle;
    protected final long nativeSymbolTableHandle;
    protected final Session session;

    TrackableBase(long j2, Session session2) {
        this.session = session2;
        this.nativeHandle = j2;
        this.nativeSymbolTableHandle = session2 == null ? 0 : session2.nativeSymbolTableHandle;
    }

    static int internalGetType(long j2, long j3) {
        return nativeGetType(j2, j3);
    }

    static void internalReleaseNativeHandle(long j2, long j3) {
        nativeReleaseTrackable(j2, j3);
    }

    private native long nativeCreateAnchor(long j2, long j3, Pose pose);

    private native long[] nativeGetAnchors(long j2, long j3);

    private native int nativeGetTrackingState(long j2, long j3);

    private static native int nativeGetType(long j2, long j3);

    private static native void nativeReleaseTrackable(long j2, long j3);

    public Anchor createAnchor(Pose pose) {
        return new Anchor(nativeCreateAnchor(this.session.nativeWrapperHandle, this.nativeHandle, pose), this.session);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TrackableBase) && ((TrackableBase) obj).nativeHandle == this.nativeHandle) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleaseTrackable(this.nativeSymbolTableHandle, j2);
            this.nativeHandle = 0;
        }
        super.finalize();
    }

    public Collection<Anchor> getAnchors() {
        Session session2 = this.session;
        return session2.convertNativeAnchorsToCollection(nativeGetAnchors(session2.nativeWrapperHandle, this.nativeHandle));
    }

    public TrackingState getTrackingState() {
        return TrackingState.forNumber(nativeGetTrackingState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public int hashCode() {
        return Long.valueOf(this.nativeHandle).hashCode();
    }
}
