package com.google.android.gms.internal.ads;

public final class zzewu implements zzexe {
    private final zzexe zza;
    private zzcun zzb;

    public zzewu(zzexe zzexe) {
        this.zza = zzexe;
    }

    /* renamed from: zza */
    public final synchronized zzcun zzd() {
        return this.zzb;
    }

    public final synchronized zzfwm zzb(zzexf zzexf, zzexd zzexd, zzcun zzcun) {
        this.zzb = zzcun;
        if (zzexf.zza != null) {
            zzcsk zzb2 = zzcun.zzb();
            return zzb2.zzi(zzb2.zzk(zzfwc.zzh(zzexf.zza)));
        }
        return ((zzewt) this.zza).zzb(zzexf, zzexd, zzcun);
    }

    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexf, zzexd zzexd, Object obj) {
        return zzb(zzexf, zzexd, (zzcun) null);
    }
}
