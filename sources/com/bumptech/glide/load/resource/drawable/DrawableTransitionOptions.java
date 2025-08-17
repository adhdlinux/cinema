package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public DrawableTransitionOptions e() {
        return f(new DrawableCrossFadeFactory.Builder());
    }

    public DrawableTransitionOptions f(DrawableCrossFadeFactory.Builder builder) {
        return g(builder.a());
    }

    public DrawableTransitionOptions g(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return (DrawableTransitionOptions) d(drawableCrossFadeFactory);
    }
}
