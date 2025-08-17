package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzdrr implements Runnable {
    public final /* synthetic */ zzdsc zza;
    public final /* synthetic */ zzcaj zzb;

    public /* synthetic */ zzdrr(zzdsc zzdsc, zzcaj zzcaj) {
        this.zza = zzdsc;
        this.zzb = zzcaj;
    }

    public final void run() {
        zzcaj zzcaj = this.zzb;
        String zzc = zzt.zzo().zzh().zzh().zzc();
        if (!TextUtils.isEmpty(zzc)) {
            zzcaj.zzd(zzc);
        } else {
            zzcaj.zze(new Exception());
        }
    }
}
