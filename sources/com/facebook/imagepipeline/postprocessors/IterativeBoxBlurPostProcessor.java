package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Locale;

@Nullsafe(Nullsafe.Mode.STRICT)
public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private final int mBlurRadius;
    private CacheKey mCacheKey;
    private final int mIterations;

    public IterativeBoxBlurPostProcessor(int i2) {
        this(3, i2);
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(String.format((Locale) null, "i%dr%d", new Object[]{Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)}));
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap) {
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.mIterations, this.mBlurRadius);
    }

    public IterativeBoxBlurPostProcessor(int i2, int i3) {
        boolean z2 = true;
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0));
        Preconditions.checkArgument(Boolean.valueOf(i3 <= 0 ? false : z2));
        this.mIterations = i2;
        this.mBlurRadius = i3;
    }
}
