package com.unity3d.services.core.webview;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;

public final /* synthetic */ class a implements WebViewCompat.WebMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewBridgeInterface f37218a;

    public /* synthetic */ a(WebViewBridgeInterface webViewBridgeInterface) {
        this.f37218a = webViewBridgeInterface;
    }

    public final void a(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
        this.f37218a.onHandleInvocation(webView, webMessageCompat, uri, z2, javaScriptReplyProxy);
    }
}
