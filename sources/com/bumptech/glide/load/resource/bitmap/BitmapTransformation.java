package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public final Resource<Bitmap> a(Context context, Resource<Bitmap> resource, int i2, int i3) {
        if (Util.r(i2, i3)) {
            BitmapPool f2 = Glide.c(context).f();
            Bitmap bitmap = resource.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap c2 = c(f2, bitmap, i2, i3);
            if (bitmap.equals(c2)) {
                return resource;
            }
            return BitmapResource.c(c2, f2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3);
}
