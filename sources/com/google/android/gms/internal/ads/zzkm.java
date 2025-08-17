package com.google.android.gms.internal.ads;

final class zzkm {
    public final zztm zza;
    public final Object zzb;
    public final zzvf[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzkn zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzlk[] zzi;
    private final zzxg zzj;
    private final zzlb zzk;
    private zzkm zzl;
    private zzvn zzm = zzvn.zza;
    private zzxh zzn;
    private long zzo;

    public zzkm(zzlk[] zzlkArr, long j2, zzxg zzxg, zzxp zzxp, zzlb zzlb, zzkn zzkn, zzxh zzxh) {
        this.zzi = zzlkArr;
        this.zzo = j2;
        this.zzj = zzxg;
        this.zzk = zzlb;
        zzto zzto = zzkn.zza;
        this.zzb = zzto.zza;
        this.zzf = zzkn;
        this.zzn = zzxh;
        this.zzc = new zzvf[2];
        this.zzh = new boolean[2];
        long j3 = zzkn.zzb;
        long j4 = zzkn.zzd;
        zztm zzo2 = zzlb.zzo(zzto, zzxp, j3);
        this.zza = j4 != -9223372036854775807L ? new zzst(zzo2, true, 0, j4) : zzo2;
    }

    private final void zzs() {
        if (zzu()) {
            int i2 = 0;
            while (true) {
                zzxh zzxh = this.zzn;
                if (i2 < zzxh.zza) {
                    zzxh.zzb(i2);
                    zzxa zzxa = this.zzn.zzc[i2];
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i2 = 0;
            while (true) {
                zzxh zzxh = this.zzn;
                if (i2 < zzxh.zza) {
                    zzxh.zzb(i2);
                    zzxa zzxa = this.zzn.zzc[i2];
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzxh zzxh, long j2, boolean z2) {
        return zzb(zzxh, j2, false, new boolean[2]);
    }

    public final long zzb(zzxh zzxh, long j2, boolean z2, boolean[] zArr) {
        boolean z3;
        zzxh zzxh2 = zzxh;
        int i2 = 0;
        while (true) {
            boolean z4 = true;
            if (i2 >= zzxh2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z2 || !zzxh.zza(this.zzn, i2)) {
                z4 = false;
            }
            zArr2[i2] = z4;
            i2++;
        }
        int i3 = 0;
        while (true) {
            zzlk[] zzlkArr = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzlkArr[i3].zzb();
            i3++;
        }
        zzs();
        this.zzn = zzxh2;
        zzt();
        long zzf2 = this.zza.zzf(zzxh2.zzc, this.zzh, this.zzc, zArr, j2);
        int i4 = 0;
        while (true) {
            zzlk[] zzlkArr2 = this.zzi;
            if (i4 >= 2) {
                break;
            }
            zzlkArr2[i4].zzb();
            i4++;
        }
        this.zze = false;
        int i5 = 0;
        while (true) {
            zzvf[] zzvfArr = this.zzc;
            if (i5 >= 2) {
                return zzf2;
            }
            if (zzvfArr[i5] != null) {
                zzdy.zzf(zzxh.zzb(i5));
                this.zzi[i5].zzb();
                this.zze = true;
            } else {
                if (zzxh2.zzc[i5] == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzdy.zzf(z3);
            }
            i5++;
        }
    }

    public final long zzc() {
        long j2;
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        if (this.zze) {
            j2 = this.zza.zzb();
        } else {
            j2 = Long.MIN_VALUE;
        }
        if (j2 == Long.MIN_VALUE) {
            return this.zzf.zze;
        }
        return j2;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzkm zzg() {
        return this.zzl;
    }

    public final zzvn zzh() {
        return this.zzm;
    }

    public final zzxh zzi() {
        return this.zzn;
    }

    public final zzxh zzj(float f2, zzcw zzcw) throws zzih {
        zzxh zzo2 = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzcw);
        for (zzxa zzxa : zzo2.zzc) {
        }
        return zzo2;
    }

    public final void zzk(long j2) {
        zzdy.zzf(zzu());
        this.zza.zzo(j2 - this.zzo);
    }

    public final void zzl(float f2, zzcw zzcw) throws zzih {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzxh zzj2 = zzj(f2, zzcw);
        zzkn zzkn = this.zzf;
        long j2 = zzkn.zzb;
        long j3 = zzkn.zze;
        if (j3 != -9223372036854775807L && j2 >= j3) {
            j2 = Math.max(0, j3 - 1);
        }
        long zza2 = zza(zzj2, j2, false);
        long j4 = this.zzo;
        zzkn zzkn2 = this.zzf;
        this.zzo = j4 + (zzkn2.zzb - zza2);
        this.zzf = zzkn2.zzb(zza2);
    }

    public final void zzm(long j2) {
        zzdy.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j2 - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzlb zzlb = this.zzk;
        zztm zztm = this.zza;
        try {
            if (zztm instanceof zzst) {
                zzlb.zzh(((zzst) zztm).zza);
            } else {
                zzlb.zzh(zztm);
            }
        } catch (RuntimeException e2) {
            zzer.zzd("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public final void zzo(zzkm zzkm) {
        if (zzkm != this.zzl) {
            zzs();
            this.zzl = zzkm;
            zzt();
        }
    }

    public final void zzp(long j2) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zztm zztm = this.zza;
        if (zztm instanceof zzst) {
            long j2 = this.zzf.zzd;
            if (j2 == -9223372036854775807L) {
                j2 = Long.MIN_VALUE;
            }
            ((zzst) zztm).zzn(0, j2);
        }
    }

    public final boolean zzr() {
        if (this.zzd) {
            return !this.zze || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }
}
