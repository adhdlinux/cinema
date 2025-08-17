package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjo {
    static final zzjo zza = new zzjo(true);
    private static volatile boolean zzb = false;
    private static volatile zzjo zzc;
    private static volatile zzjo zzd;
    private final Map zze;

    zzjo() {
        this.zze = new HashMap();
    }

    public static zzjo zza() {
        zzjo zzjo = zzc;
        if (zzjo == null) {
            synchronized (zzjo.class) {
                zzjo = zzc;
                if (zzjo == null) {
                    zzjo = zza;
                    zzc = zzjo;
                }
            }
        }
        return zzjo;
    }

    public static zzjo zzb() {
        zzjo zzjo = zzd;
        if (zzjo != null) {
            return zzjo;
        }
        synchronized (zzjo.class) {
            zzjo zzjo2 = zzd;
            if (zzjo2 != null) {
                return zzjo2;
            }
            zzjo zzb2 = zzjw.zzb(zzjo.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzka zzc(zzlj zzlj, int i2) {
        return (zzka) this.zze.get(new zzjn(zzlj, i2));
    }

    zzjo(boolean z2) {
        this.zze = Collections.emptyMap();
    }
}
