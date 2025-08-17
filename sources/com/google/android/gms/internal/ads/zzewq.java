package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzewq implements zzexe {
    private final zzfbu zza;
    private final Executor zzb;
    private final zzfvy zzc = new zzewo(this);

    public zzewq(zzfbu zzfbu, Executor executor) {
        this.zza = zzfbu;
        this.zzb = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzcun zzcun, zzewz zzewz) throws Exception {
        zzfce zzfce = zzewz.zzb;
        zzbue zzbue = zzewz.zza;
        zzfcd zzb2 = this.zza.zzb(zzfce);
        if (!(zzb2 == null || zzbue == null)) {
            zzfwc.zzq(zzcun.zzb().zzh(zzbue), this.zzc, this.zzb);
        }
        return zzfwc.zzh(new zzewp(zzfce, zzbue, zzb2));
    }

    public final zzfwm zzb(zzexf zzexf, zzexd zzexd, zzcun zzcun) {
        return zzfwc.zze(zzfwc.zzm(zzfvt.zzv(new zzexa(this.zza, zzcun, this.zzb).zzc()), new zzewm(this, zzcun), this.zzb), Exception.class, new zzewn(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexf, zzexd zzexd, Object obj) {
        return zzb(zzexf, zzexd, (zzcun) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
