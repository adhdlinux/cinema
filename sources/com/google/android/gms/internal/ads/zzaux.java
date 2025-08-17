package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzaux implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzaup zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzauz zze;

    zzaux(zzauz zzauz, zzaup zzaup, WebView webView, boolean z2) {
        this.zze = zzauz;
        this.zzb = zzaup;
        this.zzc = webView;
        this.zzd = z2;
        this.zza = new zzauw(this, zzaup, webView, z2);
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
