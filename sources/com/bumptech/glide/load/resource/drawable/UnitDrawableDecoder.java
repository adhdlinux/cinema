package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    /* renamed from: c */
    public Resource<Drawable> b(Drawable drawable, int i2, int i3, Options options) {
        return NonOwnedDrawableResource.c(drawable);
    }

    /* renamed from: d */
    public boolean a(Drawable drawable, Options options) {
        return true;
    }
}
