package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.CircularBorderDrawableLollipop;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    private InsetDrawable I;

    static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        AlwaysStatefulGradientDrawable() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    private Animator X(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f29789u, ViewProps.ELEVATION, new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f29789u, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(FloatingActionButtonImpl.B);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void A(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.f29789u.isEnabled()) {
            this.f29789u.setElevation(this.f29782n);
            if (this.f29789u.isPressed()) {
                this.f29789u.setTranslationZ(this.f29784p);
            } else if (this.f29789u.isFocused() || this.f29789u.isHovered()) {
                this.f29789u.setTranslationZ(this.f29783o);
            } else {
                this.f29789u.setTranslationZ(0.0f);
            }
        } else {
            this.f29789u.setElevation(0.0f);
            this.f29789u.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void B(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.f29789u.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.C, X(f2, f4));
            stateListAnimator.addState(FloatingActionButtonImpl.D, X(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.E, X(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.F, X(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f29789u, ViewProps.ELEVATION, new float[]{f2}).setDuration(0));
            if (i2 >= 22 && i2 <= 24) {
                VisibilityAwareImageButton visibilityAwareImageButton = this.f29789u;
                arrayList.add(ObjectAnimator.ofFloat(visibilityAwareImageButton, View.TRANSLATION_Z, new float[]{visibilityAwareImageButton.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f29789u, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.B);
            stateListAnimator.addState(FloatingActionButtonImpl.G, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.H, X(0.0f, 0.0f));
            this.f29789u.setStateListAnimator(stateListAnimator);
        }
        if (this.f29790v.c()) {
            W();
        }
    }

    /* access modifiers changed from: package-private */
    public void C(Rect rect) {
        if (this.f29790v.c()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.f29779k, rect.left, rect.top, rect.right, rect.bottom);
            this.I = insetDrawable;
            this.f29790v.b(insetDrawable);
            return;
        }
        this.f29790v.b(this.f29779k);
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        Drawable r2 = DrawableCompat.r(g());
        this.f29778j = r2;
        DrawableCompat.o(r2, colorStateList);
        if (mode != null) {
            DrawableCompat.p(this.f29778j, mode);
        }
        if (i2 > 0) {
            this.f29780l = e(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.f29780l, this.f29778j});
        } else {
            this.f29780l = null;
            drawable = this.f29778j;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.a(colorStateList2), drawable, (Drawable) null);
        this.f29779k = rippleDrawable;
        this.f29781m = rippleDrawable;
        this.f29790v.b(rippleDrawable);
    }

    /* access modifiers changed from: package-private */
    public void Q(ColorStateList colorStateList) {
        Drawable drawable = this.f29779k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.a(colorStateList));
        } else {
            super.Q(colorStateList);
        }
    }

    public float l() {
        return this.f29789u.getElevation();
    }

    /* access modifiers changed from: package-private */
    public void o(Rect rect) {
        if (this.f29790v.c()) {
            float radius = this.f29790v.getRadius();
            float l2 = l() + this.f29784p;
            int ceil = (int) Math.ceil((double) ShadowDrawableWrapper.a(l2, radius, false));
            int ceil2 = (int) Math.ceil((double) ShadowDrawableWrapper.b(l2, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    /* access modifiers changed from: package-private */
    public void u() {
    }

    /* access modifiers changed from: package-private */
    public CircularBorderDrawable v() {
        return new CircularBorderDrawableLollipop();
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable w() {
        return new AlwaysStatefulGradientDrawable();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        W();
    }
}
