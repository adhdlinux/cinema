package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

public final class zzgpt extends AbstractList {
    private final List zza;
    private final zzgps zzb;

    public zzgpt(List list, zzgps zzgps) {
        this.zza = list;
        this.zzb = zzgps;
    }

    public final Object get(int i2) {
        zzaxx zzb2 = zzaxx.zzb(((Integer) this.zza.get(i2)).intValue());
        if (zzb2 == null) {
            return zzaxx.AD_FORMAT_TYPE_UNSPECIFIED;
        }
        return zzb2;
    }

    public final int size() {
        return this.zza.size();
    }
}
