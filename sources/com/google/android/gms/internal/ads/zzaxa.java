package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;

public final /* synthetic */ class zzaxa implements Runnable {
    public final /* synthetic */ zzaxf zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzaxa(zzaxf zzaxf, Context context) {
        this.zza = zzaxf;
        this.zzb = context;
    }

    public final void run() {
        zzaxf zzaxf = this.zza;
        Context context = this.zzb;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeG)).booleanValue()) {
            try {
                zzaxf.zza = (zzatv) zzbzv.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzaxb.zza);
                zzaxf.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                zzaxf.zzb = true;
            } catch (RemoteException | zzbzu | NullPointerException unused) {
                zzbzr.zze("Cannot dynamite load clearcut");
            }
        }
    }
}
