package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f16815b;

    /* renamed from: c  reason: collision with root package name */
    private final BitmapPool f16816c;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.f16815b = (Bitmap) Preconditions.e(bitmap, "Bitmap must not be null");
        this.f16816c = (BitmapPool) Preconditions.e(bitmapPool, "BitmapPool must not be null");
    }

    public static BitmapResource c(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    /* renamed from: b */
    public Bitmap get() {
        return this.f16815b;
    }

    public int getSize() {
        return Util.g(this.f16815b);
    }

    public void initialize() {
        this.f16815b.prepareToDraw();
    }

    public void recycle() {
        this.f16816c.c(this.f16815b);
    }
}
