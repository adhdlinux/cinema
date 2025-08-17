package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public class Anchor {
    long nativeHandle;
    final long nativeSymbolTableHandle;
    private final Session session;

    public enum CloudAnchorState {
        NONE(0),
        TASK_IN_PROGRESS(1),
        SUCCESS(2),
        ERROR_INTERNAL(-1),
        ERROR_NOT_AUTHORIZED(-2),
        ERROR_SERVICE_UNAVAILABLE(-3),
        ERROR_RESOURCE_EXHAUSTED(-4),
        ERROR_HOSTING_DATASET_PROCESSING_FAILED(-5),
        ERROR_CLOUD_ID_NOT_FOUND(-6),
        ERROR_RESOLVING_LOCALIZATION_NO_MATCH(-7),
        ERROR_RESOLVING_SDK_VERSION_TOO_OLD(-8),
        ERROR_RESOLVING_SDK_VERSION_TOO_NEW(-9),
        ERROR_HOSTING_SERVICE_UNAVAILABLE(-10);
        
        final int nativeCode;

        private CloudAnchorState(int i2) {
            this.nativeCode = i2;
        }

        public static CloudAnchorState forNumber(int i2) {
            for (CloudAnchorState cloudAnchorState : values()) {
                if (cloudAnchorState.nativeCode == i2) {
                    return cloudAnchorState;
                }
            }
            throw new FatalException(p.b((byte) 52, i2, "Unexpected value for native CloudAnchorState, value="));
        }

        public boolean isError() {
            return this.nativeCode < 0;
        }
    }

    public enum RooftopAnchorState {
        NONE(0),
        SUCCESS(1),
        ERROR_INTERNAL(-1),
        ERROR_NOT_AUTHORIZED(-2),
        ERROR_UNSUPPORTED_LOCATION(-3);
        
        final int nativeCode;

        private RooftopAnchorState(int i2) {
            this.nativeCode = i2;
        }

        public static RooftopAnchorState forNumber(int i2) {
            for (RooftopAnchorState rooftopAnchorState : values()) {
                if (rooftopAnchorState.nativeCode == i2) {
                    return rooftopAnchorState;
                }
            }
            throw new FatalException(p.b((byte) 54, i2, "Unexpected value for native RooftopAnchorState, value="));
        }

        public boolean isError() {
            return this.nativeCode < 0;
        }
    }

    public enum TerrainAnchorState {
        NONE(0),
        TASK_IN_PROGRESS(1),
        SUCCESS(2),
        ERROR_INTERNAL(-1),
        ERROR_NOT_AUTHORIZED(-2),
        ERROR_UNSUPPORTED_LOCATION(-3);
        
        final int nativeCode;

        private TerrainAnchorState(int i2) {
            this.nativeCode = i2;
        }

        public static TerrainAnchorState forNumber(int i2) {
            for (TerrainAnchorState terrainAnchorState : values()) {
                if (terrainAnchorState.nativeCode == i2) {
                    return terrainAnchorState;
                }
            }
            throw new FatalException(p.b((byte) 54, i2, "Unexpected value for native TerrainAnchorState, value="));
        }

        public boolean isError() {
            return this.nativeCode < 0;
        }
    }

    protected Anchor() {
        this.session = null;
        this.nativeHandle = 0;
        this.nativeSymbolTableHandle = 0;
    }

    Anchor(long j2, Session session2) {
        this.session = session2;
        this.nativeHandle = j2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private native void nativeDetach(long j2, long j3);

    private native String nativeGetCloudAnchorId(long j2, long j3);

    private native int nativeGetCloudAnchorState(long j2, long j3);

    private native Pose nativeGetPose(long j2, long j3);

    private native int nativeGetTerrainAnchorState(long j2, long j3);

    private native int nativeGetTrackingState(long j2, long j3);

    static native void nativeReleaseAnchor(long j2, long j3);

    public void detach() {
        nativeDetach(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Anchor) && ((Anchor) obj).nativeHandle == this.nativeHandle) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleaseAnchor(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    @Deprecated
    public String getCloudAnchorId() {
        return nativeGetCloudAnchorId(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    @Deprecated
    public CloudAnchorState getCloudAnchorState() {
        return CloudAnchorState.forNumber(nativeGetCloudAnchorState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public Pose getPose() {
        return nativeGetPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    @Deprecated
    public TerrainAnchorState getTerrainAnchorState() {
        return TerrainAnchorState.forNumber(nativeGetTerrainAnchorState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public TrackingState getTrackingState() {
        return TrackingState.forNumber(nativeGetTrackingState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public int hashCode() {
        return Long.valueOf(this.nativeHandle).hashCode();
    }
}
