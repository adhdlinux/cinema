package com.google.android.gms.internal.ads;

import java.util.AbstractMap;

final class zzftn extends zzfsc {
    final /* synthetic */ zzfto zza;

    zzftn(zzfto zzfto) {
        this.zza = zzfto;
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        zzfph.zza(i2, this.zza.zzc, "index");
        zzfto zzfto = this.zza;
        int i3 = i2 + i2;
        Object obj = zzfto.zzb[i3];
        obj.getClass();
        Object obj2 = zzfto.zzb[i3 + 1];
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
