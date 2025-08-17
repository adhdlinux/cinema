package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public interface BitmapPool {
    void a(int i2);

    void b();

    void c(Bitmap bitmap);

    Bitmap d(int i2, int i3, Bitmap.Config config);

    Bitmap e(int i2, int i3, Bitmap.Config config);
}
