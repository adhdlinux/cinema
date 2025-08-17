package com.google.android.gms.internal.ads;

import java.util.ArrayList;

public final /* synthetic */ class zzblt implements Runnable {
    public final /* synthetic */ zzbml zza;
    public final /* synthetic */ zzbmk zzb;
    public final /* synthetic */ zzblg zzc;
    public final /* synthetic */ ArrayList zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzblt(zzbml zzbml, zzbmk zzbmk, zzblg zzblg, ArrayList arrayList, long j2) {
        this.zza = zzbml;
        this.zzb = zzbmk;
        this.zzc = zzblg;
        this.zzd = arrayList;
        this.zze = j2;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
