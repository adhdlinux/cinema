package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class RoundPostprocessor extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private static final boolean canUseXferRoundFilter = XferRoundFilter.canUseXferRoundFilter();
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundPostprocessor() {
        this(true);
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (canUseXferRoundFilter) {
                this.mCacheKey = new SimpleCacheKey("XferRoundFilter");
            } else {
                this.mCacheKey = new SimpleCacheKey("InPlaceRoundFilter");
            }
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkNotNull(bitmap2);
        if (canUseXferRoundFilter) {
            XferRoundFilter.xferRoundBitmap(bitmap, bitmap2, this.mEnableAntiAliasing);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    public RoundPostprocessor(boolean z2) {
        this.mEnableAntiAliasing = z2;
    }

    public void process(Bitmap bitmap) {
        InPlaceRoundFilter.roundBitmapInPlace(bitmap);
    }
}
