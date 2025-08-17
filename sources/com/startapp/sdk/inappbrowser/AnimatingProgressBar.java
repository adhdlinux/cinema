package com.startapp.sdk.inappbrowser;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

public class AnimatingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f36496a = new AccelerateDecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f36497b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36498c;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public Integer f36499a;

        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            this.f36499a = num;
            AnimatingProgressBar.super.setProgress(num.intValue());
        }
    }

    public AnimatingProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36498c = false;
        this.f36498c = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f36497b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void setProgress(int i2) {
        if (!this.f36498c) {
            super.setProgress(i2);
            return;
        }
        ValueAnimator valueAnimator = this.f36497b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            if (getProgress() >= i2) {
                return;
            }
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getProgress(), i2});
            this.f36497b = ofInt;
            ofInt.setInterpolator(f36496a);
            this.f36497b.addUpdateListener(new a());
        }
        this.f36497b.setIntValues(new int[]{getProgress(), i2});
        this.f36497b.start();
    }

    public void a() {
        super.setProgress(0);
        ValueAnimator valueAnimator = this.f36497b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
