package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DummyBitmapPool implements BitmapPool {
    public void trim(MemoryTrimType memoryTrimType) {
    }

    public Bitmap get(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i2) / 2.0d), Bitmap.Config.RGB_565);
    }

    public void release(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }
}
