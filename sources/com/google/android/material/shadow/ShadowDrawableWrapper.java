package com.google.android.material.shadow;

import androidx.appcompat.graphics.drawable.DrawableWrapper;

public class ShadowDrawableWrapper extends DrawableWrapper {

    /* renamed from: a  reason: collision with root package name */
    static final double f29953a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f2, float f3, boolean z2) {
        return z2 ? (float) (((double) f2) + ((1.0d - f29953a) * ((double) f3))) : f2;
    }

    public static float b(float f2, float f3, boolean z2) {
        return z2 ? (float) (((double) (f2 * 1.5f)) + ((1.0d - f29953a) * ((double) f3))) : f2 * 1.5f;
    }

    public float c() {
        throw null;
    }

    public final void d(float f2) {
        throw null;
    }

    public void e(float f2) {
        throw null;
    }
}
