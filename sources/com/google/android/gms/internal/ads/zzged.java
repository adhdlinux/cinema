package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

public final class zzged {
    private static final zzged zza = new zzged();
    private static final zzgec zzb = new zzgec((zzgeb) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzged zza() {
        return zza;
    }

    public final zzghp zzb() {
        zzghp zzghp = (zzghp) this.zzc.get();
        return zzghp == null ? zzb : zzghp;
    }
}
