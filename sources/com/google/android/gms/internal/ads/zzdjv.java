package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdjv implements zzcgk {
    public final /* synthetic */ zzcai zza;

    public /* synthetic */ zzdjv(zzcai zzcai) {
        this.zza = zzcai;
    }

    public final void zza(boolean z2) {
        zzcai zzcai = this.zza;
        if (z2) {
            zzcai.zzb();
        } else {
            zzcai.zze(new zzefu(1, "Image Web View failed to load."));
        }
    }
}
