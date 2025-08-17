package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class zzfhl {
    private static final zzfhl zza = new zzfhl();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfhl() {
    }

    public static zzfhl zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfha zzfha) {
        this.zzb.add(zzfha);
    }

    public final void zze(zzfha zzfha) {
        boolean zzg = zzg();
        this.zzb.remove(zzfha);
        this.zzc.remove(zzfha);
        if (zzg && !zzg()) {
            zzfhr.zzb().zzf();
        }
    }

    public final void zzf(zzfha zzfha) {
        boolean zzg = zzg();
        this.zzc.add(zzfha);
        if (!zzg) {
            zzfhr.zzb().zze();
        }
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
