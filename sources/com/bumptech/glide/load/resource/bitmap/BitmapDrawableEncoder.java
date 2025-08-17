package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f16809a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceEncoder<Bitmap> f16810b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f16809a = bitmapPool;
        this.f16810b = resourceEncoder;
    }

    public EncodeStrategy b(Options options) {
        return this.f16810b.b(options);
    }

    /* renamed from: c */
    public boolean a(Resource<BitmapDrawable> resource, File file, Options options) {
        return this.f16810b.a(new BitmapResource(resource.get().getBitmap(), this.f16809a), file, options);
    }
}
