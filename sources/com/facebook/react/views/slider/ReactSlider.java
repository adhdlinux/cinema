package com.facebook.react.views.slider;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

public class ReactSlider extends AppCompatSeekBar {
    private static int DEFAULT_TOTAL_STEPS = 128;
    private double mMaxValue = 0.0d;
    private double mMinValue = 0.0d;
    private double mStep = 0.0d;
    private double mStepCalculated = 0.0d;
    private double mValue = 0.0d;

    public ReactSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        disableStateListAnimatorIfNeeded();
    }

    private double getStepValue() {
        double d2 = this.mStep;
        return d2 > 0.0d ? d2 : this.mStepCalculated;
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
    }

    private void updateAll() {
        if (this.mStep == 0.0d) {
            this.mStepCalculated = (this.mMaxValue - this.mMinValue) / ((double) DEFAULT_TOTAL_STEPS);
        }
        setMax(getTotalSteps());
        updateValue();
    }

    private void updateValue() {
        double d2 = this.mValue;
        double d3 = this.mMinValue;
        setProgress((int) Math.round(((d2 - d3) / (this.mMaxValue - d3)) * ((double) getTotalSteps())));
    }

    /* access modifiers changed from: package-private */
    public void disableStateListAnimatorIfNeeded() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && i2 < 26) {
            super.setStateListAnimator((StateListAnimator) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxValue(double d2) {
        this.mMaxValue = d2;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setMinValue(double d2) {
        this.mMinValue = d2;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setStep(double d2) {
        this.mStep = d2;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setValue(double d2) {
        this.mValue = d2;
        updateValue();
    }

    public double toRealProgress(int i2) {
        if (i2 == getMax()) {
            return this.mMaxValue;
        }
        return (((double) i2) * getStepValue()) + this.mMinValue;
    }
}
