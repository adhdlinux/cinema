package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

public class TextScale extends Transition {
    private void b0(TransitionValues transitionValues) {
        View view = transitionValues.f11788b;
        if (view instanceof TextView) {
            transitionValues.f11787a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public void f(TransitionValues transitionValues) {
        b0(transitionValues);
    }

    public void i(TransitionValues transitionValues) {
        b0(transitionValues);
    }

    public Animator m(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f2;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.f11788b instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.f11788b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        Map<String, Object> map = transitionValues.f11787a;
        Map<String, Object> map2 = transitionValues2.f11787a;
        float f3 = 1.0f;
        if (map.get("android:textscale:scale") != null) {
            f2 = ((Float) map.get("android:textscale:scale")).floatValue();
        } else {
            f2 = 1.0f;
        }
        if (map2.get("android:textscale:scale") != null) {
            f3 = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (f2 == f3) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, f3});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
