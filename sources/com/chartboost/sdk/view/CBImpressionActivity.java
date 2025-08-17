package com.chartboost.sdk.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import c0.c;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.impl.f2;
import com.chartboost.sdk.impl.i3;
import com.chartboost.sdk.impl.j6;
import com.chartboost.sdk.impl.kd;
import com.chartboost.sdk.impl.l6;
import com.chartboost.sdk.impl.w7;
import kotlin.jvm.internal.Intrinsics;

public final class CBImpressionActivity extends Activity implements j6 {

    /* renamed from: a  reason: collision with root package name */
    public l6 f19193a;

    public void a() {
        finish();
    }

    public CBImpressionActivity b() {
        return this;
    }

    public boolean c() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return false;
        }
        return decorView.isHardwareAccelerated();
    }

    public void d() {
        View view;
        try {
            int i2 = Build.VERSION.SDK_INT;
            WindowManager.LayoutParams layoutParams = null;
            if (i2 >= 30) {
                Window window = getWindow();
                if (window != null) {
                    window.setDecorFitsSystemWindows(true);
                    WindowInsetsController a2 = window.getInsetsController();
                    if (a2 != null) {
                        a2.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                        a2.setSystemBarsBehavior(2);
                    }
                }
            } else {
                Window window2 = getWindow();
                if (window2 != null) {
                    view = window2.getDecorView();
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setSystemUiVisibility(3846);
                }
            }
            if (i2 >= 28) {
                Window window3 = getWindow();
                if (window3 != null) {
                    layoutParams = window3.getAttributes();
                }
                if (layoutParams != null) {
                    layoutParams.layoutInDisplayCutoutMode = 1;
                }
            }
        } catch (Exception e2) {
            Log.d(f2.f17674a, "Cannot set view to fullscreen: " + e2);
        }
    }

    public final void e() {
        if (this.f19193a != null) {
            return;
        }
        if (Chartboost.isSdkStarted()) {
            this.f19193a = new l6(this, i3.f17882b.j().a());
            return;
        }
        Log.e(f2.f17674a, "Cannot start Chartboost activity due to SDK not being initialized.");
        finish();
    }

    public final boolean f() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getBooleanExtra("isChartboost", false);
        }
        return false;
    }

    public final void g() {
        try {
            l6 l6Var = this.f19193a;
            if (l6Var == null || !l6Var.b()) {
                super.onBackPressed();
            }
        } catch (Exception e2) {
            String a2 = f2.f17674a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "onBackPressed error: " + e2);
            finish();
        }
    }

    public final void h() {
        if (Build.VERSION.SDK_INT >= 34) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new c(this));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.i();
        }
    }

    public void onBackPressed() {
        if (Build.VERSION.SDK_INT < 34) {
            g();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.f(configuration, "newConfig");
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.c();
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h();
        if (!f()) {
            String a2 = f2.f17674a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "This activity cannot be called from outside chartboost SDK");
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().setWindowAnimations(0);
        e();
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.d();
        }
    }

    public void onDestroy() {
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.e();
        }
        this.f19193a = null;
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.f();
        }
    }

    public void onResume() {
        super.onResume();
        e();
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.g();
        }
    }

    public void onStart() {
        super.onStart();
        l6 l6Var = this.f19193a;
        if (l6Var != null) {
            l6Var.h();
        }
    }

    public void a(kd kdVar) {
        Intrinsics.f(kdVar, "view");
        try {
            ViewParent parent = kdVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(kdVar);
            }
            addContentView(kdVar, new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            String a2 = f2.f17674a;
            Log.d(a2, "Cannot attach view to activity: " + e2);
        }
    }
}
