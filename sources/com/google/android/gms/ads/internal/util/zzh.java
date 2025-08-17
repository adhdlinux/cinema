package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.applovin.sdk.AppLovinMediationProvider;

public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc = AppLovinMediationProvider.ADMOB;

    public /* synthetic */ zzh(zzj zzj, Context context, String str) {
        this.zza = zzj;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzQ(this.zzb, this.zzc);
    }
}
