package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzakf {
    public final int zza;
    public final long zzb;

    private zzakf(int i2, long j2) {
        this.zza = i2;
        this.zzb = j2;
    }

    public static zzakf zza(zzaax zzaax, zzfa zzfa) throws IOException {
        ((zzaam) zzaax).zzm(zzfa.zzH(), 0, 8, false);
        zzfa.zzF(0);
        return new zzakf(zzfa.zze(), zzfa.zzq());
    }
}
