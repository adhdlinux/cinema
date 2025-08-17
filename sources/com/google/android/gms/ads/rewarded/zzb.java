package com.google.android.gms.ads.rewarded;

import android.content.Context;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbvw;

public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdManagerAdRequest zzc;
    public final /* synthetic */ RewardedAdLoadCallback zzd;

    public /* synthetic */ zzb(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adManagerAdRequest;
        this.zzd = rewardedAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdManagerAdRequest adManagerAdRequest = this.zzc;
        try {
            new zzbvw(context, str).zza(adManagerAdRequest.zza(), this.zzd);
        } catch (IllegalStateException e2) {
            zzbsw.zza(context).zzf(e2, "RewardedAd.loadAdManager");
        }
    }
}
