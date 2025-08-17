package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class Fade extends Visibility {

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f11720a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11721b = false;

        FadeAnimatorListener(View view) {
            this.f11720a = view;
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtils.h(this.f11720a, 1.0f);
            if (this.f11721b) {
                this.f11720a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.R(this.f11720a) && this.f11720a.getLayerType() == 0) {
                this.f11721b = true;
                this.f11720a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade(int i2) {
        h0(i2);
    }

    private Animator i0(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ViewUtils.h(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.f11801d, new float[]{f3});
        ofFloat.addListener(new FadeAnimatorListener(view));
        a(new TransitionListenerAdapter() {
            public void d(Transition transition) {
                ViewUtils.h(view, 1.0f);
                ViewUtils.a(view);
                transition.O(this);
            }
        });
        return ofFloat;
    }

    private static float j0(TransitionValues transitionValues, float f2) {
        Float f3;
        if (transitionValues == null || (f3 = (Float) transitionValues.f11787a.get("android:fade:transitionAlpha")) == null) {
            return f2;
        }
        return f3.floatValue();
    }

    public Animator d0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f2 = 0.0f;
        float j02 = j0(transitionValues, 0.0f);
        if (j02 != 1.0f) {
            f2 = j02;
        }
        return i0(view, f2, 1.0f);
    }

    public Animator f0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.f(view);
        return i0(view, j0(transitionValues, 1.0f), 0.0f);
    }

    public void i(TransitionValues transitionValues) {
        super.i(transitionValues);
        transitionValues.f11787a.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.d(transitionValues.f11788b)));
    }

    public Fade() {
    }
}
