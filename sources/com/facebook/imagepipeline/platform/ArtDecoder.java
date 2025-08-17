package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.util.Preconditions;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@TargetApi(21)
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool bitmapPool, int i2, Pools$SynchronizedPool pools$SynchronizedPool) {
        super(bitmapPool, i2, pools$SynchronizedPool);
    }

    public int getBitmapSize(int i2, int i3, BitmapFactory.Options options) {
        return BitmapUtil.getSizeInByteForBitmap(i2, i3, (Bitmap.Config) Preconditions.g(options.inPreferredConfig));
    }
}
