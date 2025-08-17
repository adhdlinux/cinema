package p;

import android.animation.ValueAnimator;
import androidx.media3.ui.DefaultTimeBar;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTimeBar f21896a;

    public /* synthetic */ b(DefaultTimeBar defaultTimeBar) {
        this.f21896a = defaultTimeBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f21896a.l(valueAnimator);
    }
}
