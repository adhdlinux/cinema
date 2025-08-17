package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlViewLayoutManager f28306a;

    public /* synthetic */ t(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.f28306a = styledPlayerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f28306a.J(valueAnimator);
    }
}
