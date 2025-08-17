package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {

    /* renamed from: j  reason: collision with root package name */
    private Animatable f17105j;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void e(Z z2) {
        if (z2 instanceof Animatable) {
            Animatable animatable = (Animatable) z2;
            this.f17105j = animatable;
            animatable.start();
            return;
        }
        this.f17105j = null;
    }

    private void g(Z z2) {
        f(z2);
        e(z2);
    }

    /* access modifiers changed from: protected */
    public abstract void f(Z z2);

    public Drawable getCurrentDrawable() {
        return ((ImageView) this.f17108c).getDrawable();
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f17105j;
        if (animatable != null) {
            animatable.stop();
        }
        g((Object) null);
        setDrawable(drawable);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        g((Object) null);
        setDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        g((Object) null);
        setDrawable(drawable);
    }

    public void onResourceReady(Z z2, Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z2, this)) {
            g(z2);
        } else {
            e(z2);
        }
    }

    public void onStart() {
        Animatable animatable = this.f17105j;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f17105j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.f17108c).setImageDrawable(drawable);
    }
}
