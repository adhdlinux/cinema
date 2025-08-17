package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {
    private Bitmap.Config mAnimatedBitmapConfig;
    private Bitmap.Config mBitmapConfig;
    private BitmapTransformation mBitmapTransformation;
    private ColorSpace mColorSpace;
    private ImageDecoder mCustomImageDecoder;
    private boolean mDecodeAllFrames;
    private boolean mDecodePreviewFrame;
    private boolean mExcludeBitmapConfigFromComparison;
    private boolean mForceStaticImage;
    private int mMaxDimensionPx = Integer.MAX_VALUE;
    private int mMinDecodeIntervalMs = 100;
    private boolean mUseLastFrameForPreview;

    public ImageDecodeOptionsBuilder() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.mBitmapConfig = config;
        this.mAnimatedBitmapConfig = config;
    }

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }

    public Bitmap.Config getAnimatedBitmapConfig() {
        return this.mAnimatedBitmapConfig;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public ImageDecoder getCustomImageDecoder() {
        return this.mCustomImageDecoder;
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getExcludeBitmapConfigFromComparison() {
        return this.mExcludeBitmapConfigFromComparison;
    }

    public boolean getForceStaticImage() {
        return this.mForceStaticImage;
    }

    public int getMaxDimensionPx() {
        return this.mMaxDimensionPx;
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    /* access modifiers changed from: protected */
    public T getThis() {
        return this;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public T setAnimatedBitmapConfig(Bitmap.Config config) {
        this.mAnimatedBitmapConfig = config;
        return getThis();
    }

    public T setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return getThis();
    }

    public T setBitmapTransformation(BitmapTransformation bitmapTransformation) {
        this.mBitmapTransformation = bitmapTransformation;
        return getThis();
    }

    public T setColorSpace(ColorSpace colorSpace) {
        this.mColorSpace = colorSpace;
        return getThis();
    }

    public T setCustomImageDecoder(ImageDecoder imageDecoder) {
        this.mCustomImageDecoder = imageDecoder;
        return getThis();
    }

    public T setDecodeAllFrames(boolean z2) {
        this.mDecodeAllFrames = z2;
        return getThis();
    }

    public T setDecodePreviewFrame(boolean z2) {
        this.mDecodePreviewFrame = z2;
        return getThis();
    }

    public T setExcludeBitmapConfigFromComparison(boolean z2) {
        this.mExcludeBitmapConfigFromComparison = z2;
        return getThis();
    }

    public T setForceStaticImage(boolean z2) {
        this.mForceStaticImage = z2;
        return getThis();
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        this.mMinDecodeIntervalMs = imageDecodeOptions.minDecodeIntervalMs;
        this.mMaxDimensionPx = imageDecodeOptions.maxDimensionPx;
        this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
        this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
        this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
        this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
        this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
        this.mAnimatedBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
        this.mBitmapTransformation = imageDecodeOptions.bitmapTransformation;
        this.mColorSpace = imageDecodeOptions.colorSpace;
        return getThis();
    }

    public T setMaxDimensionPx(int i2) {
        this.mMaxDimensionPx = i2;
        return getThis();
    }

    public T setMinDecodeIntervalMs(int i2) {
        this.mMinDecodeIntervalMs = i2;
        return getThis();
    }

    public T setUseLastFrameForPreview(boolean z2) {
        this.mUseLastFrameForPreview = z2;
        return getThis();
    }
}
