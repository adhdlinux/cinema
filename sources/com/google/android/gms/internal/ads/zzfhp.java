package com.google.android.gms.internal.ads;

import android.webkit.WebView;

final class zzfhp implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    zzfhp(zzfhq zzfhq, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    public final void run() {
        this.zza.loadUrl(this.zzb);
    }
}
