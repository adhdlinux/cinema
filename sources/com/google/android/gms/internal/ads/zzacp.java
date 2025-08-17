package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

final class zzacp {
    protected final zzabz zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzacp(int i2, int i3, long j2, int i4, zzabz zzabz) {
        i3 = i3 != 1 ? 2 : i3;
        this.zzd = j2;
        this.zze = i4;
        this.zza = zzabz;
        this.zzb = zzi(i2, i3 == 2 ? 1667497984 : 1651965952);
        this.zzc = i3 == 2 ? zzi(i2, 1650720768) : -1;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i2, int i3) {
        return (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48) | i3;
    }

    private final long zzj(int i2) {
        return (this.zzd * ((long) i2)) / ((long) this.zze);
    }

    private final zzabw zzk(int i2) {
        return new zzabw(((long) this.zzl[i2]) * zzj(1), this.zzk[i2]);
    }

    public final zzabt zza(long j2) {
        int zzj2 = (int) (j2 / zzj(1));
        int zzb2 = zzfj.zzb(this.zzl, zzj2, true, true);
        if (this.zzl[zzb2] == zzj2) {
            zzabw zzk2 = zzk(zzb2);
            return new zzabt(zzk2, zzk2);
        }
        zzabw zzk3 = zzk(zzb2);
        int i2 = zzb2 + 1;
        if (i2 < this.zzk.length) {
            return new zzabt(zzk3, zzk(i2));
        }
        return new zzabt(zzk3, zzk3);
    }

    public final void zzb(long j2) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i2 = this.zzj;
        jArr2[i2] = j2;
        this.zzl[i2] = this.zzi;
        this.zzj = i2 + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i2) {
        this.zzf = i2;
        this.zzg = i2;
    }

    public final void zzf(long j2) {
        if (this.zzj == 0) {
            this.zzh = 0;
            return;
        }
        this.zzh = this.zzl[zzfj.zzc(this.zzk, j2, true, true)];
    }

    public final boolean zzg(int i2) {
        return this.zzb == i2 || this.zzc == i2;
    }

    public final boolean zzh(zzaax zzaax) throws IOException {
        boolean z2;
        int i2;
        int i3 = this.zzg;
        int zze2 = i3 - this.zza.zze(zzaax, i3, false);
        this.zzg = zze2;
        if (zze2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.zzf > 0) {
                zzabz zzabz = this.zza;
                long zzj2 = zzj(this.zzh);
                int binarySearch = Arrays.binarySearch(this.zzl, this.zzh);
                int i4 = this.zzf;
                if (binarySearch >= 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                zzabz.zzs(zzj2, i2, i4, 0, (zzaby) null);
            }
            this.zzh++;
        }
        return z2;
    }
}
