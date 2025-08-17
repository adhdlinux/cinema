package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzewf implements zzexe {
    private zzcun zza;
    private final Executor zzb = zzfwt.zzb();

    public final zzcun zza() {
        return this.zza;
    }

    public final zzfwm zzb(zzexf zzexf, zzexd zzexd, zzcun zzcun) {
        zzcum zza2 = zzexd.zza(zzexf.zzb);
        zza2.zzb(new zzexi(true));
        zzcun zzcun2 = (zzcun) zza2.zzh();
        this.zza = zzcun2;
        zzcsk zzb2 = zzcun2.zzb();
        zzfcd zzfcd = new zzfcd();
        return zzfwc.zzl(zzfwc.zzm(zzfvt.zzv(zzb2.zzj()), new zzewd(this, zzfcd, zzb2), this.zzb), new zzewe(zzfcd), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexf, zzexd zzexd, Object obj) {
        return zzb(zzexf, zzexd, (zzcun) null);
    }

    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
