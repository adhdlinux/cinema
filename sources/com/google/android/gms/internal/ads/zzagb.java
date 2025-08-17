package com.google.android.gms.internal.ads;

final class zzagb implements zzafz {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long[] zzf;

    private zzagb(long j2, int i2, long j3, long j4, long[] jArr) {
        this.zza = j2;
        this.zzb = i2;
        this.zzc = j3;
        this.zzf = jArr;
        this.zzd = j4;
        this.zze = j4 != -1 ? j2 + j4 : -1;
    }

    public static zzagb zza(long j2, long j3, zzabp zzabp, zzfa zzfa) {
        int zzn;
        long j4 = j2;
        zzabp zzabp2 = zzabp;
        int i2 = zzabp2.zzg;
        int i3 = zzabp2.zzd;
        int zze2 = zzfa.zze();
        if ((zze2 & 1) != 1 || (zzn = zzfa.zzn()) == 0) {
            return null;
        }
        int i4 = zze2 & 6;
        long zzp = zzfj.zzp((long) zzn, ((long) i2) * 1000000, (long) i3);
        if (i4 != 6) {
            return new zzagb(j3, zzabp2.zzc, zzp, -1, (long[]) null);
        }
        long zzs = zzfa.zzs();
        long[] jArr = new long[100];
        for (int i5 = 0; i5 < 100; i5++) {
            jArr[i5] = (long) zzfa.zzk();
        }
        if (j4 != -1) {
            long j5 = j3 + zzs;
            if (j4 != j5) {
                zzer.zzf("XingSeeker", "XING data size mismatch: " + j4 + ", " + j5);
            }
        }
        return new zzagb(j3, zzabp2.zzc, zzp, zzs, jArr);
    }

    private final long zzd(int i2) {
        return (this.zzc * ((long) i2)) / 100;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc(long j2) {
        long j3;
        double d2;
        long j4 = j2 - this.zza;
        if (!zzh() || j4 <= ((long) this.zzb)) {
            return 0;
        }
        long[] jArr = this.zzf;
        zzdy.zzb(jArr);
        double d3 = (((double) j4) * 256.0d) / ((double) this.zzd);
        int zzc2 = zzfj.zzc(jArr, (long) d3, true, true);
        long zzd2 = zzd(zzc2);
        long j5 = jArr[zzc2];
        int i2 = zzc2 + 1;
        long zzd3 = zzd(i2);
        if (zzc2 == 99) {
            j3 = 256;
        } else {
            j3 = jArr[i2];
        }
        if (j5 == j3) {
            d2 = 0.0d;
        } else {
            d2 = (d3 - ((double) j5)) / ((double) (j3 - j5));
        }
        return zzd2 + Math.round(d2 * ((double) (zzd3 - zzd2)));
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzabt zzg(long j2) {
        double d2;
        if (!zzh()) {
            zzabw zzabw = new zzabw(0, this.zza + ((long) this.zzb));
            return new zzabt(zzabw, zzabw);
        }
        long max = Math.max(0, Math.min(j2, this.zzc));
        double d3 = (((double) max) * 100.0d) / ((double) this.zzc);
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i2 = (int) d3;
                long[] jArr = this.zzf;
                zzdy.zzb(jArr);
                double d5 = (double) jArr[i2];
                if (i2 == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) jArr[i2 + 1];
                }
                d4 = d5 + ((d3 - ((double) i2)) * (d2 - d5));
            }
        }
        zzabw zzabw2 = new zzabw(max, this.zza + Math.max((long) this.zzb, Math.min(Math.round((d4 / 256.0d) * ((double) this.zzd)), this.zzd - 1)));
        return new zzabt(zzabw2, zzabw2);
    }

    public final boolean zzh() {
        return this.zzf != null;
    }
}
