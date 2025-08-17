package com.google.android.gms.internal.ads;

import java.util.List;

final class zzbso extends zzbsh {
    final /* synthetic */ List zza;

    zzbso(zzbsq zzbsq, List list) {
        this.zza = list;
    }

    public final void zze(String str) {
        zzbzr.zzg("Error recording click: ".concat(String.valueOf(str)));
    }

    public final void zzf(List list) {
        zzbzr.zzi("Recorded click: ".concat(this.zza.toString()));
    }
}
