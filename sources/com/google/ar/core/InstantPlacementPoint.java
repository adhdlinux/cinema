package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
import java.util.Collection;

public class InstantPlacementPoint extends TrackableBase {

    public enum TrackingMethod {
        NOT_TRACKING(0),
        SCREENSPACE_WITH_APPROXIMATE_DISTANCE(1),
        FULL_TRACKING(2);
        
        final int nativeCode;

        private TrackingMethod(int i2) {
            this.nativeCode = i2;
        }

        static TrackingMethod fromNumber(int i2) {
            for (TrackingMethod trackingMethod : values()) {
                if (trackingMethod.nativeCode == i2) {
                    return trackingMethod;
                }
            }
            throw new FatalException(p.b((byte) 77, i2, "Unexpected value for native InstantPlacementPoint TrackingMethod Mode, value="));
        }
    }

    InstantPlacementPoint(long j2, Session session) {
        super(j2, session);
    }

    private native Pose nativeGetPose(long j2, long j3);

    private native int nativeGetTrackingMethod(long j2, long j3);

    public /* bridge */ /* synthetic */ Anchor createAnchor(Pose pose) {
        return super.createAnchor(pose);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Collection getAnchors() {
        return super.getAnchors();
    }

    public Pose getPose() {
        return nativeGetPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public TrackingMethod getTrackingMethod() {
        return TrackingMethod.fromNumber(nativeGetTrackingMethod(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public /* bridge */ /* synthetic */ TrackingState getTrackingState() {
        return super.getTrackingState();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }
}
