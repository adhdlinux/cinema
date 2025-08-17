package com.google.android.gms.ads.appopen;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzbsw;

public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ AppOpenAd.AppOpenAdLoadCallback zzd;

    public /* synthetic */ zzb(Context context, String str, AdRequest adRequest, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adRequest;
        this.zzd = appOpenAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdRequest adRequest = this.zzc;
        try {
            new zzawb(context, str, adRequest.zza(), 3, this.zzd).zza();
        } catch (IllegalStateException e2) {
            zzbsw.zza(context).zzf(e2, "AppOpenAd.load");
        }
    }
}
