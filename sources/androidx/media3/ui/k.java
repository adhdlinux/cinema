package androidx.media3.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerControlViewLayoutManager f10193a;

    public /* synthetic */ k(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.f10193a = playerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10193a.M(valueAnimator);
    }
}
