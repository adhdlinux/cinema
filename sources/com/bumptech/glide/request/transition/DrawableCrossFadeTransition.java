package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17124a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17125b;

    public DrawableCrossFadeTransition(int i2, boolean z2) {
        this.f17124a = i2;
        this.f17125b = z2;
    }

    /* renamed from: a */
    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f17125b);
        transitionDrawable.startTransition(this.f17124a);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
