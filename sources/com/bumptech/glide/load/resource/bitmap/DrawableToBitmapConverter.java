package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter {

    /* renamed from: a  reason: collision with root package name */
    private static final BitmapPool f16852a = new BitmapPoolAdapter() {
        public void c(Bitmap bitmap) {
        }
    };

    private DrawableToBitmapConverter() {
    }

    static Resource<Bitmap> a(BitmapPool bitmapPool, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z2 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(bitmapPool, current, i2, i3);
            z2 = true;
        } else {
            bitmap = null;
        }
        if (!z2) {
            bitmapPool = f16852a;
        }
        return BitmapResource.c(bitmap, bitmapPool);
    }

    private static Bitmap b(BitmapPool bitmapPool, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i3 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock f2 = TransformationUtils.f();
            f2.lock();
            Bitmap d2 = bitmapPool.d(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(d2);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap((Bitmap) null);
                return d2;
            } finally {
                f2.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}
