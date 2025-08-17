package com.original.tase.helper.webview;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

public final class WebViewDriverManager {

    /* renamed from: a  reason: collision with root package name */
    public static final WebViewDriverManager f34039a = new WebViewDriverManager();

    /* renamed from: b  reason: collision with root package name */
    private static final MutableStateFlow<WebViewDriver> f34040b;

    /* renamed from: c  reason: collision with root package name */
    private static final StateFlow<WebViewDriver> f34041c;

    static {
        MutableStateFlow<WebViewDriver> a2 = StateFlowKt.a(null);
        f34040b = a2;
        f34041c = FlowKt.a(a2);
    }

    private WebViewDriverManager() {
    }

    public final void a() {
        WebViewDriver value = f34040b.getValue();
        if (value != null) {
            value.destroy();
        }
    }

    public final void b(WebViewDriver webViewDriver) {
        Intrinsics.f(webViewDriver, "webView");
        a();
        f34040b.setValue(webViewDriver);
    }

    public final void c() {
        f34040b.setValue(null);
    }
}
