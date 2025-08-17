package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbbf;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbk;

public final class zzba {
    private static final zzba zza = new zzba();
    private final zzbbf zzb;
    private final zzbbg zzc;
    private final zzbbk zzd;

    protected zzba() {
        zzbbf zzbbf = new zzbbf();
        zzbbg zzbbg = new zzbbg();
        zzbbk zzbbk = new zzbbk();
        this.zzb = zzbbf;
        this.zzc = zzbbg;
        this.zzd = zzbbk;
    }

    public static zzbbf zza() {
        return zza.zzb;
    }

    public static zzbbg zzb() {
        return zza.zzc;
    }

    public static zzbbk zzc() {
        return zza.zzd;
    }
}
