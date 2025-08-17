package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class GingerbreadBitmapFactory extends PlatformBitmapFactory {
    public CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config) {
        return CloseableReference.of(Bitmap.createBitmap(i2, i3, config), SimpleBitmapReleaser.getInstance());
    }
}
