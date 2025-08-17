package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbdw {
    static final AtomicBoolean zza = new AtomicBoolean();
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();

    static zzbdu zza() {
        return (zzbdu) zzb.get();
    }

    static zzbdv zzb() {
        return (zzbdv) zzc.get();
    }

    public static void zzc(zzbdu zzbdu) {
        zzb.set(zzbdu);
    }
}
