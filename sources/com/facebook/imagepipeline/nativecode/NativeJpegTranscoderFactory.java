package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class NativeJpegTranscoderFactory implements ImageTranscoderFactory {
    private final boolean mEnsureTranscoderLibraryLoaded;
    private final int mMaxBitmapSize;
    private final boolean mUseDownSamplingRatio;

    @DoNotStrip
    public NativeJpegTranscoderFactory(int i2, boolean z2, boolean z3) {
        this.mMaxBitmapSize = i2;
        this.mUseDownSamplingRatio = z2;
        this.mEnsureTranscoderLibraryLoaded = z3;
    }

    @DoNotStrip
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        if (imageFormat != DefaultImageFormats.JPEG) {
            return null;
        }
        return new NativeJpegTranscoder(z2, this.mMaxBitmapSize, this.mUseDownSamplingRatio, this.mEnsureTranscoderLibraryLoaded);
    }
}
