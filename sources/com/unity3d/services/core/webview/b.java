package com.unity3d.services.core.webview;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;

public final /* synthetic */ class b implements WebViewCompat.WebMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewBridgeInterface f37219a;

    public /* synthetic */ b(WebViewBridgeInterface webViewBridgeInterface) {
        this.f37219a = webViewBridgeInterface;
    }

    public final void a(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
        this.f37219a.onHandleCallback(webView, webMessageCompat, uri, z2, javaScriptReplyProxy);
    }
}
