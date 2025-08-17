package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    private long mFinalImageSetTimeMs = -1;
    private ImageLoadingTimeListener mImageLoadingTimeListener;
    private long mRequestSubmitTimeMs = -1;

    public ImageLoadingTimeControllerListener(ImageLoadingTimeListener imageLoadingTimeListener) {
        this.mImageLoadingTimeListener = imageLoadingTimeListener;
    }

    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mFinalImageSetTimeMs = currentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.mImageLoadingTimeListener;
        if (imageLoadingTimeListener != null) {
            imageLoadingTimeListener.onFinalImageSet(currentTimeMillis - this.mRequestSubmitTimeMs);
        }
    }

    public void onSubmit(String str, Object obj) {
        this.mRequestSubmitTimeMs = System.currentTimeMillis();
    }
}
