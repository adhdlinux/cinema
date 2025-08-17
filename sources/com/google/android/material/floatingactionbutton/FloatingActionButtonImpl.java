package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.R$animator;
import com.google.android.material.R$color;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;

class FloatingActionButtonImpl {
    static final TimeInterpolator B = AnimationUtils.f29397c;
    static final int[] C = {16842919, 16842910};
    static final int[] D = {16843623, 16842908, 16842910};
    static final int[] E = {16842908, 16842910};
    static final int[] F = {16843623, 16842910};
    static final int[] G = {16842910};
    static final int[] H = new int[0];
    private ViewTreeObserver.OnPreDrawListener A;

    /* renamed from: a  reason: collision with root package name */
    int f29769a = 0;

    /* renamed from: b  reason: collision with root package name */
    Animator f29770b;

    /* renamed from: c  reason: collision with root package name */
    MotionSpec f29771c;

    /* renamed from: d  reason: collision with root package name */
    MotionSpec f29772d;

    /* renamed from: e  reason: collision with root package name */
    private MotionSpec f29773e;

    /* renamed from: f  reason: collision with root package name */
    private MotionSpec f29774f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListAnimator f29775g;

    /* renamed from: h  reason: collision with root package name */
    ShadowDrawableWrapper f29776h;

    /* renamed from: i  reason: collision with root package name */
    private float f29777i;

    /* renamed from: j  reason: collision with root package name */
    Drawable f29778j;

    /* renamed from: k  reason: collision with root package name */
    Drawable f29779k;

    /* renamed from: l  reason: collision with root package name */
    CircularBorderDrawable f29780l;

    /* renamed from: m  reason: collision with root package name */
    Drawable f29781m;

    /* renamed from: n  reason: collision with root package name */
    float f29782n;

    /* renamed from: o  reason: collision with root package name */
    float f29783o;

    /* renamed from: p  reason: collision with root package name */
    float f29784p;

    /* renamed from: q  reason: collision with root package name */
    int f29785q;

    /* renamed from: r  reason: collision with root package name */
    float f29786r = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f29787s;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f29788t;

    /* renamed from: u  reason: collision with root package name */
    final VisibilityAwareImageButton f29789u;

    /* renamed from: v  reason: collision with root package name */
    final ShadowViewDelegate f29790v;

    /* renamed from: w  reason: collision with root package name */
    private final Rect f29791w = new Rect();

    /* renamed from: x  reason: collision with root package name */
    private final RectF f29792x = new RectF();

    /* renamed from: y  reason: collision with root package name */
    private final RectF f29793y = new RectF();

    /* renamed from: z  reason: collision with root package name */
    private final Matrix f29794z = new Matrix();

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f29782n + floatingActionButtonImpl.f29783o;
        }
    }

    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f29782n + floatingActionButtonImpl.f29784p;
        }
    }

    interface InternalVisibilityChangedListener {
        void a();

        void b();
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return FloatingActionButtonImpl.this.f29782n;
        }
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f29807a;

        /* renamed from: b  reason: collision with root package name */
        private float f29808b;

        /* renamed from: c  reason: collision with root package name */
        private float f29809c;

        private ShadowAnimatorImpl() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.f29776h.e(this.f29809c);
            this.f29807a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f29807a) {
                this.f29808b = FloatingActionButtonImpl.this.f29776h.c();
                this.f29809c = a();
                this.f29807a = true;
            }
            ShadowDrawableWrapper shadowDrawableWrapper = FloatingActionButtonImpl.this.f29776h;
            float f2 = this.f29808b;
            shadowDrawableWrapper.e(f2 + ((this.f29809c - f2) * valueAnimator.getAnimatedFraction()));
        }
    }

    FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.f29789u = visibilityAwareImageButton;
        this.f29790v = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f29775g = stateListAnimator;
        stateListAnimator.a(C, f(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.a(D, f(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(E, f(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(F, f(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(G, f(new ResetElevationAnimation()));
        stateListAnimator.a(H, f(new DisabledElevationAnimation()));
        this.f29777i = visibilityAwareImageButton.getRotation();
    }

    private boolean S() {
        return ViewCompat.V(this.f29789u) && !this.f29789u.isInEditMode();
    }

    private void U() {
        ShadowDrawableWrapper shadowDrawableWrapper = this.f29776h;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.d(-this.f29777i);
        }
        CircularBorderDrawable circularBorderDrawable = this.f29780l;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.e(-this.f29777i);
        }
    }

    private void c(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f29789u.getDrawable();
        if (drawable != null && this.f29785q != 0) {
            RectF rectF = this.f29792x;
            RectF rectF2 = this.f29793y;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.f29785q;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.f29785q;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    private AnimatorSet d(MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29789u, View.ALPHA, new float[]{f2});
        motionSpec.e(ViewProps.OPACITY).a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29789u, View.SCALE_X, new float[]{f3});
        motionSpec.e("scale").a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f29789u, View.SCALE_Y, new float[]{f3});
        motionSpec.e("scale").a(ofFloat3);
        arrayList.add(ofFloat3);
        c(f4, this.f29794z);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f29789u, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix[]{new Matrix(this.f29794z)});
        motionSpec.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator f(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(B);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private void h() {
        if (this.A == null) {
            this.A = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.D();
                    return true;
                }
            };
        }
    }

    private MotionSpec j() {
        if (this.f29774f == null) {
            this.f29774f = MotionSpec.c(this.f29789u.getContext(), R$animator.design_fab_hide_motion_spec);
        }
        return this.f29774f;
    }

    private MotionSpec k() {
        if (this.f29773e == null) {
            this.f29773e = MotionSpec.c(this.f29789u.getContext(), R$animator.design_fab_show_motion_spec);
        }
        return this.f29773e;
    }

    /* access modifiers changed from: package-private */
    public void A(int[] iArr) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void B(float f2, float f3, float f4) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void C(Rect rect) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        float rotation = this.f29789u.getRotation();
        if (this.f29777i != rotation) {
            this.f29777i = rotation;
            U();
        }
    }

    public void E(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f29788t;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f29787s;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void I(ColorStateList colorStateList) {
        Drawable drawable = this.f29778j;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        }
        CircularBorderDrawable circularBorderDrawable = this.f29780l;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.b(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(PorterDuff.Mode mode) {
        Drawable drawable = this.f29778j;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(float f2) {
        if (this.f29782n != f2) {
            this.f29782n = f2;
            B(f2, this.f29783o, this.f29784p);
        }
    }

    /* access modifiers changed from: package-private */
    public final void L(MotionSpec motionSpec) {
        this.f29772d = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public final void M(float f2) {
        if (this.f29783o != f2) {
            this.f29783o = f2;
            B(this.f29782n, f2, this.f29784p);
        }
    }

    /* access modifiers changed from: package-private */
    public final void N(float f2) {
        this.f29786r = f2;
        Matrix matrix = this.f29794z;
        c(f2, matrix);
        this.f29789u.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void O(int i2) {
        if (this.f29785q != i2) {
            this.f29785q = i2;
            V();
        }
    }

    /* access modifiers changed from: package-private */
    public final void P(float f2) {
        if (this.f29784p != f2) {
            this.f29784p = f2;
            B(this.f29782n, this.f29783o, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(ColorStateList colorStateList) {
        Drawable drawable = this.f29779k;
        if (drawable != null) {
            DrawableCompat.o(drawable, RippleUtils.a(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public final void R(MotionSpec motionSpec) {
        this.f29771c = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public void T(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z2) {
        if (!t()) {
            Animator animator = this.f29770b;
            if (animator != null) {
                animator.cancel();
            }
            if (S()) {
                if (this.f29789u.getVisibility() != 0) {
                    this.f29789u.setAlpha(0.0f);
                    this.f29789u.setScaleY(0.0f);
                    this.f29789u.setScaleX(0.0f);
                    N(0.0f);
                }
                MotionSpec motionSpec = this.f29771c;
                if (motionSpec == null) {
                    motionSpec = k();
                }
                AnimatorSet d2 = d(motionSpec, 1.0f, 1.0f, 1.0f);
                d2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.f29769a = 0;
                        floatingActionButtonImpl.f29770b = null;
                        InternalVisibilityChangedListener internalVisibilityChangedListener = internalVisibilityChangedListener;
                        if (internalVisibilityChangedListener != null) {
                            internalVisibilityChangedListener.a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.f29789u.b(0, z2);
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.f29769a = 2;
                        floatingActionButtonImpl.f29770b = animator;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.f29787s;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        d2.addListener(it2.next());
                    }
                }
                d2.start();
                return;
            }
            this.f29789u.b(0, z2);
            this.f29789u.setAlpha(1.0f);
            this.f29789u.setScaleY(1.0f);
            this.f29789u.setScaleX(1.0f);
            N(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void V() {
        N(this.f29786r);
    }

    /* access modifiers changed from: package-private */
    public final void W() {
        Rect rect = this.f29791w;
        o(rect);
        C(rect);
        this.f29790v.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.f29788t == null) {
            this.f29788t = new ArrayList<>();
        }
        this.f29788t.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.f29787s == null) {
            this.f29787s = new ArrayList<>();
        }
        this.f29787s.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public CircularBorderDrawable e(int i2, ColorStateList colorStateList) {
        Context context = this.f29789u.getContext();
        CircularBorderDrawable v2 = v();
        v2.d(ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color));
        v2.c((float) i2);
        v2.b(colorStateList);
        return v2;
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable g() {
        GradientDrawable w2 = w();
        w2.setShape(1);
        w2.setColor(-1);
        return w2;
    }

    /* access modifiers changed from: package-private */
    public final Drawable i() {
        return this.f29781m;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final MotionSpec m() {
        return this.f29772d;
    }

    /* access modifiers changed from: package-private */
    public float n() {
        return this.f29783o;
    }

    /* access modifiers changed from: package-private */
    public void o(Rect rect) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public float p() {
        return this.f29784p;
    }

    /* access modifiers changed from: package-private */
    public final MotionSpec q() {
        return this.f29771c;
    }

    /* access modifiers changed from: package-private */
    public void r(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z2) {
        int i2;
        if (!s()) {
            Animator animator = this.f29770b;
            if (animator != null) {
                animator.cancel();
            }
            if (S()) {
                MotionSpec motionSpec = this.f29772d;
                if (motionSpec == null) {
                    motionSpec = j();
                }
                AnimatorSet d2 = d(motionSpec, 0.0f, 0.0f, 0.0f);
                d2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    private boolean f29795a;

                    public void onAnimationCancel(Animator animator) {
                        this.f29795a = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        int i2;
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.f29769a = 0;
                        floatingActionButtonImpl.f29770b = null;
                        if (!this.f29795a) {
                            VisibilityAwareImageButton visibilityAwareImageButton = floatingActionButtonImpl.f29789u;
                            boolean z2 = z2;
                            if (z2) {
                                i2 = 8;
                            } else {
                                i2 = 4;
                            }
                            visibilityAwareImageButton.b(i2, z2);
                            InternalVisibilityChangedListener internalVisibilityChangedListener = internalVisibilityChangedListener;
                            if (internalVisibilityChangedListener != null) {
                                internalVisibilityChangedListener.b();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.f29789u.b(0, z2);
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.f29769a = 1;
                        floatingActionButtonImpl.f29770b = animator;
                        this.f29795a = false;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.f29788t;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        d2.addListener(it2.next());
                    }
                }
                d2.start();
                return;
            }
            VisibilityAwareImageButton visibilityAwareImageButton = this.f29789u;
            if (z2) {
                i2 = 8;
            } else {
                i2 = 4;
            }
            visibilityAwareImageButton.b(i2, z2);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        if (this.f29789u.getVisibility() == 0) {
            if (this.f29769a == 1) {
                return true;
            }
            return false;
        } else if (this.f29769a != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        if (this.f29789u.getVisibility() != 0) {
            if (this.f29769a == 2) {
                return true;
            }
            return false;
        } else if (this.f29769a != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public CircularBorderDrawable v() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable w() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        if (G()) {
            h();
            this.f29789u.getViewTreeObserver().addOnPreDrawListener(this.A);
        }
    }

    /* access modifiers changed from: package-private */
    public void y() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.A != null) {
            this.f29789u.getViewTreeObserver().removeOnPreDrawListener(this.A);
            this.A = null;
        }
    }
}
