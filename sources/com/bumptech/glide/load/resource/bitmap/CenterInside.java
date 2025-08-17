package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterInside extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f16820b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(Key.f16305a);

    public void b(MessageDigest messageDigest) {
        messageDigest.update(f16820b);
    }

    /* access modifiers changed from: protected */
    public Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.c(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof CenterInside;
    }

    public int hashCode() {
        return -670243078;
    }
}
