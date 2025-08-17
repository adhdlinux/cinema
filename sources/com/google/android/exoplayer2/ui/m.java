package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlViewLayoutManager f28299a;

    public /* synthetic */ m(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.f28299a = styledPlayerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f28299a.M(valueAnimator);
    }
}
