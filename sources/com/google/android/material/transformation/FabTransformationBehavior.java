package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f30199c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f30200d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f30201e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f30202f = new int[2];

    protected static class FabTransformationSpec {

        /* renamed from: a  reason: collision with root package name */
        public MotionSpec f30214a;

        /* renamed from: b  reason: collision with root package name */
        public Positioning f30215b;

        protected FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
    }

    private ViewGroup J(View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (findViewById != null) {
            return b0(findViewById);
        }
        if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
            return b0(((ViewGroup) view).getChildAt(0));
        }
        return b0(view);
    }

    private void K(View view, FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, MotionTiming motionTiming2, float f2, float f3, float f4, float f5, RectF rectF) {
        float P = P(fabTransformationSpec, motionTiming, f2, f4);
        float P2 = P(fabTransformationSpec, motionTiming2, f3, f5);
        Rect rect = this.f30199c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f30200d;
        rectF2.set(rect);
        RectF rectF3 = this.f30201e;
        Q(view, rectF3);
        rectF3.offset(P, P2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float L(View view, View view2, Positioning positioning) {
        RectF rectF = this.f30200d;
        RectF rectF2 = this.f30201e;
        Q(view, rectF);
        Q(view2, rectF2);
        rectF2.offset(-N(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float M(View view, View view2, Positioning positioning) {
        RectF rectF = this.f30200d;
        RectF rectF2 = this.f30201e;
        Q(view, rectF);
        Q(view2, rectF2);
        rectF2.offset(0.0f, -O(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float N(View view, View view2, Positioning positioning) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f30200d;
        RectF rectF2 = this.f30201e;
        Q(view, rectF);
        Q(view2, rectF2);
        int i2 = positioning.f29414a & 7;
        if (i2 == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i2 == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i2 != 5) {
            f2 = 0.0f;
            return f2 + positioning.f29415b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + positioning.f29415b;
    }

    private float O(View view, View view2, Positioning positioning) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f30200d;
        RectF rectF2 = this.f30201e;
        Q(view, rectF);
        Q(view2, rectF2);
        int i2 = positioning.f29414a & 112;
        if (i2 == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i2 == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i2 != 80) {
            f2 = 0.0f;
            return f2 + positioning.f29416c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + positioning.f29416c;
    }

    private float P(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f2, float f3) {
        long c2 = motionTiming.c();
        long d2 = motionTiming.d();
        MotionTiming e2 = fabTransformationSpec.f30214a.e("expansion");
        return AnimationUtils.a(f2, f3, motionTiming.e().getInterpolation(((float) (((e2.c() + e2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void Q(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f30202f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void R(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup J;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof CircularRevealWidget) || CircularRevealHelper.f29736a != 0) && (J = J(view2)) != null) {
                if (z2) {
                    if (!z3) {
                        ChildrenAlphaProperty.f29401a.set(J, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(J, ChildrenAlphaProperty.f29401a, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(J, ChildrenAlphaProperty.f29401a, new float[]{0.0f});
                }
                fabTransformationSpec.f30214a.e("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void S(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int Z = Z(view);
            int i2 = 16777215 & Z;
            if (z2) {
                if (!z3) {
                    circularRevealWidget.setCircularRevealScrimColor(Z);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.f29740a, new int[]{i2});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.f29740a, new int[]{Z});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.b());
            fabTransformationSpec.f30214a.e(ViewProps.COLOR).a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    @TargetApi(21)
    private void T(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float x2 = ViewCompat.x(view2) - ViewCompat.x(view);
        if (z2) {
            if (!z3) {
                view2.setTranslationZ(-x2);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-x2});
        }
        fabTransformationSpec.f30214a.e(ViewProps.ELEVATION).a(objectAnimator);
        list.add(objectAnimator);
    }

    private void U(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        if (view4 instanceof CircularRevealWidget) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view4;
            float L = L(view3, view4, fabTransformationSpec2.f30215b);
            float M = M(view3, view4, fabTransformationSpec2.f30215b);
            ((FloatingActionButton) view3).h(this.f30199c);
            float width = ((float) this.f30199c.width()) / 2.0f;
            MotionTiming e2 = fabTransformationSpec2.f30214a.e("expansion");
            if (z2) {
                if (!z3) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(L, M, width));
                }
                if (z3) {
                    width = circularRevealWidget.getRevealInfo().f29743c;
                }
                animator = CircularRevealCompat.a(circularRevealWidget, L, M, MathUtils.b(L, M, 0.0f, 0.0f, f2, f3));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                        revealInfo.f29743c = Float.MAX_VALUE;
                        circularRevealWidget.setRevealInfo(revealInfo);
                    }
                });
                X(view2, e2.c(), (int) L, (int) M, width, list);
            } else {
                float f4 = circularRevealWidget.getRevealInfo().f29743c;
                Animator a2 = CircularRevealCompat.a(circularRevealWidget, L, M, width);
                int i2 = (int) L;
                int i3 = (int) M;
                View view5 = view2;
                X(view5, e2.c(), i2, i3, f4, list);
                long c2 = e2.c();
                long d2 = e2.d();
                long f5 = fabTransformationSpec2.f30214a.f();
                W(view5, c2, d2, f5, i2, i3, width, list);
                animator = a2;
            }
            e2.a(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.b(circularRevealWidget));
        }
    }

    private void V(View view, final View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z2) {
                    if (!z3) {
                        drawable.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f29402b, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f29402b, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpec.f30214a.e("iconFade").a(objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable((Drawable) null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
    }

    private void W(View view, long j2, long j3, long j4, int i2, int i3, float f2, List<Animator> list) {
        long j5 = j2 + j3;
        if (j5 < j4) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(j5);
            createCircularReveal.setDuration(j4 - j5);
            list.add(createCircularReveal);
        }
    }

    private void X(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
        if (j2 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j2);
            list.add(createCircularReveal);
        }
    }

    private void Y(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        int i2;
        View view3 = view;
        View view4 = view2;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        List<Animator> list3 = list;
        float N = N(view3, view4, fabTransformationSpec2.f30215b);
        float O = O(view3, view4, fabTransformationSpec2.f30215b);
        if (N == 0.0f || O == 0.0f) {
            motionTiming2 = fabTransformationSpec2.f30214a.e("translationXLinear");
            motionTiming = fabTransformationSpec2.f30214a.e("translationYLinear");
        } else if ((!z2 || O >= 0.0f) && (z2 || i2 <= 0)) {
            motionTiming2 = fabTransformationSpec2.f30214a.e("translationXCurveDownwards");
            motionTiming = fabTransformationSpec2.f30214a.e("translationYCurveDownwards");
        } else {
            motionTiming2 = fabTransformationSpec2.f30214a.e("translationXCurveUpwards");
            motionTiming = fabTransformationSpec2.f30214a.e("translationYCurveUpwards");
        }
        MotionTiming motionTiming3 = motionTiming2;
        MotionTiming motionTiming4 = motionTiming;
        if (z2) {
            if (!z3) {
                view4.setTranslationX(-N);
                view4.setTranslationY(-O);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            K(view2, fabTransformationSpec, motionTiming3, motionTiming4, -N, -O, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-N});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-O});
        }
        motionTiming3.a(objectAnimator2);
        motionTiming4.a(objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private int Z(View view) {
        ColorStateList t2 = ViewCompat.t(view);
        if (t2 != null) {
            return t2.getColorForState(view.getDrawableState(), t2.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup b0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public AnimatorSet I(View view, View view2, boolean z2, boolean z3) {
        final boolean z4 = z2;
        FabTransformationSpec a02 = a0(view2.getContext(), z4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        T(view, view2, z2, z3, a02, arrayList, arrayList2);
        RectF rectF = this.f30200d;
        View view3 = view;
        View view4 = view2;
        boolean z5 = z2;
        boolean z6 = z3;
        FabTransformationSpec fabTransformationSpec = a02;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        Y(view3, view4, z5, z6, fabTransformationSpec, arrayList3, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        V(view3, view4, z5, z6, fabTransformationSpec, arrayList3, arrayList4);
        U(view3, view4, z5, z6, fabTransformationSpec, width, height, arrayList, arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        S(view3, view4, z5, z6, fabTransformationSpec, arrayList5, arrayList6);
        R(view3, view4, z5, z6, fabTransformationSpec, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        final View view5 = view;
        final View view6 = view2;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z4) {
                    view6.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z4) {
                    view6.setVisibility(0);
                    view5.setAlpha(0.0f);
                    view5.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i2));
        }
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    public abstract FabTransformationSpec a0(Context context, boolean z2);

    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    public void g(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.f2246h == 0) {
            layoutParams.f2246h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
