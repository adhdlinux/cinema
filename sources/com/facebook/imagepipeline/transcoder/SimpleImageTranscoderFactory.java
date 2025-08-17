package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class SimpleImageTranscoderFactory implements ImageTranscoderFactory {
    private final int mMaxBitmapSize;

    public SimpleImageTranscoderFactory(int i2) {
        this.mMaxBitmapSize = i2;
    }

    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        return new SimpleImageTranscoder(z2, this.mMaxBitmapSize);
    }
}
