package t0;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.ui.DefaultTimeBar;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTimeBar f29228a;

    public /* synthetic */ b(DefaultTimeBar defaultTimeBar) {
        this.f29228a = defaultTimeBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f29228a.l(valueAnimator);
    }
}
