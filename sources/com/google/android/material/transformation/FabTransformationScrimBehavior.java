package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final MotionTiming f30216c = new MotionTiming(75, 150);

    /* renamed from: d  reason: collision with root package name */
    private final MotionTiming f30217d = new MotionTiming(0, 150);

    public FabTransformationScrimBehavior() {
    }

    private void J(View view, boolean z2, boolean z3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        MotionTiming motionTiming;
        ObjectAnimator objectAnimator;
        if (z2) {
            motionTiming = this.f30216c;
        } else {
            motionTiming = this.f30217d;
        }
        if (z2) {
            if (!z3) {
                view.setAlpha(0.0f);
            }
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
        }
        motionTiming.a(objectAnimator);
        list.add(objectAnimator);
    }

    public boolean C(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.C(coordinatorLayout, view, motionEvent);
    }

    /* access modifiers changed from: protected */
    public AnimatorSet I(View view, final View view2, final boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        J(view2, z2, z3, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z2) {
                    view2.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z2) {
                    view2.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
