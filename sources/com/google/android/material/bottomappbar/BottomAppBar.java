package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePathModel;
import java.util.ArrayList;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private final int V;
    /* access modifiers changed from: private */
    public final MaterialShapeDrawable W;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public final BottomAppBarTopEdgeTreatment f29517a0;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public Animator f29518b0;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public Animator f29519c0;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public Animator f29520d0;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public int f29521e0;

    /* renamed from: f0  reason: collision with root package name */
    private boolean f29522f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public boolean f29523g0 = true;

    /* renamed from: h0  reason: collision with root package name */
    AnimatorListenerAdapter f29524h0 = new AnimatorListenerAdapter() {
        public void onAnimationStart(Animator animator) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.t0(bottomAppBar.f29523g0);
            BottomAppBar bottomAppBar2 = BottomAppBar.this;
            bottomAppBar2.u0(bottomAppBar2.f29521e0, BottomAppBar.this.f29523g0);
        }
    };

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        int f29537d;

        /* renamed from: e  reason: collision with root package name */
        boolean f29538e;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f29537d);
            parcel.writeInt(this.f29538e ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f29537d = parcel.readInt();
            this.f29538e = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.f29387w, i2, R$style.Widget_MaterialComponents_BottomAppBar, new int[0]);
        ColorStateList a2 = MaterialResources.a(context, h2, R$styleable.f29389x);
        this.f29521e0 = h2.getInt(R$styleable.f29391y, 0);
        this.f29522f0 = h2.getBoolean(R$styleable.C, false);
        h2.recycle();
        this.V = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = new BottomAppBarTopEdgeTreatment((float) h2.getDimensionPixelOffset(R$styleable.f29393z, 0), (float) h2.getDimensionPixelOffset(R$styleable.A, 0), (float) h2.getDimensionPixelOffset(R$styleable.B, 0));
        this.f29517a0 = bottomAppBarTopEdgeTreatment;
        ShapePathModel shapePathModel = new ShapePathModel();
        shapePathModel.i(bottomAppBarTopEdgeTreatment);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapePathModel);
        this.W = materialShapeDrawable;
        materialShapeDrawable.q(true);
        materialShapeDrawable.p(Paint.Style.FILL);
        DrawableCompat.o(materialShapeDrawable, a2);
        ViewCompat.v0(this, materialShapeDrawable);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return (float) p0(this.f29521e0);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationY() {
        return q0(this.f29523g0);
    }

    /* access modifiers changed from: private */
    public void h0(FloatingActionButton floatingActionButton) {
        w0(floatingActionButton);
        floatingActionButton.e(this.f29524h0);
        floatingActionButton.f(this.f29524h0);
    }

    private void i0() {
        Animator animator = this.f29518b0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f29520d0;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f29519c0;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    private void j0(boolean z2, List<Animator> list) {
        float f2;
        if (z2) {
            this.f29517a0.k(getFabTranslationX());
        }
        float[] fArr = new float[2];
        fArr[0] = this.W.h();
        if (z2) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        fArr[1] = f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BottomAppBar.this.W.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(300);
        list.add(ofFloat);
    }

    private void k0(int i2, List<Animator> list) {
        if (this.f29523g0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f29517a0.f(), (float) p0(i2)});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.f29517a0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    BottomAppBar.this.W.invalidateSelf();
                }
            });
            ofFloat.setDuration(300);
            list.add(ofFloat);
        }
    }

    private void l0(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o0(), "translationX", new float[]{(float) p0(i2)});
        ofFloat.setDuration(300);
        list.add(ofFloat);
    }

    private void m0(boolean z2, List<Animator> list) {
        FloatingActionButton o02 = o0();
        if (o02 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o02, "translationY", new float[]{q0(z2)});
            ofFloat.setDuration(300);
            list.add(ofFloat);
        }
    }

    private void n0(final int i2, final boolean z2, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            if ((this.f29523g0 || (z2 && s0())) && (this.f29521e0 == 1 || i2 == 1)) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    public boolean f29528a;

                    public void onAnimationCancel(Animator animator) {
                        this.f29528a = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!this.f29528a) {
                            BottomAppBar.this.y0(actionMenuView, i2, z2);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton o0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View next : ((CoordinatorLayout) getParent()).s(this)) {
            if (next instanceof FloatingActionButton) {
                return (FloatingActionButton) next;
            }
        }
        return null;
    }

    private int p0(int i2) {
        boolean z2;
        int i3 = 1;
        if (ViewCompat.D(this) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i2 != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.V;
        if (z2) {
            i3 = -1;
        }
        return measuredWidth * i3;
    }

    private float q0(boolean z2) {
        FloatingActionButton o02 = o0();
        if (o02 == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        o02.h(rect);
        float height = (float) rect.height();
        if (height == 0.0f) {
            height = (float) o02.getMeasuredHeight();
        }
        float height2 = (float) (o02.getHeight() - rect.height());
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + ((float) (o02.getHeight() - rect.bottom));
        float paddingBottom = height2 - ((float) o02.getPaddingBottom());
        float f2 = (float) (-getMeasuredHeight());
        if (!z2) {
            height3 = paddingBottom;
        }
        return f2 + height3;
    }

    /* access modifiers changed from: private */
    public boolean r0() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.f29518b0;
        if ((animator3 == null || !animator3.isRunning()) && (((animator = this.f29520d0) == null || !animator.isRunning()) && ((animator2 = this.f29519c0) == null || !animator2.isRunning()))) {
            return false;
        }
        return true;
    }

    private boolean s0() {
        FloatingActionButton o02 = o0();
        if (o02 == null || !o02.l()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void t0(boolean z2) {
        boolean z3;
        if (ViewCompat.V(this)) {
            Animator animator = this.f29518b0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!z2 || !s0()) {
                z3 = false;
            } else {
                z3 = true;
            }
            j0(z3, arrayList);
            m0(z2, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f29518b0 = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.f29518b0 = null;
                }
            });
            this.f29518b0.start();
        }
    }

    /* access modifiers changed from: private */
    public void u0(int i2, boolean z2) {
        if (ViewCompat.V(this)) {
            Animator animator = this.f29520d0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!s0()) {
                i2 = 0;
                z2 = false;
            }
            n0(i2, z2, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f29520d0 = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.f29520d0 = null;
                }
            });
            this.f29520d0.start();
        }
    }

    private void v0(int i2) {
        if (this.f29521e0 != i2 && ViewCompat.V(this)) {
            Animator animator = this.f29519c0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            k0(i2, arrayList);
            l0(i2, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f29519c0 = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.f29519c0 = null;
                }
            });
            this.f29519c0.start();
        }
    }

    private void w0(FloatingActionButton floatingActionButton) {
        floatingActionButton.o(this.f29524h0);
        floatingActionButton.p(this.f29524h0);
    }

    /* access modifiers changed from: private */
    public void x0() {
        float f2;
        this.f29517a0.k(getFabTranslationX());
        FloatingActionButton o02 = o0();
        MaterialShapeDrawable materialShapeDrawable = this.W;
        if (!this.f29523g0 || !s0()) {
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        materialShapeDrawable.o(f2);
        if (o02 != null) {
            o02.setTranslationY(getFabTranslationY());
            o02.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!s0()) {
                y0(actionMenuView, 0, false);
            } else {
                y0(actionMenuView, this.f29521e0, this.f29523g0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void y0(ActionMenuView actionMenuView, int i2, boolean z2) {
        boolean z3;
        int i3;
        float f2;
        boolean z4;
        int i4;
        if (ViewCompat.D(this) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (!(childAt.getLayoutParams() instanceof Toolbar.LayoutParams) || (((Toolbar.LayoutParams) childAt.getLayoutParams()).f306a & 8388615) != 8388611) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                if (z3) {
                    i4 = childAt.getLeft();
                } else {
                    i4 = childAt.getRight();
                }
                i5 = Math.max(i5, i4);
            }
        }
        if (z3) {
            i3 = actionMenuView.getRight();
        } else {
            i3 = actionMenuView.getLeft();
        }
        int i7 = i5 - i3;
        if (i2 != 1 || !z2) {
            f2 = 0.0f;
        } else {
            f2 = (float) i7;
        }
        actionMenuView.setTranslationX(f2);
    }

    public ColorStateList getBackgroundTint() {
        return this.W.k();
    }

    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        return this.f29517a0.b();
    }

    public int getFabAlignmentMode() {
        return this.f29521e0;
    }

    public float getFabCradleMargin() {
        return this.f29517a0.c();
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.f29517a0.d();
    }

    public boolean getHideOnScroll() {
        return this.f29522f0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        i0();
        x0();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        this.f29521e0 = savedState.f29537d;
        this.f29523g0 = savedState.f29538e;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f29537d = this.f29521e0;
        savedState.f29538e = this.f29523g0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.o(this.W, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            this.f29517a0.g(f2);
            this.W.invalidateSelf();
        }
    }

    public void setFabAlignmentMode(int i2) {
        v0(i2);
        u0(i2, this.f29523g0);
        this.f29521e0 = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            this.f29517a0.h(f2);
            this.W.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            this.f29517a0.i(f2);
            this.W.invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void setFabDiameter(int i2) {
        float f2 = (float) i2;
        if (f2 != this.f29517a0.e()) {
            this.f29517a0.j(f2);
            this.W.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f29522f0 = z2;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f29536d = new Rect();

        public Behavior() {
        }

        private boolean L(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).f2242d = 17;
            bottomAppBar.h0(floatingActionButton);
            return true;
        }

        /* renamed from: H */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            FloatingActionButton V = bottomAppBar.o0();
            if (V != null) {
                L(V, bottomAppBar);
                V.i(this.f29536d);
                bottomAppBar.setFabDiameter(this.f29536d.height());
            }
            if (!bottomAppBar.r0()) {
                bottomAppBar.x0();
            }
            coordinatorLayout.I(bottomAppBar, i2);
            return super.l(coordinatorLayout, bottomAppBar, i2);
        }

        /* renamed from: I */
        public boolean z(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            if (!bottomAppBar.getHideOnScroll() || !super.z(coordinatorLayout, bottomAppBar, view, view2, i2, i3)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: J */
        public void F(BottomAppBar bottomAppBar) {
            super.F(bottomAppBar);
            FloatingActionButton V = bottomAppBar.o0();
            if (V != null) {
                V.h(this.f29536d);
                V.clearAnimation();
                V.animate().translationY(((float) (-V.getPaddingBottom())) + ((float) (V.getMeasuredHeight() - this.f29536d.height()))).setInterpolator(AnimationUtils.f29397c).setDuration(175);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: K */
        public void G(BottomAppBar bottomAppBar) {
            super.G(bottomAppBar);
            FloatingActionButton V = bottomAppBar.o0();
            if (V != null) {
                V.clearAnimation();
                V.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(AnimationUtils.f29398d).setDuration(225);
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }
}
