package com.google.ar.core;

import com.google.ar.core.CameraConfig;
import java.util.EnumSet;
import java.util.Iterator;

public class CameraConfigFilter {
    private static final String TAG = "CameraConfigFilter";
    long nativeHandle;
    private final long nativeSymbolTableHandle;
    private final Session session;

    protected CameraConfigFilter() {
        this.session = null;
        this.nativeHandle = 0;
        this.nativeSymbolTableHandle = 0;
    }

    public CameraConfigFilter(Session session2) {
        this.session = session2;
        this.nativeHandle = nativeCreateCameraConfigFilter(session2.nativeWrapperHandle);
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private static native long nativeCreateCameraConfigFilter(long j2);

    private static native void nativeDestroyCameraConfigFilter(long j2, long j3);

    private native int nativeGetDepthSensorUsage(long j2, long j3);

    private native int nativeGetFacingDirection(long j2, long j3);

    private native int nativeGetStereoCameraUsage(long j2, long j3);

    private native int nativeGetTargetFps(long j2, long j3);

    private native void nativeSetDepthSensorUsage(long j2, long j3, int i2);

    private native void nativeSetFacingDirection(long j2, long j3, int i2);

    private native void nativeSetStereoCameraUsage(long j2, long j3, int i2);

    private native void nativeSetTargetFps(long j2, long j3, int i2);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeDestroyCameraConfigFilter(this.nativeSymbolTableHandle, j2);
            this.nativeHandle = 0;
        }
        super.finalize();
    }

    public EnumSet<CameraConfig.DepthSensorUsage> getDepthSensorUsage() {
        return CameraConfig.DepthSensorUsage.forBitFlags(nativeGetDepthSensorUsage(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public CameraConfig.FacingDirection getFacingDirection() {
        return CameraConfig.FacingDirection.forNumber(nativeGetFacingDirection(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public EnumSet<CameraConfig.StereoCameraUsage> getStereoCameraUsage() {
        return CameraConfig.StereoCameraUsage.forBitFlags(nativeGetStereoCameraUsage(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public EnumSet<CameraConfig.TargetFps> getTargetFps() {
        return CameraConfig.TargetFps.forBitFlags(nativeGetTargetFps(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public CameraConfigFilter setDepthSensorUsage(EnumSet<CameraConfig.DepthSensorUsage> enumSet) {
        Iterator<CameraConfig.DepthSensorUsage> it2 = enumSet.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 |= it2.next().nativeCode;
        }
        nativeSetDepthSensorUsage(this.session.nativeWrapperHandle, this.nativeHandle, i2);
        return this;
    }

    public CameraConfigFilter setFacingDirection(CameraConfig.FacingDirection facingDirection) {
        nativeSetFacingDirection(this.session.nativeWrapperHandle, this.nativeHandle, facingDirection.nativeCode);
        return this;
    }

    public CameraConfigFilter setStereoCameraUsage(EnumSet<CameraConfig.StereoCameraUsage> enumSet) {
        Iterator<CameraConfig.StereoCameraUsage> it2 = enumSet.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 |= it2.next().nativeCode;
        }
        nativeSetStereoCameraUsage(this.session.nativeWrapperHandle, this.nativeHandle, i2);
        return this;
    }

    public CameraConfigFilter setTargetFps(EnumSet<CameraConfig.TargetFps> enumSet) {
        Iterator<CameraConfig.TargetFps> it2 = enumSet.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 |= it2.next().nativeCode;
        }
        nativeSetTargetFps(this.session.nativeWrapperHandle, this.nativeHandle, i2);
        return this;
    }
}
