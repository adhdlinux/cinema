package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.json.JSONArray;
import org.json.JSONObject;

public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    public WebViewBridgeInterface() {
        this((IWebViewBridge) null, (IInvocationCallbackInvoker) null, 3, (DefaultConstructorMarker) null);
    }

    public WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker) {
        Intrinsics.f(iWebViewBridge, "webViewBridge");
        Intrinsics.f(iInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        this.webViewBridge = iWebViewBridge;
        this.webViewAppInvocationCallbackInvoker = iInvocationCallbackInvoker;
    }

    private final Object[] toTypedArray(JSONArray jSONArray) {
        IntRange j2 = RangesKt___RangesKt.j(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(j2, 10));
        Iterator it2 = j2.iterator();
        while (it2.hasNext()) {
            arrayList.add(jSONArray.get(((IntIterator) it2).nextInt()));
        }
        return arrayList.toArray(new Object[0]);
    }

    @JavascriptInterface
    public final void handleCallback(String str, String str2, String str3) {
        Intrinsics.f(str, "callbackId");
        Intrinsics.f(str2, "callbackStatus");
        Intrinsics.f(str3, "rawParameters");
        DeviceLog.debug("handleCallback " + str + ' ' + str2 + ' ' + str3);
        this.webViewBridge.handleCallback(str, str2, toTypedArray(new JSONArray(str3)));
    }

    @JavascriptInterface
    public final void handleInvocation(String str) {
        Intrinsics.f(str, "data");
        DeviceLog.debug("handleInvocation " + str);
        JSONArray jSONArray = new JSONArray(str);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = jSONArray.get(i2);
            Intrinsics.d(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            Intrinsics.d(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            Intrinsics.d(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            Intrinsics.d(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    public final void onHandleCallback(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
        boolean z3;
        Intrinsics.f(webView, "view");
        Intrinsics.f(webMessageCompat, "message");
        Intrinsics.f(uri, "sourceOrigin");
        Intrinsics.f(javaScriptReplyProxy, "replyProxy");
        String a2 = webMessageCompat.a();
        if (z2) {
            if (a2 == null || StringsKt__StringsJVMKt.v(a2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                JSONObject jSONObject = new JSONObject(a2);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("status");
                String string3 = jSONObject.getString("parameters");
                Intrinsics.e(string, "callbackId");
                Intrinsics.e(string2, "callbackStatus");
                Intrinsics.e(string3, "rawParameters");
                handleCallback(string, string2, string3);
            }
        }
    }

    public final void onHandleInvocation(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
        boolean z3;
        Intrinsics.f(webView, "view");
        Intrinsics.f(webMessageCompat, "message");
        Intrinsics.f(uri, "sourceOrigin");
        Intrinsics.f(javaScriptReplyProxy, "replyProxy");
        String a2 = webMessageCompat.a();
        if (z2) {
            if (a2 == null || StringsKt__StringsJVMKt.v(a2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                handleInvocation(a2);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i2 & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker);
    }
}
