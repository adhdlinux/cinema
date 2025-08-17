package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.internal.Objects;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImagePerfData {
    public static final int UNSET = -1;
    private final Object mCallerContext;
    private final String mComponentTag;
    private final long mControllerCancelTimeMs;
    private final long mControllerFailureTimeMs;
    private final long mControllerFinalImageSetTimeMs;
    private final ImageRequest[] mControllerFirstAvailableImageRequests;
    private final String mControllerId;
    private final ImageRequest mControllerImageRequest;
    private final long mControllerIntermediateImageSetTimeMs;
    private final ImageRequest mControllerLowResImageRequest;
    private final long mControllerSubmitTimeMs;
    private final DimensionsInfo mDimensionsInfo;
    private final Throwable mErrorThrowable;
    private ControllerListener2.Extras mExtraData;
    private final long mImageDrawTimeMs;
    private final ImageInfo mImageInfo;
    private final int mImageOrigin;
    private final ImageRequest mImageRequest;
    private final long mImageRequestEndTimeMs;
    private final long mImageRequestStartTimeMs;
    private final long mInvisibilityEventTimeMs;
    private final boolean mIsPrefetch;
    private final int mOnScreenHeightPx;
    private final int mOnScreenWidthPx;
    private final String mRequestId;
    private final String mUltimateProducerName;
    private final long mVisibilityEventTimeMs;
    private final int mVisibilityState;

    public ImagePerfData(String str, String str2, ImageRequest imageRequest, Object obj, ImageInfo imageInfo, ImageRequest imageRequest2, ImageRequest imageRequest3, ImageRequest[] imageRequestArr, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i2, String str3, boolean z2, int i3, int i4, Throwable th, int i5, long j9, long j10, String str4, long j11, DimensionsInfo dimensionsInfo, ControllerListener2.Extras extras) {
        this.mControllerId = str;
        this.mRequestId = str2;
        this.mImageRequest = imageRequest;
        this.mCallerContext = obj;
        this.mImageInfo = imageInfo;
        this.mControllerImageRequest = imageRequest2;
        this.mControllerLowResImageRequest = imageRequest3;
        this.mControllerFirstAvailableImageRequests = imageRequestArr;
        this.mControllerSubmitTimeMs = j2;
        this.mControllerIntermediateImageSetTimeMs = j3;
        this.mControllerFinalImageSetTimeMs = j4;
        this.mControllerFailureTimeMs = j5;
        this.mControllerCancelTimeMs = j6;
        this.mImageRequestStartTimeMs = j7;
        this.mImageRequestEndTimeMs = j8;
        this.mImageOrigin = i2;
        this.mUltimateProducerName = str3;
        this.mIsPrefetch = z2;
        this.mOnScreenWidthPx = i3;
        this.mOnScreenHeightPx = i4;
        this.mErrorThrowable = th;
        this.mVisibilityState = i5;
        this.mVisibilityEventTimeMs = j9;
        this.mInvisibilityEventTimeMs = j10;
        this.mComponentTag = str4;
        this.mImageDrawTimeMs = j11;
        this.mDimensionsInfo = dimensionsInfo;
        this.mExtraData = extras;
    }

    public String createDebugString() {
        return Objects.toStringHelper((Object) this).add("controller ID", (Object) this.mControllerId).add("request ID", (Object) this.mRequestId).add("controller image request", (Object) this.mControllerImageRequest).add("controller low res image request", (Object) this.mControllerLowResImageRequest).add("controller first available image requests", (Object) this.mControllerFirstAvailableImageRequests).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add("origin", (Object) ImageOriginUtils.toString(this.mImageOrigin)).add("ultimateProducerName", (Object) this.mUltimateProducerName).add("prefetch", this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", (Object) this.mImageRequest).add("image info", (Object) this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", (Object) this.mComponentTag).add("visibility event", this.mVisibilityEventTimeMs).add("invisibility event", this.mInvisibilityEventTimeMs).add("image draw event", this.mImageDrawTimeMs).add("dimensions info", (Object) this.mDimensionsInfo).add("extra data", (Object) this.mExtraData).toString();
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public String getComponentTag() {
        return this.mComponentTag;
    }

    public long getControllerFailureTimeMs() {
        return this.mControllerFailureTimeMs;
    }

    public long getControllerFinalImageSetTimeMs() {
        return this.mControllerFinalImageSetTimeMs;
    }

    public ImageRequest[] getControllerFirstAvailableImageRequests() {
        return this.mControllerFirstAvailableImageRequests;
    }

    public String getControllerId() {
        return this.mControllerId;
    }

    public ImageRequest getControllerImageRequest() {
        return this.mControllerImageRequest;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        return this.mControllerIntermediateImageSetTimeMs;
    }

    public ImageRequest getControllerLowResImageRequest() {
        return this.mControllerLowResImageRequest;
    }

    public long getControllerSubmitTimeMs() {
        return this.mControllerSubmitTimeMs;
    }

    public DimensionsInfo getDimensionsInfo() {
        return this.mDimensionsInfo;
    }

    public Throwable getErrorThrowable() {
        return this.mErrorThrowable;
    }

    public ControllerListener2.Extras getExtraData() {
        return this.mExtraData;
    }

    public long getFinalImageLoadTimeMs() {
        if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
            return -1;
        }
        return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
    }

    public long getImageDrawTimeMs() {
        return this.mImageDrawTimeMs;
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getImageOrigin() {
        return this.mImageOrigin;
    }

    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public long getImageRequestEndTimeMs() {
        return this.mImageRequestEndTimeMs;
    }

    public long getImageRequestStartTimeMs() {
        return this.mImageRequestStartTimeMs;
    }

    public long getIntermediateImageLoadTimeMs() {
        if (getControllerIntermediateImageSetTimeMs() == -1 || getControllerSubmitTimeMs() == -1) {
            return -1;
        }
        return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
    }

    public long getInvisibilityEventTimeMs() {
        return this.mInvisibilityEventTimeMs;
    }

    public int getOnScreenHeightPx() {
        return this.mOnScreenHeightPx;
    }

    public int getOnScreenWidthPx() {
        return this.mOnScreenWidthPx;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public String getUltimateProducerName() {
        return this.mUltimateProducerName;
    }

    public long getVisibilityEventTimeMs() {
        return this.mVisibilityEventTimeMs;
    }

    public int getVisibilityState() {
        return this.mVisibilityState;
    }

    public boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    public void setExtraData(ControllerListener2.Extras extras) {
        this.mExtraData = extras;
    }
}
