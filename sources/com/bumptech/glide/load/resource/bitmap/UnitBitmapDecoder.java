package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f16890b;

        NonOwnedBitmapResource(Bitmap bitmap) {
            this.f16890b = bitmap;
        }

        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        /* renamed from: b */
        public Bitmap get() {
            return this.f16890b;
        }

        public int getSize() {
            return Util.g(this.f16890b);
        }

        public void recycle() {
        }
    }

    /* renamed from: c */
    public Resource<Bitmap> b(Bitmap bitmap, int i2, int i3, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    /* renamed from: d */
    public boolean a(Bitmap bitmap, Options options) {
        return true;
    }
}
