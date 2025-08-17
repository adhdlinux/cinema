package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: b  reason: collision with root package name */
    private final Resources f16870b;

    /* renamed from: c  reason: collision with root package name */
    private final Resource<Bitmap> f16871c;

    private LazyBitmapDrawableResource(Resources resources, Resource<Bitmap> resource) {
        this.f16870b = (Resources) Preconditions.d(resources);
        this.f16871c = (Resource) Preconditions.d(resource);
    }

    public static Resource<BitmapDrawable> c(Resources resources, Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    /* renamed from: b */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f16870b, this.f16871c.get());
    }

    public int getSize() {
        return this.f16871c.getSize();
    }

    public void initialize() {
        Resource<Bitmap> resource = this.f16871c;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    public void recycle() {
        this.f16871c.recycle();
    }
}
