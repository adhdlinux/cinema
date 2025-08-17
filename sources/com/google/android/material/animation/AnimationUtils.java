package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class AnimationUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f29395a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f29396b = new FastOutSlowInInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f29397c = new FastOutLinearInInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f29398d = new LinearOutSlowInInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f29399e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int b(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
