package androidx.media3.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class r implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerControlViewLayoutManager f10200a;

    public /* synthetic */ r(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.f10200a = playerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10200a.J(valueAnimator);
    }
}
