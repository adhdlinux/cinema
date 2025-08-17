package com.google.android.gms.internal.ads;

public final class zzcdp extends zzcdl {
    public zzcdp(zzcca zzcca) {
        super(zzcca);
    }

    public final void zzf() {
    }

    public final boolean zzt(String str) {
        String zze = zzbzk.zze(str);
        zzcca zzcca = (zzcca) this.zzc.get();
        if (!(zzcca == null || zze == null)) {
            zzcca.zzt(zze, this);
        }
        zzbzr.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zze, "noop", "Noop cache is a noop.");
        return false;
    }
}
