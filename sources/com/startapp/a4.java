package com.startapp;

import android.os.Handler;
import android.webkit.WebView;
import com.startapp.w3;
import com.vungle.ads.internal.Constants;

public class a4 extends w3 {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebView f34186a;

        public a(a4 a4Var, WebView webView) {
            this.f34186a = webView;
        }

        public void run() {
            try {
                this.f34186a.setBackgroundColor(0);
            } catch (Exception unused) {
            }
        }
    }

    public void a(WebView webView) {
        new Handler().postDelayed(new a(this, webView), 1000);
    }

    public void b(WebView webView) {
        this.D = false;
        webView.setOnTouchListener(new w3.d());
        if (this.f36710h.equals(Constants.PLACEMENT_TYPE_INTERSTITIAL)) {
            webView.setBackgroundColor(0);
        }
    }
}
