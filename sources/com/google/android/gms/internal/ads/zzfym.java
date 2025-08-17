package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public final class zzfym {
    private final ConcurrentMap zza;
    private final List zzb;
    private final zzfyi zzc;
    private final Class zzd;
    private final zzghn zze;

    /* synthetic */ zzfym(ConcurrentMap concurrentMap, List list, zzfyi zzfyi, zzghn zzghn, Class cls, zzfyl zzfyl) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzfyi;
        this.zzd = cls;
        this.zze = zzghn;
    }

    public final zzfyi zza() {
        return this.zzc;
    }

    public final zzghn zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzfyk(bArr, (zzfyj) null));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }
}
