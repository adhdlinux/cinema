package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Set;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DummyTrackingInUseBitmapPool implements BitmapPool {
    private final Set<Bitmap> mInUseValues = Sets.newIdentityHashSet();

    public void trim(MemoryTrimType memoryTrimType) {
    }

    public Bitmap get(int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i2) / 2.0d), Bitmap.Config.RGB_565);
        this.mInUseValues.add(createBitmap);
        return createBitmap;
    }

    public void release(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        this.mInUseValues.remove(bitmap);
        bitmap.recycle();
    }
}
