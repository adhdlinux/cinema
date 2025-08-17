package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

interface LruPoolStrategy {
    String a(Bitmap bitmap);

    String b(int i2, int i3, Bitmap.Config config);

    void c(Bitmap bitmap);

    Bitmap d(int i2, int i3, Bitmap.Config config);

    int e(Bitmap bitmap);

    Bitmap removeLast();
}
