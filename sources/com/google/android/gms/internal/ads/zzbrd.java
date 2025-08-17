package com.google.android.gms.internal.ads;

final class zzbrd extends zzbfu {
    final /* synthetic */ zzbrg zza;

    /* synthetic */ zzbrd(zzbrg zzbrg, zzbrc zzbrc) {
        this.zza = zzbrg;
    }

    public final void zze(zzbfl zzbfl, String str) {
        zzbrg zzbrg = this.zza;
        if (zzbrg.zzb != null) {
            zzbrg.zzb.onCustomClick(zzbrg.zzf(zzbfl), str);
        }
    }
}
