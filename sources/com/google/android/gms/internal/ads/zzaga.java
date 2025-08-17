package com.google.android.gms.internal.ads;

final class zzaga implements zzafz {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaga(long[] jArr, long[] jArr2, long j2, long j3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j2;
        this.zzd = j3;
    }

    public static zzaga zza(long j2, long j3, zzabp zzabp, zzfa zzfa) {
        int i2;
        int i3;
        long j4 = j2;
        zzabp zzabp2 = zzabp;
        zzfa zzfa2 = zzfa;
        zzfa2.zzG(10);
        int zze = zzfa.zze();
        if (zze <= 0) {
            return null;
        }
        int i4 = zzabp2.zzd;
        if (i4 >= 32000) {
            i2 = 1152;
        } else {
            i2 = 576;
        }
        long zzp = zzfj.zzp((long) zze, ((long) i2) * 1000000, (long) i4);
        int zzo = zzfa.zzo();
        int zzo2 = zzfa.zzo();
        int zzo3 = zzfa.zzo();
        zzfa2.zzG(2);
        long j5 = j3 + ((long) zzabp2.zzc);
        long[] jArr = new long[zzo];
        long[] jArr2 = new long[zzo];
        int i5 = 0;
        long j6 = j3;
        while (i5 < zzo) {
            int i6 = zzo2;
            jArr[i5] = (((long) i5) * zzp) / ((long) zzo);
            long j7 = j5;
            jArr2[i5] = Math.max(j6, j7);
            if (zzo3 == 1) {
                i3 = zzfa.zzk();
            } else if (zzo3 == 2) {
                i3 = zzfa.zzo();
            } else if (zzo3 == 3) {
                i3 = zzfa.zzm();
            } else if (zzo3 != 4) {
                return null;
            } else {
                i3 = zzfa.zzn();
            }
            int i7 = i6;
            j6 += ((long) i3) * ((long) i7);
            i5++;
            zzfa zzfa3 = zzfa;
            j5 = j7;
            zzo2 = i7;
            zzo = zzo;
        }
        if (!(j4 == -1 || j4 == j6)) {
            zzer.zzf("VbriSeeker", "VBRI data size mismatch: " + j4 + ", " + j6);
        }
        return new zzaga(jArr, jArr2, zzp, j6);
    }

    public final long zzb() {
        return this.zzd;
    }

    public final long zzc(long j2) {
        return this.zza[zzfj.zzc(this.zzb, j2, true, true)];
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzabt zzg(long j2) {
        int zzc2 = zzfj.zzc(this.zza, j2, true, true);
        zzabw zzabw = new zzabw(this.zza[zzc2], this.zzb[zzc2]);
        if (zzabw.zzb < j2) {
            long[] jArr = this.zza;
            if (zzc2 != jArr.length - 1) {
                int i2 = zzc2 + 1;
                return new zzabt(zzabw, new zzabw(jArr[i2], this.zzb[i2]));
            }
        }
        return new zzabt(zzabw, zzabw);
    }

    public final boolean zzh() {
        return true;
    }
}
