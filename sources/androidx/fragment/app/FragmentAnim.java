package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.fragment.app.FragmentTransition;

class FragmentAnim {
    private FragmentAnim() {
    }

    static void a(final Fragment fragment, AnimationOrAnimator animationOrAnimator, final FragmentTransition.Callback callback) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.c(new CancellationSignal.OnCancelListener() {
            public void onCancel() {
                if (Fragment.this.getAnimatingAway() != null) {
                    View animatingAway = Fragment.this.getAnimatingAway();
                    Fragment.this.setAnimatingAway((View) null);
                    animatingAway.clearAnimation();
                }
                Fragment.this.setAnimator((Animator) null);
            }
        });
        callback.b(fragment, cancellationSignal);
        if (animationOrAnimator.f3386a != null) {
            EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animationOrAnimator.f3386a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway((View) null);
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                callback.a(fragment, cancellationSignal);
                            }
                        }
                    });
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            fragment.mView.startAnimation(endViewTransitionAnimation);
            return;
        }
        Animator animator = animationOrAnimator.f3387b;
        fragment.setAnimator(animator);
        final Fragment fragment2 = fragment;
        final FragmentTransition.Callback callback2 = callback;
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = fragment2.getAnimator();
                fragment2.setAnimator((Animator) null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    callback2.a(fragment2, cancellationSignal);
                }
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z2, boolean z3) {
        if (z3) {
            if (z2) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z2) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    static AnimationOrAnimator c(Context context, Fragment fragment, boolean z2, boolean z3) {
        int nextTransition = fragment.getNextTransition();
        int b2 = b(fragment, z2, z3);
        boolean z4 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i2 = R$id.f3251c;
            if (viewGroup.getTag(i2) != null) {
                fragment.mContainer.setTag(i2, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, b2);
        if (onCreateAnimation != null) {
            return new AnimationOrAnimator(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, b2);
        if (onCreateAnimator != null) {
            return new AnimationOrAnimator(onCreateAnimator);
        }
        if (b2 == 0 && nextTransition != 0) {
            b2 = d(nextTransition, z2);
        }
        if (b2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b2);
                    if (loadAnimation != null) {
                        return new AnimationOrAnimator(loadAnimation);
                    }
                    z4 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z4) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, b2);
                    if (loadAnimator != null) {
                        return new AnimationOrAnimator(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b2);
                        if (loadAnimation2 != null) {
                            return new AnimationOrAnimator(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        return null;
    }

    private static int d(int i2, boolean z2) {
        if (i2 != 4097) {
            if (i2 != 4099) {
                if (i2 != 8194) {
                    return -1;
                }
                if (z2) {
                    return R$animator.f3243a;
                }
                return R$animator.f3244b;
            } else if (z2) {
                return R$animator.f3245c;
            } else {
                return R$animator.f3246d;
            }
        } else if (z2) {
            return R$animator.f3247e;
        } else {
            return R$animator.f3248f;
        }
    }

    static class AnimationOrAnimator {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f3386a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f3387b;

        AnimationOrAnimator(Animation animation) {
            this.f3386a = animation;
            this.f3387b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.f3386a = null;
            this.f3387b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final ViewGroup f3388b;

        /* renamed from: c  reason: collision with root package name */
        private final View f3389c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3390d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3391e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3392f = true;

        EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3388b = viewGroup;
            this.f3389c = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation) {
            this.f3392f = true;
            if (this.f3390d) {
                return !this.f3391e;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f3390d = true;
                OneShotPreDrawListener.a(this.f3388b, this);
            }
            return true;
        }

        public void run() {
            if (this.f3390d || !this.f3392f) {
                this.f3388b.endViewTransition(this.f3389c);
                this.f3391e = true;
                return;
            }
            this.f3392f = false;
            this.f3388b.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f3392f = true;
            if (this.f3390d) {
                return !this.f3391e;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f3390d = true;
                OneShotPreDrawListener.a(this.f3388b, this);
            }
            return true;
        }
    }
}
