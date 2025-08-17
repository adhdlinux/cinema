package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.CircularRevealWidget;

public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    public static Animator a(CircularRevealWidget circularRevealWidget, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.f29739a, CircularRevealWidget.CircularRevealEvaluator.f29737b, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f2, f3, f4)});
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f2, (int) f3, revealInfo.f29743c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator.AnimatorListener b(final CircularRevealWidget circularRevealWidget) {
        return new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                circularRevealWidget.b();
            }

            public void onAnimationStart(Animator animator) {
                circularRevealWidget.a();
            }
        };
    }
}
