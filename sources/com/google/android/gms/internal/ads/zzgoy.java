package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzgoy {
    static final zzgoy zza = new zzgoy(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgoy zzd;
    private final Map zze;

    zzgoy() {
        this.zze = new HashMap();
    }

    public static zzgoy zza() {
        return zza;
    }

    public static zzgoy zzb() {
        zzgoy zzgoy = zzd;
        if (zzgoy != null) {
            return zzgoy;
        }
        synchronized (zzgoy.class) {
            zzgoy zzgoy2 = zzd;
            if (zzgoy2 != null) {
                return zzgoy2;
            }
            zzgoy zzb2 = zzgpg.zzb(zzgoy.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzgpk zzc(zzgqw zzgqw, int i2) {
        return (zzgpk) this.zze.get(new zzgox(zzgqw, i2));
    }

    zzgoy(boolean z2) {
        this.zze = Collections.emptyMap();
    }
}
