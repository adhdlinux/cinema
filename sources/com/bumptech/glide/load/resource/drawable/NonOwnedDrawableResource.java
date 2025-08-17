package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    static Resource<Drawable> c(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    public Class<Drawable> a() {
        return this.f16904b.getClass();
    }

    public int getSize() {
        return Math.max(1, this.f16904b.getIntrinsicWidth() * this.f16904b.getIntrinsicHeight() * 4);
    }

    public void recycle() {
    }
}
