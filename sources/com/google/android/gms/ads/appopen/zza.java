package com.google.android.gms.ads.appopen;

import android.content.Context;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzbsw;

public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdManagerAdRequest zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ AppOpenAd.AppOpenAdLoadCallback zze;

    public /* synthetic */ zza(Context context, String str, AdManagerAdRequest adManagerAdRequest, int i2, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adManagerAdRequest;
        this.zzd = i2;
        this.zze = appOpenAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdManagerAdRequest adManagerAdRequest = this.zzc;
        try {
            new zzawb(context, str, adManagerAdRequest.zza(), this.zzd, this.zze).zza();
        } catch (IllegalStateException e2) {
            zzbsw.zza(context).zzf(e2, "AppOpenAdManager.load");
        }
    }
}
