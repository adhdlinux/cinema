package com.google.android.gms.internal.ads;

import android.util.SparseArray;

final class zzair {
    private final zzabz zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final zzfv zzd;
    private final byte[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private final zzaiq zzi = new zzaiq((zzaip) null);
    private final zzaiq zzj = new zzaiq((zzaip) null);
    private boolean zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;

    public zzair(zzabz zzabz, boolean z2, boolean z3) {
        this.zza = zzabz;
        byte[] bArr = new byte[128];
        this.zze = bArr;
        this.zzd = new zzfv(bArr, 0, 0);
        this.zzk = false;
    }

    public final void zza(zzfs zzfs) {
        this.zzc.append(zzfs.zza, zzfs);
    }

    public final void zzb(zzft zzft) {
        this.zzb.append(zzft.zzd, zzft);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long j2, int i2, long j3) {
        this.zzf = i2;
        this.zzh = j3;
        this.zzg = j2;
    }

    public final boolean zze(long j2, int i2, boolean z2, boolean z3) {
        boolean z4 = false;
        if (this.zzf == 9) {
            if (z2 && this.zzk) {
                long j3 = this.zzg;
                int i3 = i2 + ((int) (j2 - j3));
                long j4 = this.zzm;
                if (j4 != -9223372036854775807L) {
                    this.zza.zzs(j4, this.zzn ? 1 : 0, (int) (j3 - this.zzl), i3, (zzaby) null);
                }
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z5 = this.zzn;
        int i4 = this.zzf;
        if (i4 == 5 || (z3 && i4 == 1)) {
            z4 = true;
        }
        boolean z6 = z5 | z4;
        this.zzn = z6;
        return z6;
    }
}
