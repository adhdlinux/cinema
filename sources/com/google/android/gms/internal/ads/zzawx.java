package com.google.android.gms.internal.ads;

import java.io.InputStream;

public final class zzawx {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzawx(InputStream inputStream, boolean z2, boolean z3, long j2, boolean z4) {
        this.zza = inputStream;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = j2;
        this.zze = z4;
    }

    public static zzawx zzb(InputStream inputStream, boolean z2, boolean z3, long j2, boolean z4) {
        return new zzawx(inputStream, z2, z3, j2, z4);
    }

    public final long zza() {
        return this.zzd;
    }

    public final InputStream zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
