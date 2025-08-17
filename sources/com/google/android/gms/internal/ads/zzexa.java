package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class zzexa {
    private final zzfbu zza;
    private final zzcun zzb;
    private final Executor zzc;
    /* access modifiers changed from: private */
    public zzewz zzd;

    public zzexa(zzfbu zzfbu, zzcun zzcun, Executor executor) {
        this.zza = zzfbu;
        this.zzb = zzcun;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzfce zze() {
        zzfai zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final zzfwm zzc() {
        zzfwm zzfwm;
        zzewz zzewz = this.zzd;
        if (zzewz != null) {
            return zzfwc.zzh(zzewz);
        }
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            zzewz zzewz2 = new zzewz((zzbue) null, zze(), (zzewy) null);
            this.zzd = zzewz2;
            zzfwm = zzfwc.zzh(zzewz2);
        } else {
            zzfwm = zzfwc.zze(zzfwc.zzl(zzfvt.zzv(this.zzb.zzb().zze(this.zza.zza())), new zzewx(this), this.zzc), zzdwa.class, new zzeww(this), this.zzc);
        }
        return zzfwc.zzl(zzfwm, zzewv.zza, this.zzc);
    }
}
