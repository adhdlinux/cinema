package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class zzta {
    private final zzabd zza;
    private final Map zzb = new HashMap();
    private final Set zzc = new HashSet();
    private final Map zzd = new HashMap();
    private zzgd zze;

    public zzta(zzabd zzabd) {
        this.zza = zzabd;
    }

    public final void zza(zzgd zzgd) {
        if (zzgd != this.zze) {
            this.zze = zzgd;
            this.zzb.clear();
            this.zzd.clear();
        }
    }
}
