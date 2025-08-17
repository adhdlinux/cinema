package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzaje {
    private final zzfh zza = new zzfh(0);
    private final zzfa zzb = new zzfa();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zzaje() {
    }

    public static long zzc(zzfa zzfa) {
        zzfa zzfa2 = zzfa;
        int zzc2 = zzfa.zzc();
        if (zzfa.zza() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzfa2.zzB(bArr, 0, 9);
        zzfa2.zzF(zzc2);
        byte b2 = bArr[0];
        if ((b2 & 196) == 68) {
            byte b3 = bArr[2];
            if ((b3 & 4) == 4) {
                byte b4 = bArr[4];
                if ((b4 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j2 = (long) b2;
                    long j3 = (long) bArr[1];
                    long j4 = (long) b3;
                    long j5 = 255 & ((long) bArr[3]);
                    return ((j4 & 3) << 13) | ((j2 & 3) << 28) | (((56 & j2) >> 3) << 30) | ((j3 & 255) << 20) | (((j4 & 248) >> 3) << 15) | (j5 << 5) | ((((long) b4) & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    private final int zzf(zzaax zzaax) {
        zzfa zzfa = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfa.zzD(bArr, 0);
        this.zzc = true;
        zzaax.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public final int zza(zzaax zzaax, zzabs zzabs) throws IOException {
        long j2 = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzaax.zzd();
            int min = (int) Math.min(20000, zzd2);
            long j3 = zzd2 - ((long) min);
            if (zzaax.zzf() != j3) {
                zzabs.zza = j3;
                return 1;
            }
            this.zzb.zzC(min);
            zzaax.zzj();
            ((zzaam) zzaax).zzm(this.zzb.zzH(), 0, min, false);
            zzfa zzfa = this.zzb;
            int zzc2 = zzfa.zzc();
            int zzd3 = zzfa.zzd() - 4;
            while (true) {
                if (zzd3 < zzc2) {
                    break;
                }
                if (zzg(zzfa.zzH(), zzd3) == 442) {
                    zzfa.zzF(zzd3 + 4);
                    long zzc3 = zzc(zzfa);
                    if (zzc3 != -9223372036854775807L) {
                        j2 = zzc3;
                        break;
                    }
                }
                zzd3--;
            }
            this.zzg = j2;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zzf(zzaax);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000, zzaax.zzd());
            if (zzaax.zzf() != 0) {
                zzabs.zza = 0;
                return 1;
            }
            this.zzb.zzC(min2);
            zzaax.zzj();
            ((zzaam) zzaax).zzm(this.zzb.zzH(), 0, min2, false);
            zzfa zzfa2 = this.zzb;
            int zzc4 = zzfa2.zzc();
            int zzd4 = zzfa2.zzd();
            while (true) {
                if (zzc4 >= zzd4 - 3) {
                    break;
                }
                if (zzg(zzfa2.zzH(), zzc4) == 442) {
                    zzfa2.zzF(zzc4 + 4);
                    long zzc5 = zzc(zzfa2);
                    if (zzc5 != -9223372036854775807L) {
                        j2 = zzc5;
                        break;
                    }
                }
                zzc4++;
            }
            this.zzf = j2;
            this.zzd = true;
            return 0;
        } else {
            long j4 = this.zzf;
            if (j4 == -9223372036854775807L) {
                zzf(zzaax);
                return 0;
            }
            long zzb2 = this.zza.zzb(this.zzg) - this.zza.zzb(j4);
            this.zzh = zzb2;
            if (zzb2 < 0) {
                zzer.zzf("PsDurationReader", "Invalid duration: " + zzb2 + ". Using TIME_UNSET instead.");
                this.zzh = -9223372036854775807L;
            }
            zzf(zzaax);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfh zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
