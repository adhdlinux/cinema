package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

public final class ThemeEnforcement {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f29912a = {R$attr.f29316b};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f29913b = {R$attr.colorSecondary};

    private ThemeEnforcement() {
    }

    public static void a(Context context) {
        e(context, f29912a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f4, i2, i3);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.h4, false);
        obtainStyledAttributes.recycle();
        if (z2) {
            c(context);
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f29913b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        boolean z2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f4, i2, i3);
        boolean z3 = false;
        if (!obtainStyledAttributes.getBoolean(R$styleable.i4, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            if (obtainStyledAttributes.getResourceId(R$styleable.g4, -1) != -1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = f(context, attributeSet, iArr, i2, i3, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z2) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (!g(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int resourceId : iArr2) {
            if (obtainStyledAttributes.getResourceId(resourceId, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    private static boolean g(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    public static TypedArray h(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static TintTypedArray i(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return TintTypedArray.v(context, attributeSet, iArr, i2, i3);
    }
}
