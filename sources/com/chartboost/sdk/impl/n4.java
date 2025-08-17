package com.chartboost.sdk.impl;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class n4 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowManager f18216a;

    /* renamed from: b  reason: collision with root package name */
    public final DisplayMetrics f18217b;

    /* renamed from: c  reason: collision with root package name */
    public final Function0 f18218c;

    /* renamed from: d  reason: collision with root package name */
    public final DisplayMetrics f18219d;

    /* renamed from: e  reason: collision with root package name */
    public final float f18220e;

    /* renamed from: f  reason: collision with root package name */
    public final int f18221f;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18222b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    public n4(WindowManager windowManager, DisplayMetrics displayMetrics, Function0 function0, DisplayMetrics displayMetrics2) {
        Intrinsics.f(windowManager, "windowManager");
        Intrinsics.f(displayMetrics, "displayMetrics");
        Intrinsics.f(function0, "androidVersion");
        Intrinsics.f(displayMetrics2, "realDisplayMetrics");
        this.f18216a = windowManager;
        this.f18217b = displayMetrics;
        this.f18218c = function0;
        this.f18219d = displayMetrics2;
        this.f18220e = displayMetrics.density;
        this.f18221f = displayMetrics.densityDpi;
    }

    public final o4 a() {
        try {
            if (((Number) this.f18218c.invoke()).intValue() >= 30) {
                return a(this.f18216a);
            }
            DisplayMetrics displayMetrics = this.f18217b;
            return new o4(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception e2) {
            w7.a("getDeviceSize", "Cannot create device size", e2);
            return new o4(0, 0);
        }
    }

    public final float b() {
        return this.f18220e;
    }

    public final int c() {
        return this.f18221f;
    }

    public final o4 d() {
        try {
            if (((Number) this.f18218c.invoke()).intValue() >= 30) {
                Rect a2 = this.f18216a.getCurrentWindowMetrics().getBounds();
                return new o4(a2.width(), a2.height());
            }
            this.f18219d.setTo(this.f18217b);
            Display defaultDisplay = this.f18216a.getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(this.f18219d);
            }
            DisplayMetrics displayMetrics = this.f18219d;
            return new o4(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception e2) {
            w7.a("getSize", "Cannot create size", e2);
            return new o4(0, 0);
        }
    }

    public final o4 a(WindowManager windowManager) {
        WindowMetrics a2 = windowManager.getCurrentWindowMetrics();
        Intrinsics.e(a2, "windowManager.currentWindowMetrics");
        WindowInsets a3 = a2.getWindowInsets();
        Intrinsics.e(a3, "metrics.windowInsets");
        Insets a4 = a3.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        Intrinsics.e(a4, "windowInsets.getInsetsIg…displayCutout()\n        )");
        int a5 = a4.right + a4.left;
        Rect a6 = a2.getBounds();
        Intrinsics.e(a6, "metrics.bounds");
        return new o4(a6.width() - a5, a6.height() - (a4.top + a4.bottom));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n4(WindowManager windowManager, DisplayMetrics displayMetrics, Function0 function0, DisplayMetrics displayMetrics2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowManager, displayMetrics, (i2 & 4) != 0 ? a.f18222b : function0, (i2 & 8) != 0 ? new DisplayMetrics() : displayMetrics2);
    }
}
