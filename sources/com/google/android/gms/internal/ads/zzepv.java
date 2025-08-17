package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

public final /* synthetic */ class zzepv implements Runnable {
    public final /* synthetic */ zzepz zza;
    public final /* synthetic */ zzbpt zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ zzeil zze;
    public final /* synthetic */ zzcaj zzf;

    public /* synthetic */ zzepv(zzepz zzepz, zzbpt zzbpt, Bundle bundle, List list, zzeil zzeil, zzcaj zzcaj) {
        this.zza = zzepz;
        this.zzb = zzbpt;
        this.zzc = bundle;
        this.zzd = list;
        this.zze = zzeil;
        this.zzf = zzcaj;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
