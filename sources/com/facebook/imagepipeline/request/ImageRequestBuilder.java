package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

public class ImageRequestBuilder {
    private BytesRange mBytesRange = null;
    private ImageRequest.CacheChoice mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
    private Boolean mDecodePrefetches = null;
    private int mDelayMs;
    private boolean mDiskCacheEnabled = true;
    private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
    private boolean mLocalThumbnailPreviewsEnabled = false;
    private ImageRequest.RequestLevel mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
    private boolean mMemoryCacheEnabled = true;
    private Postprocessor mPostprocessor = null;
    private boolean mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
    private RequestListener mRequestListener;
    private Priority mRequestPriority = Priority.HIGH;
    private ResizeOptions mResizeOptions = null;
    private Boolean mResizingAllowedOverride = null;
    private RotationOptions mRotationOptions = null;
    private Uri mSourceUri = null;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    private ImageRequestBuilder() {
    }

    public static ImageRequestBuilder fromRequest(ImageRequest imageRequest) {
        return newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions()).setShouldDecodePrefetches(imageRequest.shouldDecodePrefetches()).setDelayMs(imageRequest.getDelayMs());
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int i2) {
        return newBuilderWithSource(UriUtil.getUriForResourceId(i2));
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        return new ImageRequestBuilder().setSource(uri);
    }

    public ImageRequest build() {
        validate();
        return new ImageRequest(this);
    }

    public ImageRequestBuilder disableDiskCache() {
        this.mDiskCacheEnabled = false;
        return this;
    }

    public ImageRequestBuilder disableMemoryCache() {
        this.mMemoryCacheEnabled = false;
        return this;
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ImageRequest.CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public int getDelayMs() {
        return this.mDelayMs;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public Priority getRequestPriority() {
        return this.mRequestPriority;
    }

    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public Boolean getResizingAllowedOverride() {
        return this.mResizingAllowedOverride;
    }

    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled && UriUtil.isNetworkUri(this.mSourceUri);
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mMemoryCacheEnabled;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    @Deprecated
    public ImageRequestBuilder setAutoRotateEnabled(boolean z2) {
        if (z2) {
            return setRotationOptions(RotationOptions.autoRotate());
        }
        return setRotationOptions(RotationOptions.disableRotation());
    }

    public ImageRequestBuilder setBytesRange(BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
        return this;
    }

    public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice cacheChoice) {
        this.mCacheChoice = cacheChoice;
        return this;
    }

    public ImageRequestBuilder setDelayMs(int i2) {
        this.mDelayMs = i2;
        return this;
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions imageDecodeOptions) {
        this.mImageDecodeOptions = imageDecodeOptions;
        return this;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean z2) {
        this.mLocalThumbnailPreviewsEnabled = z2;
        return this;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel requestLevel) {
        this.mLowestPermittedRequestLevel = requestLevel;
        return this;
    }

    public ImageRequestBuilder setPostprocessor(Postprocessor postprocessor) {
        this.mPostprocessor = postprocessor;
        return this;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean z2) {
        this.mProgressiveRenderingEnabled = z2;
        return this;
    }

    public ImageRequestBuilder setRequestListener(RequestListener requestListener) {
        this.mRequestListener = requestListener;
        return this;
    }

    public ImageRequestBuilder setRequestPriority(Priority priority) {
        this.mRequestPriority = priority;
        return this;
    }

    public ImageRequestBuilder setResizeOptions(ResizeOptions resizeOptions) {
        this.mResizeOptions = resizeOptions;
        return this;
    }

    public ImageRequestBuilder setResizingAllowedOverride(Boolean bool) {
        this.mResizingAllowedOverride = bool;
        return this;
    }

    public ImageRequestBuilder setRotationOptions(RotationOptions rotationOptions) {
        this.mRotationOptions = rotationOptions;
        return this;
    }

    public ImageRequestBuilder setShouldDecodePrefetches(Boolean bool) {
        this.mDecodePrefetches = bool;
        return this;
    }

    public ImageRequestBuilder setSource(Uri uri) {
        Preconditions.checkNotNull(uri);
        this.mSourceUri = uri;
        return this;
    }

    public Boolean shouldDecodePrefetches() {
        return this.mDecodePrefetches;
    }

    /* access modifiers changed from: protected */
    public void validate() {
        Uri uri = this.mSourceUri;
        if (uri != null) {
            if (UriUtil.isLocalResourceUri(uri)) {
                if (!this.mSourceUri.isAbsolute()) {
                    throw new BuilderException("Resource URI path must be absolute.");
                } else if (!this.mSourceUri.getPath().isEmpty()) {
                    try {
                        this.mSourceUri.getPath().substring(1);
                    } catch (NumberFormatException unused) {
                        throw new BuilderException("Resource URI path must be a resource id.");
                    }
                } else {
                    throw new BuilderException("Resource URI must not be empty");
                }
            }
            if (UriUtil.isLocalAssetUri(this.mSourceUri) && !this.mSourceUri.isAbsolute()) {
                throw new BuilderException("Asset URI path must be absolute.");
            }
            return;
        }
        throw new BuilderException("Source must be set!");
    }
}
