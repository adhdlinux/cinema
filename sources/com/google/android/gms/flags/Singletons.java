package com.google.android.gms.flags;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Singletons {
    private static Singletons zza;
    private final FlagRegistry zzb = new FlagRegistry();
    private final zzb zzc = new zzb();

    static {
        Singletons singletons = new Singletons();
        synchronized (Singletons.class) {
            zza = singletons;
        }
    }

    private Singletons() {
    }

    @KeepForSdk
    public static FlagRegistry flagRegistry() {
        return zzb().zzb;
    }

    public static zzb zza() {
        return zzb().zzc;
    }

    private static Singletons zzb() {
        Singletons singletons;
        synchronized (Singletons.class) {
            singletons = zza;
        }
        return singletons;
    }
}
