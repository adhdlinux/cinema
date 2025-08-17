package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzud implements zzvf {
    private final zzvf zza;
    private final long zzb;

    public zzud(zzvf zzvf, long j2) {
        this.zza = zzvf;
        this.zzb = j2;
    }

    public final int zza(zzkj zzkj, zzhp zzhp, int i2) {
        int zza2 = this.zza.zza(zzkj, zzhp, i2);
        if (zza2 != -4) {
            return zza2;
        }
        zzhp.zzd = Math.max(0, zzhp.zzd + this.zzb);
        return -4;
    }

    public final int zzb(long j2) {
        return this.zza.zzb(j2 - this.zzb);
    }

    public final zzvf zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
