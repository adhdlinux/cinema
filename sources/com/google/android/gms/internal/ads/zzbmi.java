package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzbmi implements Runnable {
    public final /* synthetic */ zzbmj zza;
    public final /* synthetic */ zzblg zzb;

    public /* synthetic */ zzbmi(zzbmj zzbmj, zzblg zzblg) {
        this.zza = zzbmj;
        this.zzb = zzblg;
    }

    public final void run() {
        zzblg zzblg = this.zzb;
        zzblg.zzr("/result", zzbii.zzo);
        zzblg.zzc();
    }
}
