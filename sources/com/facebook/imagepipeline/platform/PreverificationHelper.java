package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.DoNotOptimize;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotOptimize
class PreverificationHelper {
    PreverificationHelper() {
    }

    /* access modifiers changed from: package-private */
    @DoNotOptimize
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
