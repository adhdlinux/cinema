package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.facebook.common.util.UriUtil;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final ResourceDrawableDecoder f16879a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f16880b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f16879a = resourceDrawableDecoder;
        this.f16880b = bitmapPool;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(Uri uri, int i2, int i3, Options options) {
        Resource<Drawable> c2 = this.f16879a.b(uri, i2, i3, options);
        if (c2 == null) {
            return null;
        }
        return DrawableToBitmapConverter.a(this.f16880b, c2.get(), i2, i3);
    }

    /* renamed from: d */
    public boolean a(Uri uri, Options options) {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }
}
