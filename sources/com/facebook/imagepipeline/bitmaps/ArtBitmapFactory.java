package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@TargetApi(21)
public class ArtBitmapFactory extends PlatformBitmapFactory {
    private final BitmapPool mBitmapPool;
    private final CloseableReferenceFactory mCloseableReferenceFactory;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.mBitmapPool = bitmapPool;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    public CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config) {
        boolean z2;
        Bitmap bitmap = (Bitmap) this.mBitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i2, i3, config));
        if (bitmap.getAllocationByteCount() >= i2 * i3 * BitmapUtil.getPixelSizeForBitmapConfig(config)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        bitmap.reconfigure(i2, i3, config);
        return this.mCloseableReferenceFactory.create(bitmap, this.mBitmapPool);
    }
}
