package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImagePerfRequestListener extends BaseRequestListener {
    private final MonotonicClock mClock;
    private final ImagePerfState mImagePerfState;

    public ImagePerfRequestListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState) {
        this.mClock = monotonicClock;
        this.mImagePerfState = imagePerfState;
    }

    public void onRequestCancellation(String str) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setRequestId(str);
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(imageRequest);
        this.mImagePerfState.setRequestId(str);
        this.mImagePerfState.setPrefetch(z2);
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        this.mImagePerfState.setImageRequestStartTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(imageRequest);
        this.mImagePerfState.setCallerContext(obj);
        this.mImagePerfState.setRequestId(str);
        this.mImagePerfState.setPrefetch(z2);
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z2) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(imageRequest);
        this.mImagePerfState.setRequestId(str);
        this.mImagePerfState.setPrefetch(z2);
    }
}
