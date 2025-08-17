package com.google.android.gms.internal.ads;

final class zzbgt extends zzbfu {
    final /* synthetic */ zzbgw zza;

    /* synthetic */ zzbgt(zzbgw zzbgw, zzbgs zzbgs) {
        this.zza = zzbgw;
    }

    public final void zze(zzbfl zzbfl, String str) {
        zzbgw zzbgw = this.zza;
        if (zzbgw.zzb != null) {
            zzbgw.zzb.onCustomClick(zzbgw.zzf(zzbfl), str);
        }
    }
}
