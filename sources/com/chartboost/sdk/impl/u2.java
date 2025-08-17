package com.chartboost.sdk.impl;

import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.chartboost.sdk.impl.nd;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

public final class u2 extends WebChromeClient implements nd.a, d6 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f18740f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final View f18741a;

    /* renamed from: b  reason: collision with root package name */
    public final c8 f18742b;

    /* renamed from: c  reason: collision with root package name */
    public final nd f18743c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18744d;

    /* renamed from: e  reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f18745e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public u2(View view, c8 c8Var, nd ndVar) {
        Intrinsics.f(view, "activityNonVideoView");
        Intrinsics.f(c8Var, "cmd");
        this.f18741a = view;
        this.f18742b = c8Var;
        this.f18743c = ndVar;
        c8Var.a((d6) this);
    }

    public final void a(String str) {
        nd ndVar = this.f18743c;
        if (ndVar != null) {
            ndVar.a(str, this);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Intrinsics.f(consoleMessage, "cm");
        String message = consoleMessage.message();
        String simpleName = u2.class.getSimpleName();
        Log.d(simpleName, "Chartboost Rich Webview: " + message + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
        Intrinsics.e(message, "consoleMsg");
        a(message);
        return true;
    }

    public void onHideCustomView() {
        WebChromeClient.CustomViewCallback customViewCallback;
        if (this.f18744d) {
            this.f18741a.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback2 = this.f18745e;
            if (!(customViewCallback2 == null || StringsKt__StringsKt.L(customViewCallback2.getClass().getName(), ".chromium.", false, 2, (Object) null) || (customViewCallback = this.f18745e) == null)) {
                customViewCallback.onCustomViewHidden();
            }
            this.f18744d = false;
            this.f18745e = null;
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2 == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("eventType");
            Intrinsics.e(string, "jsonObj.getString(\"eventType\")");
            JSONObject jSONObject2 = jSONObject.getJSONObject("eventArgs");
            Intrinsics.e(jSONObject2, "jsonObj.getJSONObject(\"eventArgs\")");
            String a2 = this.f18742b.a(jSONObject2, string);
            if (jsPromptResult != null) {
                jsPromptResult.confirm(a2);
            }
            return true;
        } catch (JSONException unused) {
            w7.b("CBRichWebChromeClient", "Exception caught parsing the function name from js to native");
            return true;
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            this.f18744d = true;
            this.f18745e = customViewCallback;
            this.f18741a.setVisibility(4);
        }
    }

    public void a(JSONObject jSONObject) {
        this.f18742b.a(jSONObject, d8.ERROR.c());
    }

    public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }
}
