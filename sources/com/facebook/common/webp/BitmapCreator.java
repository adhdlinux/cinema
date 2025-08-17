package com.facebook.common.webp;

import android.graphics.Bitmap;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface BitmapCreator {
    Bitmap createNakedBitmap(int i2, int i3, Bitmap.Config config);
}
