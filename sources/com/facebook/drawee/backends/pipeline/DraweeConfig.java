package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.List;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DraweeConfig {
    private final ImmutableList<DrawableFactory> mCustomDrawableFactories;
    private final Supplier<Boolean> mDebugOverlayEnabledSupplier;
    private final ImagePerfDataListener mImagePerfDataListener;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public static class Builder {
        /* access modifiers changed from: private */
        public List<DrawableFactory> mCustomDrawableFactories;
        /* access modifiers changed from: private */
        public Supplier<Boolean> mDebugOverlayEnabledSupplier;
        /* access modifiers changed from: private */
        public ImagePerfDataListener mImagePerfDataListener;
        /* access modifiers changed from: private */
        public PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

        public Builder addCustomDrawableFactory(DrawableFactory drawableFactory) {
            if (this.mCustomDrawableFactories == null) {
                this.mCustomDrawableFactories = new ArrayList();
            }
            this.mCustomDrawableFactories.add(drawableFactory);
            return this;
        }

        public DraweeConfig build() {
            return new DraweeConfig(this);
        }

        public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> supplier) {
            Preconditions.checkNotNull(supplier);
            this.mDebugOverlayEnabledSupplier = supplier;
            return this;
        }

        public Builder setDrawDebugOverlay(boolean z2) {
            return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(z2)));
        }

        public Builder setImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
            this.mImagePerfDataListener = imagePerfDataListener;
            return this;
        }

        public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory pipelineDraweeControllerFactory) {
            this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ImmutableList<DrawableFactory> getCustomDrawableFactories() {
        return this.mCustomDrawableFactories;
    }

    public Supplier<Boolean> getDebugOverlayEnabledSupplier() {
        return this.mDebugOverlayEnabledSupplier;
    }

    public ImagePerfDataListener getImagePerfDataListener() {
        return this.mImagePerfDataListener;
    }

    public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        return this.mPipelineDraweeControllerFactory;
    }

    private DraweeConfig(Builder builder) {
        Supplier<Boolean> supplier;
        this.mCustomDrawableFactories = builder.mCustomDrawableFactories != null ? ImmutableList.copyOf(builder.mCustomDrawableFactories) : null;
        if (builder.mDebugOverlayEnabledSupplier != null) {
            supplier = builder.mDebugOverlayEnabledSupplier;
        } else {
            supplier = Suppliers.of(Boolean.FALSE);
        }
        this.mDebugOverlayEnabledSupplier = supplier;
        this.mPipelineDraweeControllerFactory = builder.mPipelineDraweeControllerFactory;
        this.mImagePerfDataListener = builder.mImagePerfDataListener;
    }
}
