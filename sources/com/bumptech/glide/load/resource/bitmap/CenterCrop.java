package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterCrop extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f16819b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(Key.f16305a);

    public void b(MessageDigest messageDigest) {
        messageDigest.update(f16819b);
    }

    /* access modifiers changed from: protected */
    public Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.b(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    public int hashCode() {
        return -599754482;
    }
}
