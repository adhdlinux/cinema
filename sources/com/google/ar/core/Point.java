package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
import java.util.Collection;

public class Point extends TrackableBase {

    public enum OrientationMode {
        INITIALIZED_TO_IDENTITY(0),
        ESTIMATED_SURFACE_NORMAL(1);
        
        private final int nativeCode;

        private OrientationMode(int i2) {
            this.nativeCode = i2;
        }

        static OrientationMode forNumber(int i2) {
            for (OrientationMode orientationMode : values()) {
                if (orientationMode.nativeCode == i2) {
                    return orientationMode;
                }
            }
            throw new FatalException(p.b((byte) 58, i2, "Unexpected value for native Point Orientation Mode, value="));
        }
    }

    protected Point() {
        super(0, (Session) null);
    }

    private native int nativeGetOrientationMode(long j2, long j3);

    private native Pose nativeGetPose(long j2, long j3);

    public /* bridge */ /* synthetic */ Anchor createAnchor(Pose pose) {
        return super.createAnchor(pose);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Collection getAnchors() {
        return super.getAnchors();
    }

    public OrientationMode getOrientationMode() {
        return OrientationMode.forNumber(nativeGetOrientationMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public Pose getPose() {
        return nativeGetPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public /* bridge */ /* synthetic */ TrackingState getTrackingState() {
        return super.getTrackingState();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    Point(long j2, Session session) {
        super(j2, session);
    }
}
