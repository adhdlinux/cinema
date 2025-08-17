package com.google.android.gms.internal.ads;

final class zzakh implements zzabv {
    private final zzake zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzakh(zzake zzake, int i2, long j2, long j3) {
        this.zza = zzake;
        this.zzb = i2;
        this.zzc = j2;
        long j4 = (j3 - j2) / ((long) zzake.zzd);
        this.zzd = j4;
        this.zze = zza(j4);
    }

    private final long zza(long j2) {
        return zzfj.zzp(j2 * ((long) this.zzb), 1000000, (long) this.zza.zzc);
    }

    public final long zze() {
        return this.zze;
    }

    public final zzabt zzg(long j2) {
        long max = Math.max(0, Math.min((((long) this.zza.zzc) * j2) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long j3 = this.zzc + (((long) this.zza.zzd) * max);
        long zza2 = zza(max);
        zzabw zzabw = new zzabw(zza2, j3);
        if (zza2 >= j2 || max == this.zzd - 1) {
            return new zzabt(zzabw, zzabw);
        }
        long j4 = max + 1;
        return new zzabt(zzabw, new zzabw(zza(j4), this.zzc + (((long) this.zza.zzd) * j4)));
    }

    public final boolean zzh() {
        return true;
    }
}
