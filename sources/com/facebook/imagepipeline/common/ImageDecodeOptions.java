package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageDecodeOptions {
    private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
    public final Bitmap.Config animatedBitmapConfig;
    public final Bitmap.Config bitmapConfig;
    public final BitmapTransformation bitmapTransformation;
    public final ColorSpace colorSpace;
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    private final boolean excludeBitmapConfigFromComparison;
    public final boolean forceStaticImage;
    public final int maxDimensionPx;
    public final int minDecodeIntervalMs;
    public final boolean useLastFrameForPreview;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.getMinDecodeIntervalMs();
        this.maxDimensionPx = imageDecodeOptionsBuilder.getMaxDimensionPx();
        this.decodePreviewFrame = imageDecodeOptionsBuilder.getDecodePreviewFrame();
        this.useLastFrameForPreview = imageDecodeOptionsBuilder.getUseLastFrameForPreview();
        this.decodeAllFrames = imageDecodeOptionsBuilder.getDecodeAllFrames();
        this.forceStaticImage = imageDecodeOptionsBuilder.getForceStaticImage();
        this.bitmapConfig = imageDecodeOptionsBuilder.getBitmapConfig();
        this.animatedBitmapConfig = imageDecodeOptionsBuilder.getAnimatedBitmapConfig();
        this.customImageDecoder = imageDecodeOptionsBuilder.getCustomImageDecoder();
        this.bitmapTransformation = imageDecodeOptionsBuilder.getBitmapTransformation();
        this.colorSpace = imageDecodeOptionsBuilder.getColorSpace();
        this.excludeBitmapConfigFromComparison = imageDecodeOptionsBuilder.getExcludeBitmapConfigFromComparison();
    }

    public static ImageDecodeOptions defaults() {
        return DEFAULTS;
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        return new ImageDecodeOptionsBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        if (this.minDecodeIntervalMs != imageDecodeOptions.minDecodeIntervalMs || this.maxDimensionPx != imageDecodeOptions.maxDimensionPx || this.decodePreviewFrame != imageDecodeOptions.decodePreviewFrame || this.useLastFrameForPreview != imageDecodeOptions.useLastFrameForPreview || this.decodeAllFrames != imageDecodeOptions.decodeAllFrames || this.forceStaticImage != imageDecodeOptions.forceStaticImage) {
            return false;
        }
        boolean z2 = this.excludeBitmapConfigFromComparison;
        if (!z2 && this.bitmapConfig != imageDecodeOptions.bitmapConfig) {
            return false;
        }
        if ((z2 || this.animatedBitmapConfig == imageDecodeOptions.animatedBitmapConfig) && this.customImageDecoder == imageDecodeOptions.customImageDecoder && this.bitmapTransformation == imageDecodeOptions.bitmapTransformation && this.colorSpace == imageDecodeOptions.colorSpace) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5 = (((((((((this.minDecodeIntervalMs * 31) + this.maxDimensionPx) * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0);
        if (!this.excludeBitmapConfigFromComparison) {
            i5 = (i5 * 31) + this.bitmapConfig.ordinal();
        }
        int i6 = 0;
        if (!this.excludeBitmapConfigFromComparison) {
            int i7 = i5 * 31;
            Bitmap.Config config = this.animatedBitmapConfig;
            if (config != null) {
                i4 = config.ordinal();
            } else {
                i4 = 0;
            }
            i5 = i7 + i4;
        }
        int i8 = i5 * 31;
        ImageDecoder imageDecoder = this.customImageDecoder;
        if (imageDecoder != null) {
            i2 = imageDecoder.hashCode();
        } else {
            i2 = 0;
        }
        int i9 = (i8 + i2) * 31;
        BitmapTransformation bitmapTransformation2 = this.bitmapTransformation;
        if (bitmapTransformation2 != null) {
            i3 = bitmapTransformation2.hashCode();
        } else {
            i3 = 0;
        }
        int i10 = (i9 + i3) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        if (colorSpace2 != null) {
            i6 = colorSpace2.hashCode();
        }
        return i10 + i6;
    }

    public String toString() {
        return "ImageDecodeOptions{" + toStringHelper().toString() + "}";
    }

    /* access modifiers changed from: protected */
    public Objects.ToStringHelper toStringHelper() {
        return Objects.toStringHelper((Object) this).add("minDecodeIntervalMs", this.minDecodeIntervalMs).add("maxDimensionPx", this.maxDimensionPx).add("decodePreviewFrame", this.decodePreviewFrame).add("useLastFrameForPreview", this.useLastFrameForPreview).add("decodeAllFrames", this.decodeAllFrames).add("forceStaticImage", this.forceStaticImage).add("bitmapConfigName", (Object) this.bitmapConfig.name()).add("animatedBitmapConfigName", (Object) this.animatedBitmapConfig.name()).add("customImageDecoder", (Object) this.customImageDecoder).add("bitmapTransformation", (Object) this.bitmapTransformation).add("colorSpace", (Object) this.colorSpace);
    }
}
