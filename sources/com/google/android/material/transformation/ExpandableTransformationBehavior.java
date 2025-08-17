package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f30197b;

    public ExpandableTransformationBehavior() {
    }

    /* access modifiers changed from: protected */
    public boolean G(View view, View view2, boolean z2, boolean z3) {
        boolean z4;
        AnimatorSet animatorSet = this.f30197b;
        if (animatorSet != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            animatorSet.cancel();
        }
        AnimatorSet I = I(view, view2, z2, z4);
        this.f30197b = I;
        I.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                AnimatorSet unused = ExpandableTransformationBehavior.this.f30197b = null;
            }
        });
        this.f30197b.start();
        if (!z3) {
            this.f30197b.end();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract AnimatorSet I(View view, View view2, boolean z2, boolean z3);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
