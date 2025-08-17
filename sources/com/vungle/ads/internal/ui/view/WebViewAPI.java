package com.vungle.ads.internal.ui.view;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import kotlinx.serialization.json.JsonObject;

public interface WebViewAPI {

    public interface MraidDelegate {
        boolean processCommand(String str, JsonObject jsonObject);
    }

    public interface WebClientErrorHandler {
        void onReceivedError(String str, boolean z2);

        void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess);

        boolean onWebRenderingProcessGone(WebView webView, Boolean bool);
    }

    void notifyPropertiesChange(boolean z2);

    void setAdVisibility(boolean z2);

    void setConsentStatus(boolean z2, String str, String str2, String str3, String str4);

    void setErrorHandler(WebClientErrorHandler webClientErrorHandler);

    void setMraidDelegate(MraidDelegate mraidDelegate);

    void setWebViewObserver(WebViewObserver webViewObserver);
}
