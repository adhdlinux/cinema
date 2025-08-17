package com.google.ar.core;

import com.google.ar.core.annotations.UsedByNative;

@UsedByNative("session_jni_wrapper.cc")
public class GeospatialPose {
    long nativeHandle;
    final long nativeSymbolTableHandle;
    private final Session session;

    GeospatialPose(long j2, Session session2) {
        this.session = session2;
        this.nativeHandle = j2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private static native void nativeDestroy(long j2, long j3);

    private native float[] nativeEastUpSouthQuaternion(long j2, long j3);

    private native double nativeGetAltitude(long j2, long j3);

    private native double nativeGetHeading(long j2, long j3);

    private native double nativeGetHeadingAccuracy(long j2, long j3);

    private native double nativeGetHorizontalAccuracy(long j2, long j3);

    private native double nativeGetLatitude(long j2, long j3);

    private native double nativeGetLongitude(long j2, long j3);

    private native double nativeGetOrientationYawAccuracy(long j2, long j3);

    private native double nativeGetVerticalAccuracy(long j2, long j3);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeDestroy(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    public double getAltitude() {
        return nativeGetAltitude(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public float[] getEastUpSouthQuaternion() {
        return nativeEastUpSouthQuaternion(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    @Deprecated
    public double getHeading() {
        return nativeGetHeading(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    @Deprecated
    public double getHeadingAccuracy() {
        return nativeGetHeadingAccuracy(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public double getHorizontalAccuracy() {
        return nativeGetHorizontalAccuracy(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public double getLatitude() {
        return nativeGetLatitude(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public double getLongitude() {
        return nativeGetLongitude(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public double getOrientationYawAccuracy() {
        return nativeGetOrientationYawAccuracy(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public double getVerticalAccuracy() {
        return nativeGetVerticalAccuracy(this.session.nativeWrapperHandle, this.nativeHandle);
    }
}
