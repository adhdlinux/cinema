package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

public final /* synthetic */ class zzauw implements ValueCallback {
    public final /* synthetic */ zzaux zza;
    public final /* synthetic */ zzaup zzb;
    public final /* synthetic */ WebView zzc;
    public final /* synthetic */ boolean zzd;

    public /* synthetic */ zzauw(zzaux zzaux, zzaup zzaup, WebView webView, boolean z2) {
        this.zza = zzaux;
        this.zzb = zzaup;
        this.zzc = webView;
        this.zzd = z2;
    }

    public final void onReceiveValue(Object obj) {
        zzaux zzaux = this.zza;
        zzaup zzaup = this.zzb;
        WebView webView = this.zzc;
        boolean z2 = this.zzd;
        zzaux.zze.zzd(zzaup, webView, (String) obj, z2);
    }
}
