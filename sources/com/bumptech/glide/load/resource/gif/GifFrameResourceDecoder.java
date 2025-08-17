package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f16952a;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f16952a = bitmapPool;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(GifDecoder gifDecoder, int i2, int i3, Options options) {
        return BitmapResource.c(gifDecoder.a(), this.f16952a);
    }

    /* renamed from: d */
    public boolean a(GifDecoder gifDecoder, Options options) {
        return true;
    }
}
