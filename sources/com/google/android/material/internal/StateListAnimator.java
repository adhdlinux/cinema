package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class StateListAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tuple> f29903a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private Tuple f29904b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f29905c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f29906d = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f29905c == animator) {
                stateListAnimator.f29905c = null;
            }
        }
    };

    static class Tuple {

        /* renamed from: a  reason: collision with root package name */
        final int[] f29908a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f29909b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f29908a = iArr;
            this.f29909b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f29906d);
        this.f29903a.add(tuple);
    }
}
