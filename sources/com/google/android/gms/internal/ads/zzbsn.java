package com.google.android.gms.internal.ads;

import java.util.List;

final class zzbsn extends zzbsh {
    final /* synthetic */ List zza;

    zzbsn(zzbsq zzbsq, List list) {
        this.zza = list;
    }

    public final void zze(String str) {
        zzbzr.zzg("Error recording impression urls: ".concat(String.valueOf(str)));
    }

    public final void zzf(List list) {
        zzbzr.zzi("Recorded impression urls: ".concat(this.zza.toString()));
    }
}
