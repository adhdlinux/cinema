package com.startapp;

import android.content.DialogInterface;
import android.webkit.WebView;

public final class n6 implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebView f34956a;

    public n6(WebView webView) {
        this.f34956a = webView;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f34956a.stopLoading();
    }
}
