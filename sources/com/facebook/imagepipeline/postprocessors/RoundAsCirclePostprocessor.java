package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class RoundAsCirclePostprocessor extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundAsCirclePostprocessor() {
        this(true);
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.mEnableAntiAliasing);
    }

    public RoundAsCirclePostprocessor(boolean z2) {
        this.mEnableAntiAliasing = z2;
    }
}
