package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: b  reason: collision with root package name */
    protected final T f16904b;

    public DrawableResource(T t2) {
        this.f16904b = (Drawable) Preconditions.d(t2);
    }

    /* renamed from: b */
    public final T get() {
        Drawable.ConstantState constantState = this.f16904b.getConstantState();
        if (constantState == null) {
            return this.f16904b;
        }
        return constantState.newDrawable();
    }

    public void initialize() {
        T t2 = this.f16904b;
        if (t2 instanceof BitmapDrawable) {
            ((BitmapDrawable) t2).getBitmap().prepareToDraw();
        } else if (t2 instanceof GifDrawable) {
            ((GifDrawable) t2).e().prepareToDraw();
        }
    }
}
