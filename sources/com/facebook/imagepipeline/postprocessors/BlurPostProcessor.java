package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Locale;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class BlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private static final boolean canUseRenderScript = RenderScriptBlurFilter.canUseRenderScript();
    private final int mBlurRadius;
    private CacheKey mCacheKey;
    private final Context mContext;
    private final int mIterations;

    public BlurPostProcessor(int i2, Context context, int i3) {
        boolean z2 = true;
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0 && i2 <= 25));
        Preconditions.checkArgument(Boolean.valueOf(i3 <= 0 ? false : z2));
        Preconditions.checkNotNull(context);
        this.mIterations = i3;
        this.mBlurRadius = i2;
        this.mContext = context;
    }

    public CacheKey getPostprocessorCacheKey() {
        String str;
        if (this.mCacheKey == null) {
            if (canUseRenderScript) {
                str = String.format((Locale) null, "IntrinsicBlur;%d", new Object[]{Integer.valueOf(this.mBlurRadius)});
            } else {
                str = String.format((Locale) null, "IterativeBoxBlur;%d;%d", new Object[]{Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)});
            }
            this.mCacheKey = new SimpleCacheKey(str);
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        if (canUseRenderScript) {
            RenderScriptBlurFilter.blurBitmap(bitmap, bitmap2, this.mContext, this.mBlurRadius);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    public void process(Bitmap bitmap) {
        IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmap, this.mIterations, this.mBlurRadius);
    }

    public BlurPostProcessor(int i2, Context context) {
        this(i2, context, 3);
    }
}
