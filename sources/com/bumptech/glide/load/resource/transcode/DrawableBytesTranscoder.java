package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f16961a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceTranscoder<Bitmap, byte[]> f16962b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<GifDrawable, byte[]> f16963c;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f16961a = bitmapPool;
        this.f16962b = resourceTranscoder;
        this.f16963c = resourceTranscoder2;
    }

    private static Resource<GifDrawable> b(Resource<Drawable> resource) {
        return resource;
    }

    public Resource<byte[]> a(Resource<Drawable> resource, Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f16962b.a(BitmapResource.c(((BitmapDrawable) drawable).getBitmap(), this.f16961a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f16963c.a(b(resource), options);
        }
        return null;
    }
}
