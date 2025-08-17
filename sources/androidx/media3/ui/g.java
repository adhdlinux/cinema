package androidx.media3.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerControlViewLayoutManager f10189a;

    public /* synthetic */ g(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.f10189a = playerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10189a.K(valueAnimator);
    }
}
