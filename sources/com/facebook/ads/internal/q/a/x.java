package com.facebook.ads.internal.q.a;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final DisplayMetrics f20693a;

    /* renamed from: b  reason: collision with root package name */
    public static final float f20694b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f20695c = new AtomicInteger(1);

    static {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        f20693a = displayMetrics;
        f20694b = displayMetrics.density;
    }

    public static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = f20695c;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static int a(int i2) {
        return (int) TypedValue.applyDimension(2, (float) i2, f20693a);
    }

    public static void a(View view) {
        view.setId(View.generateViewId());
    }

    public static void a(View view, int i2) {
        view.setBackground(new ColorDrawable(i2));
    }

    public static void a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void a(TextView textView, boolean z2, int i2) {
        textView.setTypeface(z2 ? Typeface.create("sans-serif-medium", 0) : Typeface.create(Typeface.SANS_SERIF, 0));
        textView.setTextSize(2, (float) i2);
    }

    public static void a(View... viewArr) {
        for (View b2 : viewArr) {
            b(b2);
        }
    }

    public static void b(View view) {
        ViewGroup viewGroup;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
    }
}
