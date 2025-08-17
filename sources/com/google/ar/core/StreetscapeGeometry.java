package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
import java.util.Collection;

public class StreetscapeGeometry extends TrackableBase {

    public enum Quality {
        NONE(0),
        BUILDING_LOD_1(1),
        BUILDING_LOD_2(2);
        
        final int nativeCode;

        private Quality(int i2) {
            this.nativeCode = i2;
        }

        static Quality forNumber(int i2) {
            for (Quality quality : values()) {
                if (quality.nativeCode == i2) {
                    return quality;
                }
            }
            throw new FatalException(p.b((byte) 63, i2, "Unexpected value for native StreetscapeGeometry.Quality, value="));
        }
    }

    public enum Type {
        TERRAIN(0),
        BUILDING(1);
        
        final int nativeCode;

        private Type(int i2) {
            this.nativeCode = i2;
        }

        static Type forNumber(int i2) {
            for (Type type : values()) {
                if (type.nativeCode == i2) {
                    return type;
                }
            }
            throw new FatalException(p.b((byte) 60, i2, "Unexpected value for native StreetscapeGeometry.Type, value="));
        }
    }

    StreetscapeGeometry(long j2, Session session) {
        super(j2, session);
    }

    private native long nativeAcquireMesh(long j2, long j3);

    private native Pose nativeGetMeshPose(long j2, long j3);

    private native int nativeGetQuality(long j2, long j3);

    private native int nativeGetType(long j2, long j3);

    private native void nativeReleaseStreetscapeGeometry(long j2, long j3);

    public /* bridge */ /* synthetic */ Anchor createAnchor(Pose pose) {
        return super.createAnchor(pose);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleaseStreetscapeGeometry(this.session.nativeSymbolTableHandle, j2);
            this.nativeHandle = 0;
        }
        super.finalize();
    }

    public /* bridge */ /* synthetic */ Collection getAnchors() {
        return super.getAnchors();
    }

    public Mesh getMesh() {
        long nativeAcquireMesh = nativeAcquireMesh(this.session.nativeWrapperHandle, this.nativeHandle);
        if (nativeAcquireMesh != 0) {
            return new Mesh(nativeAcquireMesh, this.session);
        }
        return null;
    }

    public Pose getMeshPose() {
        return nativeGetMeshPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public Quality getQuality() {
        return Quality.forNumber(nativeGetQuality(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public /* bridge */ /* synthetic */ TrackingState getTrackingState() {
        return super.getTrackingState();
    }

    public Type getType() {
        return Type.forNumber(nativeGetType(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }
}
