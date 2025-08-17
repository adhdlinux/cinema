package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public class BitmapPoolAdapter implements BitmapPool {
    public void a(int i2) {
    }

    public void b() {
    }

    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        return d(i2, i3, config);
    }
}
