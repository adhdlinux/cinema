package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@TargetApi(26)
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool bitmapPool, int i2, Pools$SynchronizedPool pools$SynchronizedPool) {
        super(bitmapPool, i2, pools$SynchronizedPool);
    }

    private static boolean hasColorGamutMismatch(BitmapFactory.Options options) {
        if (options.outColorSpace == null || !options.outColorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) {
            return false;
        }
        return true;
    }

    public int getBitmapSize(int i2, int i3, BitmapFactory.Options options) {
        if (hasColorGamutMismatch(options)) {
            return i2 * i3 * 8;
        }
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return BitmapUtil.getSizeInByteForBitmap(i2, i3, config);
    }
}
