package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public class Config {
    private static final String TAG = "ARCore-Config";
    long nativeHandle;
    final long nativeSymbolTableHandle;
    final Session session;

    public enum AugmentedFaceMode {
        DISABLED(0),
        MESH3D(2);
        
        final int nativeCode;

        private AugmentedFaceMode(int i2) {
            this.nativeCode = i2;
        }

        static AugmentedFaceMode forNumber(int i2) {
            for (AugmentedFaceMode augmentedFaceMode : values()) {
                if (augmentedFaceMode.nativeCode == i2) {
                    return augmentedFaceMode;
                }
            }
            throw new FatalException(p.b((byte) 53, i2, "Unexpected value for native AugmentedFaceMode, value="));
        }
    }

    public enum CloudAnchorMode {
        DISABLED(0),
        ENABLED(1);
        
        final int nativeCode;

        private CloudAnchorMode(int i2) {
            this.nativeCode = i2;
        }

        static CloudAnchorMode forNumber(int i2) {
            for (CloudAnchorMode cloudAnchorMode : values()) {
                if (cloudAnchorMode.nativeCode == i2) {
                    return cloudAnchorMode;
                }
            }
            throw new FatalException(p.b((byte) 53, i2, "Unexpected value for native AnchorHostingMode, value="));
        }
    }

    public enum DepthMode {
        DISABLED(0),
        AUTOMATIC(1),
        RAW_DEPTH_ONLY(3);
        
        final int nativeCode;

        private DepthMode(int i2) {
            this.nativeCode = i2;
        }

        static DepthMode forNumber(int i2) {
            for (DepthMode depthMode : values()) {
                if (depthMode.nativeCode == i2) {
                    return depthMode;
                }
            }
            throw new FatalException(p.b((byte) 45, i2, "Unexpected value for native DepthMode, value="));
        }
    }

    public enum FocusMode {
        FIXED(0),
        AUTO(1);
        
        final int nativeCode;

        private FocusMode(int i2) {
            this.nativeCode = i2;
        }

        static FocusMode forNumber(int i2) {
            for (FocusMode focusMode : values()) {
                if (focusMode.nativeCode == i2) {
                    return focusMode;
                }
            }
            throw new FatalException(p.b((byte) 45, i2, "Unexpected value for native FocusMode, value="));
        }
    }

    public enum GeospatialMode {
        DISABLED(0),
        ENABLED(2);
        
        final int nativeCode;

        private GeospatialMode(int i2) {
            this.nativeCode = i2;
        }

        static GeospatialMode forNumber(int i2) {
            for (GeospatialMode geospatialMode : values()) {
                if (geospatialMode.nativeCode == i2) {
                    return geospatialMode;
                }
            }
            throw new FatalException(p.b((byte) 50, i2, "Unexpected value for native GeospatialMode, value="));
        }
    }

    public enum ImageStabilizationMode {
        OFF(0),
        EIS(1);
        
        final int nativeCode;

        private ImageStabilizationMode(int i2) {
            this.nativeCode = i2;
        }

        static ImageStabilizationMode forNumber(int i2) {
            for (ImageStabilizationMode imageStabilizationMode : values()) {
                if (imageStabilizationMode.nativeCode == i2) {
                    return imageStabilizationMode;
                }
            }
            throw new FatalException(p.b((byte) 58, i2, "Unexpected value for native ImageStabilizationMode, value="));
        }
    }

    public enum InstantPlacementMode {
        DISABLED(0),
        LOCAL_Y_UP(2);
        
        final int nativeCode;

        private InstantPlacementMode(int i2) {
            this.nativeCode = i2;
        }

        static InstantPlacementMode forNumber(int i2) {
            for (InstantPlacementMode instantPlacementMode : values()) {
                if (instantPlacementMode.nativeCode == i2) {
                    return instantPlacementMode;
                }
            }
            throw new FatalException(p.b((byte) 56, i2, "Unexpected value for native InstantPlacementMode, value="));
        }
    }

    public enum LightEstimationMode {
        DISABLED(0),
        AMBIENT_INTENSITY(1),
        ENVIRONMENTAL_HDR(2);
        
        final int nativeCode;

        private LightEstimationMode(int i2) {
            this.nativeCode = i2;
        }

        static LightEstimationMode forNumber(int i2) {
            for (LightEstimationMode lightEstimationMode : values()) {
                if (lightEstimationMode.nativeCode == i2) {
                    return lightEstimationMode;
                }
            }
            throw new FatalException(p.b((byte) 55, i2, "Unexpected value for native LightEstimationMode, value="));
        }
    }

    public enum PlaneFindingMode {
        DISABLED(0),
        HORIZONTAL(1),
        VERTICAL(2),
        HORIZONTAL_AND_VERTICAL(3);
        
        final int nativeCode;

        private PlaneFindingMode(int i2) {
            this.nativeCode = i2;
        }

        static PlaneFindingMode forNumber(int i2) {
            for (PlaneFindingMode planeFindingMode : values()) {
                if (planeFindingMode.nativeCode == i2) {
                    return planeFindingMode;
                }
            }
            throw new FatalException(p.b((byte) 52, i2, "Unexpected value for native PlaneFindingMode, value="));
        }
    }

    public enum SemanticMode {
        DISABLED(0),
        ENABLED(1);
        
        final int nativeCode;

        private SemanticMode(int i2) {
            this.nativeCode = i2;
        }

        static SemanticMode forNumber(int i2) {
            for (SemanticMode semanticMode : values()) {
                if (semanticMode.nativeCode == i2) {
                    return semanticMode;
                }
            }
            throw new FatalException(p.b((byte) 48, i2, "Unexpected value for native SemanticMode, value="));
        }
    }

    public enum StreetscapeGeometryMode {
        DISABLED(0),
        ENABLED(1);
        
        final int nativeCode;

        private StreetscapeGeometryMode(int i2) {
            this.nativeCode = i2;
        }

        static StreetscapeGeometryMode forNumber(int i2) {
            for (StreetscapeGeometryMode streetscapeGeometryMode : values()) {
                if (streetscapeGeometryMode.nativeCode == i2) {
                    return streetscapeGeometryMode;
                }
            }
            throw new FatalException(p.b((byte) 59, i2, "Unexpected value for native StreetscapeGeometryMode, value="));
        }
    }

    public enum TextureUpdateMode {
        BIND_TO_TEXTURE_EXTERNAL_OES(0),
        EXPOSE_HARDWARE_BUFFER(1);
        
        final int nativeCode;

        private TextureUpdateMode(int i2) {
            this.nativeCode = i2;
        }

        static TextureUpdateMode forNumber(int i2) {
            for (TextureUpdateMode textureUpdateMode : values()) {
                if (textureUpdateMode.nativeCode == i2) {
                    return textureUpdateMode;
                }
            }
            throw new FatalException(p.b((byte) 53, i2, "Unexpected value for native TextureUpdateMode, value="));
        }
    }

    public enum UpdateMode {
        BLOCKING(0),
        LATEST_CAMERA_IMAGE(1);
        
        final int nativeCode;

        private UpdateMode(int i2) {
            this.nativeCode = i2;
        }

        static UpdateMode forNumber(int i2) {
            for (UpdateMode updateMode : values()) {
                if (updateMode.nativeCode == i2) {
                    return updateMode;
                }
            }
            throw new FatalException(p.b((byte) 46, i2, "Unexpected value for native UpdateMode, value="));
        }
    }

    protected Config() {
        this.session = null;
        this.nativeHandle = 0;
        this.nativeSymbolTableHandle = 0;
    }

    public Config(Session session2) {
        this.session = session2;
        this.nativeHandle = nativeCreate(session2.nativeWrapperHandle);
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private static native long nativeCreate(long j2);

    private static native void nativeDestroy(long j2, long j3);

    private native int nativeGetAugmentedFaceMode(long j2, long j3);

    private native long nativeGetAugmentedImageDatabase(long j2, long j3);

    private native int nativeGetCloudAnchorMode(long j2, long j3);

    private native int nativeGetDepthMode(long j2, long j3);

    private native int nativeGetFocusMode(long j2, long j3);

    private native int nativeGetGeospatialMode(long j2, long j3, long j4);

    private native int nativeGetImageStabilizationMode(long j2, long j3);

    private native int nativeGetInstantPlacementMode(long j2, long j3);

    private native int nativeGetLightEstimationMode(long j2, long j3);

    private native int nativeGetPlaneFindingMode(long j2, long j3);

    private native int nativeGetSemanticMode(long j2, long j3);

    private native int nativeGetStreetscapeGeometryMode(long j2, long j3, long j4);

    private native int nativeGetTextureUpdateMode(long j2, long j3);

    private native int nativeGetUpdateMode(long j2, long j3);

    private native void nativeSetAugmentedFaceMode(long j2, long j3, int i2);

    private native void nativeSetAugmentedImageDatabase(long j2, long j3, long j4);

    private native void nativeSetCloudAnchorMode(long j2, long j3, int i2);

    private native void nativeSetDepthMode(long j2, long j3, int i2);

    private native void nativeSetFocusMode(long j2, long j3, int i2);

    private native void nativeSetGeospatialMode(long j2, long j3, long j4, int i2);

    private native void nativeSetImageStabilizationMode(long j2, long j3, int i2);

    private native void nativeSetInstantPlacementMode(long j2, long j3, int i2);

    private native void nativeSetLightEstimationMode(long j2, long j3, int i2);

    private native void nativeSetPlaneFindingMode(long j2, long j3, int i2);

    private native void nativeSetSemanticMode(long j2, long j3, int i2);

    private native void nativeSetStreetscapeGeometryMode(long j2, long j3, long j4, int i2);

    private native void nativeSetTextureUpdateMode(long j2, long j3, int i2);

    private native void nativeSetUpdateMode(long j2, long j3, int i2);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeDestroy(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    public AugmentedFaceMode getAugmentedFaceMode() {
        return AugmentedFaceMode.forNumber(nativeGetAugmentedFaceMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public AugmentedImageDatabase getAugmentedImageDatabase() {
        return new AugmentedImageDatabase(this.session, nativeGetAugmentedImageDatabase(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public CloudAnchorMode getCloudAnchorMode() {
        return CloudAnchorMode.forNumber(nativeGetCloudAnchorMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public DepthMode getDepthMode() {
        return DepthMode.forNumber(nativeGetDepthMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public FocusMode getFocusMode() {
        return FocusMode.forNumber(nativeGetFocusMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public GeospatialMode getGeospatialMode() {
        return GeospatialMode.forNumber(nativeGetGeospatialMode(this.nativeSymbolTableHandle, this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public ImageStabilizationMode getImageStabilizationMode() {
        return ImageStabilizationMode.forNumber(nativeGetImageStabilizationMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public InstantPlacementMode getInstantPlacementMode() {
        return InstantPlacementMode.forNumber(nativeGetInstantPlacementMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public LightEstimationMode getLightEstimationMode() {
        return LightEstimationMode.forNumber(nativeGetLightEstimationMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public PlaneFindingMode getPlaneFindingMode() {
        return PlaneFindingMode.forNumber(nativeGetPlaneFindingMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public SemanticMode getSemanticMode() {
        return SemanticMode.forNumber(nativeGetSemanticMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public StreetscapeGeometryMode getStreetscapeGeometryMode() {
        return StreetscapeGeometryMode.forNumber(nativeGetStreetscapeGeometryMode(this.nativeSymbolTableHandle, this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public TextureUpdateMode getTextureUpdateMode() {
        return TextureUpdateMode.forNumber(nativeGetTextureUpdateMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public UpdateMode getUpdateMode() {
        return UpdateMode.forNumber(nativeGetUpdateMode(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public Config setAugmentedFaceMode(AugmentedFaceMode augmentedFaceMode) {
        nativeSetAugmentedFaceMode(this.session.nativeWrapperHandle, this.nativeHandle, augmentedFaceMode.nativeCode);
        return this;
    }

    public Config setAugmentedImageDatabase(AugmentedImageDatabase augmentedImageDatabase) {
        nativeSetAugmentedImageDatabase(this.session.nativeWrapperHandle, this.nativeHandle, augmentedImageDatabase == null ? 0 : augmentedImageDatabase.nativeHandle);
        return this;
    }

    public Config setCloudAnchorMode(CloudAnchorMode cloudAnchorMode) {
        nativeSetCloudAnchorMode(this.session.nativeWrapperHandle, this.nativeHandle, cloudAnchorMode.nativeCode);
        return this;
    }

    public Config setDepthMode(DepthMode depthMode) {
        nativeSetDepthMode(this.session.nativeWrapperHandle, this.nativeHandle, depthMode.nativeCode);
        return this;
    }

    public Config setFocusMode(FocusMode focusMode) {
        nativeSetFocusMode(this.session.nativeWrapperHandle, this.nativeHandle, focusMode.nativeCode);
        return this;
    }

    public Config setGeospatialMode(GeospatialMode geospatialMode) {
        nativeSetGeospatialMode(this.nativeSymbolTableHandle, this.session.nativeWrapperHandle, this.nativeHandle, geospatialMode.nativeCode);
        return this;
    }

    public Config setImageStabilizationMode(ImageStabilizationMode imageStabilizationMode) {
        nativeSetImageStabilizationMode(this.session.nativeWrapperHandle, this.nativeHandle, imageStabilizationMode.nativeCode);
        return this;
    }

    public Config setInstantPlacementMode(InstantPlacementMode instantPlacementMode) {
        nativeSetInstantPlacementMode(this.session.nativeWrapperHandle, this.nativeHandle, instantPlacementMode.nativeCode);
        return this;
    }

    public Config setLightEstimationMode(LightEstimationMode lightEstimationMode) {
        nativeSetLightEstimationMode(this.session.nativeWrapperHandle, this.nativeHandle, lightEstimationMode.nativeCode);
        return this;
    }

    public Config setPlaneFindingMode(PlaneFindingMode planeFindingMode) {
        nativeSetPlaneFindingMode(this.session.nativeWrapperHandle, this.nativeHandle, planeFindingMode.nativeCode);
        return this;
    }

    public Config setSemanticMode(SemanticMode semanticMode) {
        nativeSetSemanticMode(this.session.nativeWrapperHandle, this.nativeHandle, semanticMode.nativeCode);
        return this;
    }

    public Config setStreetscapeGeometryMode(StreetscapeGeometryMode streetscapeGeometryMode) {
        nativeSetStreetscapeGeometryMode(this.nativeSymbolTableHandle, this.session.nativeWrapperHandle, this.nativeHandle, streetscapeGeometryMode.nativeCode);
        return this;
    }

    public Config setTextureUpdateMode(TextureUpdateMode textureUpdateMode) {
        nativeSetTextureUpdateMode(this.session.nativeWrapperHandle, this.nativeHandle, textureUpdateMode.nativeCode);
        return this;
    }

    public Config setUpdateMode(UpdateMode updateMode) {
        nativeSetUpdateMode(this.session.nativeWrapperHandle, this.nativeHandle, updateMode.nativeCode);
        return this;
    }

    Config(Session session2, long j2) {
        this.session = session2;
        this.nativeHandle = j2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }
}
