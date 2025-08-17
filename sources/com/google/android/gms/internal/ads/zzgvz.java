package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

public class zzgvz {
    final LinkedHashMap zza;

    zzgvz(int i2) {
        this.zza = zzgwb.zzb(i2);
    }

    /* access modifiers changed from: package-private */
    public final zzgvz zza(Object obj, zzgwr zzgwr) {
        LinkedHashMap linkedHashMap = this.zza;
        zzgwm.zza(obj, "key");
        zzgwm.zza(zzgwr, "provider");
        linkedHashMap.put(obj, zzgwr);
        return this;
    }
}
