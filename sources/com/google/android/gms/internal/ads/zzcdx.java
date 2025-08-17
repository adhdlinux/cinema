package com.google.android.gms.internal.ads;

public final class zzcdx implements zzkk {
    private final zzxp zzb = new zzxp(true, 65536);
    private long zzc = 15000000;
    private long zzd = 30000000;
    private long zze = 2500000;
    private long zzf = 5000000;
    private int zzg;
    private boolean zzh;

    zzcdx() {
    }

    public final long zza() {
        return 0;
    }

    public final void zzb() {
        zzj(false);
    }

    public final void zzc() {
        zzj(true);
    }

    public final void zzd() {
        zzj(true);
    }

    public final /* synthetic */ void zze(zzcw zzcw, zzbw zzbw, zzli[] zzliArr, zzvn zzvn, zzxa[] zzxaArr) {
        int i2;
        int i3 = 0;
        this.zzg = 0;
        while (true) {
            int length = zzliArr.length;
            if (i3 < 2) {
                if (zzxaArr[i3] != null) {
                    int i4 = this.zzg;
                    if (zzliArr[i3].zzb() != 1) {
                        i2 = 131072000;
                    } else {
                        i2 = 13107200;
                    }
                    this.zzg = i4 + i2;
                }
                i3++;
            } else {
                this.zzb.zzf(this.zzg);
                return;
            }
        }
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg(long j2, long j3, float f2) {
        boolean z2 = true;
        char c2 = j3 > this.zzd ? 0 : j3 < this.zzc ? (char) 2 : 1;
        int zza = this.zzb.zza();
        int i2 = this.zzg;
        if (c2 != 2 && (c2 != 1 || !this.zzh || zza >= i2)) {
            z2 = false;
        }
        this.zzh = z2;
        return z2;
    }

    public final /* synthetic */ boolean zzh(zzcw zzcw, zzbw zzbw, long j2, float f2, boolean z2, long j3) {
        long j4 = z2 ? this.zzf : this.zze;
        return j4 <= 0 || j2 >= j4;
    }

    public final zzxp zzi() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(boolean z2) {
        this.zzg = 0;
        this.zzh = false;
        if (z2) {
            this.zzb.zze();
        }
    }

    public final synchronized void zzk(int i2) {
        this.zze = ((long) i2) * 1000;
    }

    public final synchronized void zzl(int i2) {
        this.zzf = ((long) i2) * 1000;
    }

    public final synchronized void zzm(int i2) {
        this.zzd = ((long) i2) * 1000;
    }

    public final synchronized void zzn(int i2) {
        this.zzc = ((long) i2) * 1000;
    }
}
