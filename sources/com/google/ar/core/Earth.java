package com.google.ar.core;

import com.google.ar.core.Anchor;
import com.google.ar.core.ResolveAnchorOnRooftopFuture;
import com.google.ar.core.ResolveAnchorOnTerrainFuture;
import com.google.ar.core.exceptions.FatalException;
import java.util.Collection;
import java.util.function.BiConsumer;

public class Earth extends TrackableBase {

    public enum EarthState {
        ENABLED(0),
        ERROR_INTERNAL(-1),
        ERROR_GEOSPATIAL_MODE_DISABLED(-2),
        ERROR_NOT_AUTHORIZED(-3),
        ERROR_RESOURCE_EXHAUSTED(-4),
        ERROR_APK_VERSION_TOO_OLD(-5);
        
        final int nativeCode;

        private EarthState(int i2) {
            this.nativeCode = i2;
        }

        static EarthState forNumber(int i2) {
            for (EarthState earthState : values()) {
                if (earthState.nativeCode == i2) {
                    return earthState;
                }
            }
            throw new FatalException(p.b((byte) 46, i2, "Unexpected value for native EarthState, value="));
        }
    }

    Earth(long j2, Session session) {
        super(j2, session);
    }

    private native long nativeCreateAnchor(long j2, long j3, double d2, double d3, double d4, float f2, float f3, float f4, float f5);

    private native long nativeGetCameraGeospatialPose(long j2, long j3);

    private native int nativeGetEarthState(long j2, long j3);

    private native long nativeGetGeospatialPose(long j2, long j3, Pose pose);

    private native Pose nativeGetPose(long j2, long j3, double d2, double d3, double d4, float f2, float f3, float f4, float f5);

    private native int nativeGetTrackingState(long j2, long j3);

    private native void nativeReleaseEarth(long j2, long j3);

    private native long[] nativeResolveAnchorOnRooftopAsync(long j2, long j3, double d2, double d3, double d4, float f2, float f3, float f4, float f5, ResolveAnchorOnRooftopFuture.CallbackWrapper callbackWrapper);

    private native long nativeResolveAnchorOnTerrain(long j2, long j3, double d2, double d3, double d4, float f2, float f3, float f4, float f5);

    private native long[] nativeResolveAnchorOnTerrainAsync(long j2, long j3, double d2, double d3, double d4, float f2, float f3, float f4, float f5, ResolveAnchorOnTerrainFuture.CallbackWrapper callbackWrapper);

    public Anchor createAnchor(double d2, double d3, double d4, float f2, float f3, float f4, float f5) {
        return new Anchor(nativeCreateAnchor(this.session.nativeWrapperHandle, this.nativeHandle, d2, d3, d4, f2, f3, f4, f5), this.session);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleaseEarth(this.nativeSymbolTableHandle, j2);
            this.nativeHandle = 0;
        }
        super.finalize();
    }

    public /* bridge */ /* synthetic */ Collection getAnchors() {
        return super.getAnchors();
    }

    public GeospatialPose getCameraGeospatialPose() {
        return new GeospatialPose(nativeGetCameraGeospatialPose(this.session.nativeWrapperHandle, this.nativeHandle), this.session);
    }

    public EarthState getEarthState() {
        return EarthState.forNumber(nativeGetEarthState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public GeospatialPose getGeospatialPose(Pose pose) {
        return new GeospatialPose(nativeGetGeospatialPose(this.session.nativeWrapperHandle, this.nativeHandle, pose), this.session);
    }

    public Pose getPose(double d2, double d3, double d4, float f2, float f3, float f4, float f5) {
        return nativeGetPose(this.session.nativeWrapperHandle, this.nativeHandle, d2, d3, d4, f2, f3, f4, f5);
    }

    public TrackingState getTrackingState() {
        return TrackingState.forNumber(nativeGetTrackingState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public ResolveAnchorOnRooftopFuture resolveAnchorOnRooftopAsync(double d2, double d3, double d4, float f2, float f3, float f4, float f5, BiConsumer<Anchor, Anchor.RooftopAnchorState> biConsumer) {
        ResolveAnchorOnRooftopFuture.CallbackWrapper callbackWrapper;
        BiConsumer<Anchor, Anchor.RooftopAnchorState> biConsumer2 = biConsumer;
        if (biConsumer2 != null) {
            callbackWrapper = new ResolveAnchorOnRooftopFuture.CallbackWrapper(this.session, biConsumer2);
        } else {
            callbackWrapper = null;
        }
        long[] nativeResolveAnchorOnRooftopAsync = nativeResolveAnchorOnRooftopAsync(this.session.nativeWrapperHandle, this.nativeHandle, d2, d3, d4, f2, f3, f4, f5, callbackWrapper);
        return new ResolveAnchorOnRooftopFuture(this.session, nativeResolveAnchorOnRooftopAsync[0], nativeResolveAnchorOnRooftopAsync[1]);
    }

    @Deprecated
    public Anchor resolveAnchorOnTerrain(double d2, double d3, double d4, float f2, float f3, float f4, float f5) {
        return new Anchor(nativeResolveAnchorOnTerrain(this.session.nativeWrapperHandle, this.nativeHandle, d2, d3, d4, f2, f3, f4, f5), this.session);
    }

    public ResolveAnchorOnTerrainFuture resolveAnchorOnTerrainAsync(double d2, double d3, double d4, float f2, float f3, float f4, float f5, BiConsumer<Anchor, Anchor.TerrainAnchorState> biConsumer) {
        ResolveAnchorOnTerrainFuture.CallbackWrapper callbackWrapper;
        BiConsumer<Anchor, Anchor.TerrainAnchorState> biConsumer2 = biConsumer;
        if (biConsumer2 != null) {
            callbackWrapper = new ResolveAnchorOnTerrainFuture.CallbackWrapper(this.session, biConsumer2);
        } else {
            callbackWrapper = null;
        }
        long[] nativeResolveAnchorOnTerrainAsync = nativeResolveAnchorOnTerrainAsync(this.session.nativeWrapperHandle, this.nativeHandle, d2, d3, d4, f2, f3, f4, f5, callbackWrapper);
        return new ResolveAnchorOnTerrainFuture(this.session, nativeResolveAnchorOnTerrainAsync[0], nativeResolveAnchorOnTerrainAsync[1]);
    }

    public Anchor createAnchor(double d2, double d3, double d4, float[] fArr) {
        return new Anchor(nativeCreateAnchor(this.session.nativeWrapperHandle, this.nativeHandle, d2, d3, d4, fArr[0], fArr[1], fArr[2], fArr[3]), this.session);
    }

    @Deprecated
    public Anchor createAnchor(Pose pose) {
        throw new IllegalArgumentException("Earth does not support createAnchor using a Pose. Use createAnchor with Geospatial coordinates instead.");
    }
}
