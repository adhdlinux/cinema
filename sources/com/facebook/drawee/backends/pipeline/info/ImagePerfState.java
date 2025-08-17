package com.facebook.drawee.backends.pipeline.info;

import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImagePerfState {
    private Object mCallerContext;
    private String mComponentTag;
    private long mControllerCancelTimeMs = -1;
    private long mControllerFailureTimeMs = -1;
    private long mControllerFinalImageSetTimeMs = -1;
    private ImageRequest[] mControllerFirstAvailableImageRequests;
    private String mControllerId;
    private ImageRequest mControllerImageRequest;
    private long mControllerIntermediateImageSetTimeMs = -1;
    private ImageRequest mControllerLowResImageRequest;
    private long mControllerSubmitTimeMs = -1;
    private DimensionsInfo mDimensionsInfo;
    private Throwable mErrorThrowable;
    private ControllerListener2.Extras mExtraData;
    private long mImageDrawTimeMs = -1;
    private ImageInfo mImageInfo;
    private int mImageLoadStatus = -1;
    private int mImageOrigin = 1;
    private ImageRequest mImageRequest;
    private long mImageRequestEndTimeMs = -1;
    private long mImageRequestStartTimeMs = -1;
    private long mInvisibilityEventTimeMs = -1;
    private boolean mIsPrefetch;
    private int mOnScreenHeightPx = -1;
    private int mOnScreenWidthPx = -1;
    private String mRequestId;
    private String mUltimateProducerName;
    private long mVisibilityEventTimeMs = -1;
    private int mVisibilityState = -1;

    public DimensionsInfo getDimensionsInfo() {
        return this.mDimensionsInfo;
    }

    public Object getExtraData() {
        return this.mExtraData;
    }

    public long getImageDrawTimeMs() {
        return this.mImageDrawTimeMs;
    }

    public int getImageLoadStatus() {
        return this.mImageLoadStatus;
    }

    public void reset() {
        this.mRequestId = null;
        this.mImageRequest = null;
        this.mCallerContext = null;
        this.mImageInfo = null;
        this.mControllerImageRequest = null;
        this.mControllerLowResImageRequest = null;
        this.mControllerFirstAvailableImageRequests = null;
        this.mImageOrigin = 1;
        this.mUltimateProducerName = null;
        this.mIsPrefetch = false;
        this.mOnScreenWidthPx = -1;
        this.mOnScreenHeightPx = -1;
        this.mErrorThrowable = null;
        this.mImageLoadStatus = -1;
        this.mVisibilityState = -1;
        this.mComponentTag = null;
        this.mDimensionsInfo = null;
        this.mExtraData = null;
        resetPointsTimestamps();
    }

    public void resetPointsTimestamps() {
        this.mImageRequestStartTimeMs = -1;
        this.mImageRequestEndTimeMs = -1;
        this.mControllerSubmitTimeMs = -1;
        this.mControllerFinalImageSetTimeMs = -1;
        this.mControllerFailureTimeMs = -1;
        this.mControllerCancelTimeMs = -1;
        this.mVisibilityEventTimeMs = -1;
        this.mInvisibilityEventTimeMs = -1;
        this.mImageDrawTimeMs = -1;
    }

    public void setCallerContext(Object obj) {
        this.mCallerContext = obj;
    }

    public void setComponentTag(String str) {
        this.mComponentTag = str;
    }

    public void setControllerCancelTimeMs(long j2) {
        this.mControllerCancelTimeMs = j2;
    }

    public void setControllerFailureTimeMs(long j2) {
        this.mControllerFailureTimeMs = j2;
    }

    public void setControllerFinalImageSetTimeMs(long j2) {
        this.mControllerFinalImageSetTimeMs = j2;
    }

    public void setControllerId(String str) {
        this.mControllerId = str;
    }

    public void setControllerImageRequests(ImageRequest imageRequest, ImageRequest imageRequest2, ImageRequest[] imageRequestArr) {
        this.mControllerImageRequest = imageRequest;
        this.mControllerLowResImageRequest = imageRequest2;
        this.mControllerFirstAvailableImageRequests = imageRequestArr;
    }

    public void setControllerIntermediateImageSetTimeMs(long j2) {
        this.mControllerIntermediateImageSetTimeMs = j2;
    }

    public void setControllerSubmitTimeMs(long j2) {
        this.mControllerSubmitTimeMs = j2;
    }

    public void setDimensionsInfo(DimensionsInfo dimensionsInfo) {
        this.mDimensionsInfo = dimensionsInfo;
    }

    public void setErrorThrowable(Throwable th) {
        this.mErrorThrowable = th;
    }

    public void setExtraData(ControllerListener2.Extras extras) {
        this.mExtraData = extras;
    }

    public void setImageDrawTimeMs(long j2) {
        this.mImageDrawTimeMs = j2;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.mImageInfo = imageInfo;
    }

    public void setImageLoadStatus(int i2) {
        this.mImageLoadStatus = i2;
    }

    public void setImageOrigin(int i2) {
        this.mImageOrigin = i2;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        this.mImageRequest = imageRequest;
    }

    public void setImageRequestEndTimeMs(long j2) {
        this.mImageRequestEndTimeMs = j2;
    }

    public void setImageRequestStartTimeMs(long j2) {
        this.mImageRequestStartTimeMs = j2;
    }

    public void setInvisibilityEventTimeMs(long j2) {
        this.mInvisibilityEventTimeMs = j2;
    }

    public void setOnScreenHeight(int i2) {
        this.mOnScreenHeightPx = i2;
    }

    public void setOnScreenWidth(int i2) {
        this.mOnScreenWidthPx = i2;
    }

    public void setPrefetch(boolean z2) {
        this.mIsPrefetch = z2;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public void setUltimateProducerName(String str) {
        this.mUltimateProducerName = str;
    }

    public void setVisibilityEventTimeMs(long j2) {
        this.mVisibilityEventTimeMs = j2;
    }

    public void setVisible(boolean z2) {
        this.mVisibilityState = z2 ? 1 : 2;
    }

    public ImagePerfData snapshot() {
        return new ImagePerfData(this.mControllerId, this.mRequestId, this.mImageRequest, this.mCallerContext, this.mImageInfo, this.mControllerImageRequest, this.mControllerLowResImageRequest, this.mControllerFirstAvailableImageRequests, this.mControllerSubmitTimeMs, this.mControllerIntermediateImageSetTimeMs, this.mControllerFinalImageSetTimeMs, this.mControllerFailureTimeMs, this.mControllerCancelTimeMs, this.mImageRequestStartTimeMs, this.mImageRequestEndTimeMs, this.mImageOrigin, this.mUltimateProducerName, this.mIsPrefetch, this.mOnScreenWidthPx, this.mOnScreenHeightPx, this.mErrorThrowable, this.mVisibilityState, this.mVisibilityEventTimeMs, this.mInvisibilityEventTimeMs, this.mComponentTag, this.mImageDrawTimeMs, this.mDimensionsInfo, this.mExtraData);
    }
}
