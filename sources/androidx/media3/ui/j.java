package androidx.media3.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerControlViewLayoutManager f10192a;

    public /* synthetic */ j(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.f10192a = playerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10192a.L(valueAnimator);
    }
}
