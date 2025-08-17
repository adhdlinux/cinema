package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f29497a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f29498b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ViewPropertyAnimator f29499c;

    public HideBottomViewOnScrollBehavior() {
    }

    private void E(V v2, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f29499c = v2.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.f29499c = null;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void F(V v2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f29499c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v2.clearAnimation();
        }
        this.f29498b = 1;
        E(v2, this.f29497a, 175, AnimationUtils.f29397c);
    }

    /* access modifiers changed from: protected */
    public void G(V v2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f29499c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v2.clearAnimation();
        }
        this.f29498b = 2;
        E(v2, 0, 225, AnimationUtils.f29398d);
    }

    public boolean l(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        this.f29497a = v2.getMeasuredHeight();
        return super.l(coordinatorLayout, v2, i2);
    }

    public void r(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f29498b;
        if (i6 != 1 && i3 > 0) {
            F(v2);
        } else if (i6 != 2 && i3 < 0) {
            G(v2);
        }
    }

    public boolean y(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
