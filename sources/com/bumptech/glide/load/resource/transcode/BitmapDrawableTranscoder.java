package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f16960a;

    public BitmapDrawableTranscoder(Resources resources) {
        this.f16960a = (Resources) Preconditions.d(resources);
    }

    public Resource<BitmapDrawable> a(Resource<Bitmap> resource, Options options) {
        return LazyBitmapDrawableResource.c(this.f16960a, resource);
    }
}
