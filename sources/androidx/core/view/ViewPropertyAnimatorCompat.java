package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f2802a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f2803b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f2804c = null;

    /* renamed from: d  reason: collision with root package name */
    int f2805d = -1;

    static class Api19Impl {
        private Api19Impl() {
        }

        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f2802a = new WeakReference<>(view);
    }

    private void i(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.a(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.c(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public ViewPropertyAnimatorCompat b(float f2) {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void c() {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f2802a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat f(long j2) {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat g(Interpolator interpolator) {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat h(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.f2802a.get();
        if (view != null) {
            i(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat j(long j2) {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat k(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        b2 b2Var;
        View view = this.f2802a.get();
        if (view != null) {
            if (viewPropertyAnimatorUpdateListener != null) {
                b2Var = new b2(viewPropertyAnimatorUpdateListener, view);
            } else {
                b2Var = null;
            }
            Api19Impl.a(view.animate(), b2Var);
        }
        return this;
    }

    public void l() {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat m(float f2) {
        View view = this.f2802a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
