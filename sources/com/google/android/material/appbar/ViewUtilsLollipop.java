package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.ThemeEnforcement;

class ViewUtilsLollipop {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f29496a = {16843848};

    ViewUtilsLollipop() {
    }

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(View view, float f2) {
        int integer = view.getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = (long) integer;
        stateListAnimator.addState(new int[]{16842766, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(view, ViewProps.ELEVATION, new float[]{0.0f}).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, ViewProps.ELEVATION, new float[]{f2}).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, ViewProps.ELEVATION, new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, f29496a, i2, i3, new int[0]);
        try {
            if (h2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, h2.getResourceId(0, 0)));
            }
        } finally {
            h2.recycle();
        }
    }
}
