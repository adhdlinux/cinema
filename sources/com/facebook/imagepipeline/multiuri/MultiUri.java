package com.facebook.imagepipeline.multiuri;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class MultiUri {
    private ImageRequest mHighResImageRequest;
    private ImageRequest mLowResImageRequest;
    private ImageRequest[] mMultiImageRequests;

    public static class Builder {
        /* access modifiers changed from: private */
        public ImageRequest mHighResImageRequest;
        /* access modifiers changed from: private */
        public ImageRequest mLowResImageRequest;
        /* access modifiers changed from: private */
        public ImageRequest[] mMultiImageRequests;

        public MultiUri build() {
            return new MultiUri(this);
        }

        public Builder setHighResImageRequest(ImageRequest imageRequest) {
            this.mHighResImageRequest = imageRequest;
            return this;
        }

        public Builder setImageRequests(ImageRequest... imageRequestArr) {
            this.mMultiImageRequests = imageRequestArr;
            return this;
        }

        public Builder setLowResImageRequest(ImageRequest imageRequest) {
            this.mLowResImageRequest = imageRequest;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder create() {
        return new Builder();
    }

    public ImageRequest getHighResImageRequest() {
        return this.mHighResImageRequest;
    }

    public ImageRequest getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public ImageRequest[] getMultiImageRequests() {
        return this.mMultiImageRequests;
    }

    private MultiUri(Builder builder) {
        this.mLowResImageRequest = builder.mLowResImageRequest;
        this.mHighResImageRequest = builder.mHighResImageRequest;
        this.mMultiImageRequests = builder.mMultiImageRequests;
    }
}
