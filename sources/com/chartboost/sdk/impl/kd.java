package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.widget.RelativeLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public abstract class kd extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public z2 f18075a;

    /* renamed from: b  reason: collision with root package name */
    public WebChromeClient f18076b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f18077c;

    /* renamed from: d  reason: collision with root package name */
    public a9 f18078d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f18079e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kd(Context context) {
        super(context);
        Intrinsics.f(context, "context");
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public void a() {
        Unit unit;
        z2 z2Var = this.f18075a;
        if (z2Var == null) {
            w7.a("ViewBase", "Webview is null on destroyWebview");
            return;
        }
        RelativeLayout relativeLayout = this.f18077c;
        if (relativeLayout != null) {
            relativeLayout.removeView(z2Var);
            removeView(relativeLayout);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.a("CommonWebViewBase", "webViewContainer is null destroyWebview");
        }
        z2 z2Var2 = this.f18075a;
        if (z2Var2 != null) {
            z2Var2.loadUrl("about:blank");
            z2Var2.onPause();
            z2Var2.removeAllViews();
            z2Var2.destroy();
        }
        removeAllViews();
        this.f18079e = null;
    }

    public final Activity getActivity() {
        return this.f18079e;
    }

    public final a9 getLastOrientation() {
        return this.f18078d;
    }

    public final WebChromeClient getWebChromeClient() {
        return this.f18076b;
    }

    public final z2 getWebView() {
        return this.f18075a;
    }

    public final RelativeLayout getWebViewContainer() {
        return this.f18077c;
    }

    public final void setActivity(Activity activity) {
        this.f18079e = activity;
    }

    public final void setLastOrientation(a9 a9Var) {
        this.f18078d = a9Var;
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f18076b = webChromeClient;
    }

    public final void setWebView(z2 z2Var) {
        this.f18075a = z2Var;
    }

    public final void setWebViewContainer(RelativeLayout relativeLayout) {
        this.f18077c = relativeLayout;
    }
}
