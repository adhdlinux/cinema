package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;

public class AugmentedFace extends TrackableBase {
    private static final String TAG = "ARCore-AugmentedFace";
    private FloatBuffer normalsBuffer;
    private FloatBuffer textureCoordinatesBuffer;
    private ShortBuffer triangleIndicesBuffer;
    private FloatBuffer verticesBuffer;

    public enum RegionType {
        NOSE_TIP(0),
        FOREHEAD_LEFT(1),
        FOREHEAD_RIGHT(2);
        
        final int nativeCode;

        private RegionType(int i2) {
            this.nativeCode = i2;
        }
    }

    protected AugmentedFace() {
        super(0, (Session) null);
    }

    private native Pose nativeGetCenterPose(long j2, long j3);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j2, long j3);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j2, long j3);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j2, long j3);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j2, long j3);

    private native Pose nativeGetRegionPose(long j2, long j3, int i2);

    public /* bridge */ /* synthetic */ Anchor createAnchor(Pose pose) {
        return super.createAnchor(pose);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Collection getAnchors() {
        return super.getAnchors();
    }

    public Pose getCenterPose() {
        return nativeGetCenterPose(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public FloatBuffer getMeshNormals() {
        return this.normalsBuffer;
    }

    public FloatBuffer getMeshTextureCoordinates() {
        return this.textureCoordinatesBuffer;
    }

    public ShortBuffer getMeshTriangleIndices() {
        return this.triangleIndicesBuffer;
    }

    public FloatBuffer getMeshVertices() {
        return this.verticesBuffer;
    }

    public Pose getRegionPose(RegionType regionType) {
        return nativeGetRegionPose(this.session.nativeWrapperHandle, this.nativeHandle, regionType.nativeCode);
    }

    public /* bridge */ /* synthetic */ TrackingState getTrackingState() {
        return super.getTrackingState();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void populateMeshData() {
        this.verticesBuffer = Session.directByteBufferOrDefault(nativeGetMeshVerticesByteBuffer(this.session.nativeWrapperHandle, this.nativeHandle)).asFloatBuffer();
        this.normalsBuffer = Session.directByteBufferOrDefault(nativeGetMeshNormalsByteBuffer(this.session.nativeWrapperHandle, this.nativeHandle)).asFloatBuffer();
        this.textureCoordinatesBuffer = Session.directByteBufferOrDefault(nativeGetMeshTextureCoordinatesByteBuffer(this.session.nativeWrapperHandle, this.nativeHandle)).asFloatBuffer();
        this.triangleIndicesBuffer = Session.directByteBufferOrDefault(nativeGetMeshTriangleIndicesByteBuffer(this.session.nativeWrapperHandle, this.nativeHandle)).asShortBuffer();
    }

    AugmentedFace(long j2, Session session) {
        super(j2, session);
        populateMeshData();
    }
}
