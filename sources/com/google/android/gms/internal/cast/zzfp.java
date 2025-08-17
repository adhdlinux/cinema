package com.google.android.gms.internal.cast;

import java.util.AbstractMap;

final class zzfp extends zzfh {
    final /* synthetic */ zzfq zza;

    zzfp(zzfq zzfq) {
        this.zza = zzfq;
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        zzeu.zza(i2, this.zza.zzc, "index");
        zzfq zzfq = this.zza;
        int i3 = i2 + i2;
        Object obj = zzfq.zzb[i3];
        obj.getClass();
        Object obj2 = zzfq.zzb[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
