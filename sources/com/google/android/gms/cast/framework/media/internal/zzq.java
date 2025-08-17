package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

final class zzq implements zza {
    final /* synthetic */ zzv zza;

    zzq(zzv zzv) {
        this.zza = zzv;
    }

    public final void zza(Bitmap bitmap) {
        int i2 = zzv.zza;
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            float f2 = (float) width;
            int height = bitmap.getHeight();
            int i3 = (int) (((9.0f * f2) / 16.0f) + 0.5f);
            float f3 = ((float) (i3 - height)) / 2.0f;
            RectF rectF = new RectF(0.0f, f3, f2, ((float) height) + f3);
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, i3, config);
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            bitmap2 = createBitmap;
        }
        this.zza.zzp(bitmap2, 0);
    }
}
