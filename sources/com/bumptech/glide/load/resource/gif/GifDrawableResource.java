package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public Class<GifDrawable> a() {
        return GifDrawable.class;
    }

    public int getSize() {
        return ((GifDrawable) this.f16904b).i();
    }

    public void initialize() {
        ((GifDrawable) this.f16904b).e().prepareToDraw();
    }

    public void recycle() {
        ((GifDrawable) this.f16904b).stop();
        ((GifDrawable) this.f16904b).k();
    }
}
