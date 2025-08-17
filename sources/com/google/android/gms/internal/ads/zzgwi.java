package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzgwi extends zzgwa {
    private static final zzgwr zza = zzgwf.zza(Collections.emptyMap());

    /* synthetic */ zzgwi(Map map, zzgwg zzgwg) {
        super(map);
    }

    public static zzgwh zzc(int i2) {
        return new zzgwh(i2, (zzgwg) null);
    }

    /* renamed from: zzd */
    public final Map zzb() {
        LinkedHashMap zzb = zzgwb.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzb.put(entry.getKey(), ((zzgwr) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzb);
    }
}
