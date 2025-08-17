package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final ResourceDecoder<DataType, Bitmap> f16807a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f16808b;

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f16808b = (Resources) Preconditions.d(resources);
        this.f16807a = (ResourceDecoder) Preconditions.d(resourceDecoder);
    }

    public boolean a(DataType datatype, Options options) throws IOException {
        return this.f16807a.a(datatype, options);
    }

    public Resource<BitmapDrawable> b(DataType datatype, int i2, int i3, Options options) throws IOException {
        return LazyBitmapDrawableResource.c(this.f16808b, this.f16807a.b(datatype, i2, i3, options));
    }
}
