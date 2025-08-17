package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {
    private final boolean mEnsureTranscoderLibraryLoaded;
    private final Integer mImageTranscoderType;
    private final int mMaxBitmapSize;
    private final ImageTranscoderFactory mPrimaryImageTranscoderFactory;
    private final boolean mUseDownSamplingRatio;

    public MultiImageTranscoderFactory(int i2, boolean z2, ImageTranscoderFactory imageTranscoderFactory, Integer num, boolean z3) {
        this.mMaxBitmapSize = i2;
        this.mUseDownSamplingRatio = z2;
        this.mPrimaryImageTranscoderFactory = imageTranscoderFactory;
        this.mImageTranscoderType = num;
        this.mEnsureTranscoderLibraryLoaded = z3;
    }

    private ImageTranscoder getCustomImageTranscoder(ImageFormat imageFormat, boolean z2) {
        ImageTranscoderFactory imageTranscoderFactory = this.mPrimaryImageTranscoderFactory;
        if (imageTranscoderFactory == null) {
            return null;
        }
        return imageTranscoderFactory.createImageTranscoder(imageFormat, z2);
    }

    private ImageTranscoder getImageTranscoderWithType(ImageFormat imageFormat, boolean z2) {
        Integer num = this.mImageTranscoderType;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return getNativeImageTranscoder(imageFormat, z2);
        }
        if (intValue == 1) {
            return getSimpleImageTranscoder(imageFormat, z2);
        }
        throw new IllegalArgumentException("Invalid ImageTranscoderType");
    }

    private ImageTranscoder getNativeImageTranscoder(ImageFormat imageFormat, boolean z2) {
        return NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.mMaxBitmapSize, this.mUseDownSamplingRatio, this.mEnsureTranscoderLibraryLoaded).createImageTranscoder(imageFormat, z2);
    }

    private ImageTranscoder getSimpleImageTranscoder(ImageFormat imageFormat, boolean z2) {
        return new SimpleImageTranscoderFactory(this.mMaxBitmapSize).createImageTranscoder(imageFormat, z2);
    }

    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        ImageTranscoder customImageTranscoder = getCustomImageTranscoder(imageFormat, z2);
        if (customImageTranscoder == null) {
            customImageTranscoder = getImageTranscoderWithType(imageFormat, z2);
        }
        if (customImageTranscoder == null && NativeCodeSetup.getUseNativeCode()) {
            customImageTranscoder = getNativeImageTranscoder(imageFormat, z2);
        }
        if (customImageTranscoder == null) {
            return getSimpleImageTranscoder(imageFormat, z2);
        }
        return customImageTranscoder;
    }
}
