package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class RoundedCornersPostprocessor extends BasePostprocessor {
    private CacheKey mCacheKey;

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey("RoundedCornersPostprocessor");
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap) {
        int min = Math.min(bitmap.getHeight(), bitmap.getWidth());
        NativeRoundingFilter.addRoundedCorners(bitmap, min / 2, min / 3, min / 4, min / 5);
    }
}
