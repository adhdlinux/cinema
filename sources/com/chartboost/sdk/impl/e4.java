package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.chartboost.sdk.impl.tb;

public class e4 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final f4 f17594a;

    /* renamed from: b  reason: collision with root package name */
    public final z4 f17595b;

    public e4(f4 f4Var, z4 z4Var) {
        this.f17594a = f4Var;
        this.f17595b = z4Var;
    }

    public final void a(String str) {
        f4 f4Var = this.f17594a;
        if (f4Var != null) {
            f4Var.a(str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        f4 f4Var = this.f17594a;
        if (f4Var != null) {
            f4Var.d();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (Build.VERSION.SDK_INT >= 26) {
            PackageInfo a2 = WebView.getCurrentWebViewPackage();
            if (a2 != null) {
                w7.a("CustomWebViewClient", "WebView version: " + a2.versionName);
            } else {
                a("Device was not set up correctly.");
            }
        }
        this.f17594a.c();
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        a("Error loading " + str2 + ": " + str);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error loading ");
        sb.append(webResourceRequest.getUrl().toString());
        sb.append(": ");
        sb.append(webResourceResponse == null ? "unknown error" : webResourceResponse.getReasonPhrase());
        w7.a("CustomWebViewClient", sb.toString());
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f17595b.track(x4.a(tb.h.WEBVIEW_SSL_ERROR, sslError.toString()));
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String str;
        if (renderProcessGoneDetail.didCrash()) {
            str = "Webview crashed: " + renderProcessGoneDetail;
        } else {
            str = "Webview killed, likely due to low memory";
        }
        a(str);
        if (webView == null || !(webView.getContext() instanceof Activity)) {
            return true;
        }
        ((Activity) webView.getContext()).finish();
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest.isForMainFrame()) {
            a("Error loading " + webResourceRequest.getUrl().toString() + ": " + webResourceError.getDescription());
        }
    }
}
