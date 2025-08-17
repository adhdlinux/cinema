package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlViewLayoutManager f28295a;

    public /* synthetic */ i(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.f28295a = styledPlayerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f28295a.K(valueAnimator);
    }
}
