package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdnf implements zzcgk {
    public final /* synthetic */ zzcaj zza;

    public /* synthetic */ zzdnf(zzcaj zzcaj) {
        this.zza = zzcaj;
    }

    public final void zza(boolean z2) {
        zzcaj zzcaj = this.zza;
        if (z2) {
            zzcaj.zzd((Object) null);
        } else {
            zzcaj.zze(new Exception("Ad Web View failed to load."));
        }
    }
}
