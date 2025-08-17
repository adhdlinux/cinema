package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;

public final /* synthetic */ class zzebp implements Runnable {
    public final /* synthetic */ zzfgw zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzebp(zzfgw zzfgw, View view) {
        this.zza = zzfgw;
        this.zzb = view;
    }

    public final void run() {
        zzfgw zzfgw = this.zza;
        View view = this.zzb;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue() && zzfgu.zzb()) {
            zzfgw.zzd(view);
        }
    }
}
