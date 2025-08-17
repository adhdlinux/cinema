package com.google.android.gms.ads.admanager;

public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ AdManagerAdView zza;
    public final /* synthetic */ AdManagerAdRequest zzb;

    public /* synthetic */ zzb(AdManagerAdView adManagerAdView, AdManagerAdRequest adManagerAdRequest) {
        this.zza = adManagerAdView;
        this.zzb = adManagerAdRequest;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
