package com.utils.Getlink.Provider;

import com.original.tase.helper.webview.WebViewDriver;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public abstract class ProviderWebView extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private WebViewDriver f37408e;

    static /* synthetic */ Object K(ProviderWebView providerWebView, Continuation<? super Unit> continuation) {
        WebViewDriver webViewDriver = providerWebView.f37408e;
        if (webViewDriver != null) {
            webViewDriver.destroy();
        }
        providerWebView.f37408e = null;
        return Unit.f40298a;
    }

    public Object J(Continuation<? super Unit> continuation) {
        return K(this, continuation);
    }

    public final WebViewDriver L() {
        return this.f37408e;
    }

    public final void M(WebViewDriver webViewDriver) {
        this.f37408e = webViewDriver;
    }
}
