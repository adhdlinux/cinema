package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

public final /* synthetic */ class zzbjo implements OnH5AdsEventListener {
    public final /* synthetic */ WebView zza;

    public /* synthetic */ zzbjo(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        WebView webView = this.zza;
        int i2 = zzbjp.zza;
        webView.evaluateJavascript(str, (ValueCallback) null);
    }
}
