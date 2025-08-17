package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzfro extends zzfrr {
    zzfro() {
        super((zzfrq) null);
    }

    static final zzfrr zzf(int i2) {
        return i2 < 0 ? zzfrr.zzb : i2 > 0 ? zzfrr.zzc : zzfrr.zza;
    }

    public final int zza() {
        return 0;
    }

    public final zzfrr zzb(int i2, int i3) {
        return zzf(i2 < i3 ? -1 : i2 > i3 ? 1 : 0);
    }

    public final zzfrr zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    public final zzfrr zzd(boolean z2, boolean z3) {
        return zzf(zzfuj.zza(z2, z3));
    }

    public final zzfrr zze(boolean z2, boolean z3) {
        return zzf(zzfuj.zza(false, false));
    }
}
