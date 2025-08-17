package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public class DrawableAlphaProperty extends Property<Drawable, Integer> {

    /* renamed from: b  reason: collision with root package name */
    public static final Property<Drawable, Integer> f29402b = new DrawableAlphaProperty();

    /* renamed from: a  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f29403a = new WeakHashMap<>();

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
    }

    /* renamed from: a */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    /* renamed from: b */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
