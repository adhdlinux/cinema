package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class b2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f2889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2890b;

    public /* synthetic */ b2(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f2889a = viewPropertyAnimatorUpdateListener;
        this.f2890b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2889a.a(this.f2890b);
    }
}
