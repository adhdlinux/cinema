package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class l implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlViewLayoutManager f28298a;

    public /* synthetic */ l(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.f28298a = styledPlayerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f28298a.L(valueAnimator);
    }
}
