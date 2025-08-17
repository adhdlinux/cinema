package com.google.ar.core;

import android.animation.ValueAnimator;

final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f30354a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f30355b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f30356c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InstallActivity f30357d;

    t(InstallActivity installActivity, int i2, int i3, int i4) {
        this.f30357d = installActivity;
        this.f30354a = i2;
        this.f30355b = i3;
        this.f30356c = i4;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = ((float) this.f30355b) * valueAnimator.getAnimatedFraction();
        this.f30357d.getWindow().setLayout((int) ((((float) this.f30354a) * animatedFraction) + animatedFraction2), (int) ((((float) this.f30356c) * animatedFraction) + animatedFraction2));
        this.f30357d.getWindow().getDecorView().refreshDrawableState();
    }
}
