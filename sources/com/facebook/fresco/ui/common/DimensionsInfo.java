package com.facebook.fresco.ui.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DimensionsInfo {
    private final int mDecodedImageHeight;
    private final int mDecodedImageWidth;
    private final int mEncodedImageHeight;
    private final int mEncodedImageWidth;
    private final String mScaleType;
    private final int mViewportHeight;
    private final int mViewportWidth;

    public DimensionsInfo(int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        this.mViewportWidth = i2;
        this.mViewportHeight = i3;
        this.mEncodedImageWidth = i4;
        this.mEncodedImageHeight = i5;
        this.mDecodedImageWidth = i6;
        this.mDecodedImageHeight = i7;
        this.mScaleType = str;
    }

    public int getDecodedImageHeight() {
        return this.mDecodedImageHeight;
    }

    public int getDecodedImageWidth() {
        return this.mDecodedImageWidth;
    }

    public int getEncodedImageHeight() {
        return this.mEncodedImageHeight;
    }

    public int getEncodedImageWidth() {
        return this.mEncodedImageWidth;
    }

    public String getScaleType() {
        return this.mScaleType;
    }

    public int getViewportHeight() {
        return this.mViewportHeight;
    }

    public int getViewportWidth() {
        return this.mViewportWidth;
    }

    public String toString() {
        return "DimensionsInfo{mViewportWidth=" + this.mViewportWidth + ", mViewportHeight=" + this.mViewportHeight + ", mEncodedImageWidth=" + this.mEncodedImageWidth + ", mEncodedImageHeight=" + this.mEncodedImageHeight + ", mDecodedImageWidth=" + this.mDecodedImageWidth + ", mDecodedImageHeight=" + this.mDecodedImageHeight + ", mScaleType='" + this.mScaleType + '\'' + '}';
    }
}
