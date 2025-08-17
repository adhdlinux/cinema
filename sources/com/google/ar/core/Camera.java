package com.google.ar.core;

public class Camera {
    private static final String TAG = "ARCore-Camera";
    long nativeHandle;
    private final long nativeSymbolTableHandle;
    private final Session session;

    protected Camera() {
        this.session = null;
        this.nativeHandle = 0;
        this.nativeSymbolTableHandle = 0;
    }

    Camera(Session session2, Frame frame) {
        this.session = session2;
        this.nativeHandle = nativeAcquireCamera(session2.nativeWrapperHandle, frame.nativeHandle);
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private static native long nativeAcquireCamera(long j2, long j3);

    private native long nativeCreateCameraIntrinsics(long j2);

    private native Pose nativeDisplayOrientedPose(long j2, long j3);

    private native void nativeGetImageIntrinsics(long j2, long j3, long j4);

    private native Pose nativeGetPose(long j2, long j3);

    private native void nativeGetProjectionMatrix(long j2, long j3, float[] fArr, int i2, float f2, float f3);

    private native void nativeGetTextureIntrinsics(long j2, long j3, long j4);

    private native int nativeGetTrackingFailureReason(long j2, long j3);

    private native int nativeGetTrackingState(long j2, long j3);

    private native void nativeGetViewMatrix(long j2, long j3, float[] fArr, int i2);

    private static native void nativeReleaseCamera(long j2, long j3);

    public boolean equals(Object obj) {
        if ((obj instanceof Camera) && ((Camera) obj).nativeHandle == this.nativeHandle) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleaseCamera(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    public Pose getDisplayOrientedPose() {
        return nativeDisplayOrientedPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public CameraIntrinsics getImageIntrinsics() {
        CameraIntrinsics cameraIntrinsics = new CameraIntrinsics(nativeCreateCameraIntrinsics(this.session.nativeWrapperHandle), this.session);
        nativeGetImageIntrinsics(this.session.nativeWrapperHandle, this.nativeHandle, cameraIntrinsics.nativeHandle);
        return cameraIntrinsics;
    }

    public Pose getPose() {
        return nativeGetPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public void getProjectionMatrix(float[] fArr, int i2, float f2, float f3) {
        nativeGetProjectionMatrix(this.session.nativeWrapperHandle, this.nativeHandle, fArr, i2, f2, f3);
    }

    public CameraIntrinsics getTextureIntrinsics() {
        CameraIntrinsics cameraIntrinsics = new CameraIntrinsics(nativeCreateCameraIntrinsics(this.session.nativeWrapperHandle), this.session);
        nativeGetTextureIntrinsics(this.session.nativeWrapperHandle, this.nativeHandle, cameraIntrinsics.nativeHandle);
        return cameraIntrinsics;
    }

    public TrackingFailureReason getTrackingFailureReason() {
        return TrackingFailureReason.forNumber(nativeGetTrackingFailureReason(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public TrackingState getTrackingState() {
        return TrackingState.forNumber(nativeGetTrackingState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public void getViewMatrix(float[] fArr, int i2) {
        nativeGetViewMatrix(this.session.nativeWrapperHandle, this.nativeHandle, fArr, i2);
    }

    public int hashCode() {
        return Long.valueOf(this.nativeHandle).hashCode();
    }
}
