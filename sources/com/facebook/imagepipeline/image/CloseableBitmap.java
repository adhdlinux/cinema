package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class CloseableBitmap extends CloseableImage {
    public abstract Bitmap getUnderlyingBitmap();
}
