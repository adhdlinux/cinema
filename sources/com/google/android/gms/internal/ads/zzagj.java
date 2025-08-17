package com.google.android.gms.internal.ads;

final class zzagj implements zzagh {
    private final int zza;
    private final int zzb;
    private final zzfa zzc;

    public zzagj(zzagd zzagd, zzam zzam) {
        zzfa zzfa = zzagd.zza;
        this.zzc = zzfa;
        zzfa.zzF(12);
        int zzn = zzfa.zzn();
        if ("audio/raw".equals(zzam.zzm)) {
            int zzk = zzfj.zzk(zzam.zzB, zzam.zzz);
            if (zzn == 0 || zzn % zzk != 0) {
                zzer.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzk + ", stsz sample size: " + zzn);
                zzn = zzk;
            }
        }
        this.zza = zzn == 0 ? -1 : zzn;
        this.zzb = zzfa.zzn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i2 = this.zza;
        return i2 == -1 ? this.zzc.zzn() : i2;
    }
}
