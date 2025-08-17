package com.google.android.gms.internal.ads;

public final class zzaae {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    /* access modifiers changed from: private */
    public long zzf;
    /* access modifiers changed from: private */
    public long zzg;
    /* access modifiers changed from: private */
    public long zzh;

    protected zzaae(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.zza = j2;
        long j9 = j3;
        this.zzb = j9;
        long j10 = j5;
        this.zze = j10;
        long j11 = j6;
        this.zzf = j11;
        long j12 = j7;
        this.zzg = j12;
        long j13 = j8;
        this.zzc = j13;
        this.zzh = zzf(j9, 0, j10, j11, j12, j13);
    }

    protected static long zzf(long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j5;
        if (j8 + 1 >= j6 || 1 + j3 >= j4) {
            return j8;
        }
        long j9 = (long) (((float) (j2 - j3)) * (((float) (j6 - j8)) / ((float) (j4 - j3))));
        return Math.max(j8, Math.min(((j8 + j9) - j7) - (j9 / 20), j6 - 1));
    }

    static /* bridge */ /* synthetic */ void zzg(zzaae zzaae, long j2, long j3) {
        zzaae.zze = j2;
        zzaae.zzg = j3;
        zzaae.zzi();
    }

    static /* bridge */ /* synthetic */ void zzh(zzaae zzaae, long j2, long j3) {
        zzaae.zzd = j2;
        zzaae.zzf = j3;
        zzaae.zzi();
    }

    private final void zzi() {
        this.zzh = zzf(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
