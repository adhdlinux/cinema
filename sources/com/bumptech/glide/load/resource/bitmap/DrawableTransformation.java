package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final Transformation<Bitmap> f16853b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16854c;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z2) {
        this.f16853b = transformation;
        this.f16854c = z2;
    }

    private Resource<Drawable> d(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.c(context.getResources(), resource);
    }

    public Resource<Drawable> a(Context context, Resource<Drawable> resource, int i2, int i3) {
        BitmapPool f2 = Glide.c(context).f();
        Drawable drawable = resource.get();
        Resource<Bitmap> a2 = DrawableToBitmapConverter.a(f2, drawable, i2, i3);
        if (a2 != null) {
            Resource<Bitmap> a3 = this.f16853b.a(context, a2, i2, i3);
            if (!a3.equals(a2)) {
                return d(context, a3);
            }
            a3.recycle();
            return resource;
        } else if (!this.f16854c) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public void b(MessageDigest messageDigest) {
        this.f16853b.b(messageDigest);
    }

    public Transformation<BitmapDrawable> c() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f16853b.equals(((DrawableTransformation) obj).f16853b);
        }
        return false;
    }

    public int hashCode() {
        return this.f16853b.hashCode();
    }
}
