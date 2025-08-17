package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzajn {
    private final zzfh zza = new zzfh(0);
    private final zzfa zzb = new zzfa();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zzajn(int i2) {
    }

    private final int zze(zzaax zzaax) {
        zzfa zzfa = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfa.zzD(bArr, 0);
        this.zzc = true;
        zzaax.zzj();
        return 0;
    }

    public final int zza(zzaax zzaax, zzabs zzabs, int i2) throws IOException {
        if (i2 <= 0) {
            zze(zzaax);
            return 0;
        }
        long j2 = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzaax.zzd();
            int min = (int) Math.min(112800, zzd2);
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
            int zzd3 = zzfa.zzd();
            int i3 = zzd3 - 188;
            while (true) {
                if (i3 < zzc2) {
                    break;
                }
                byte[] zzH = zzfa.zzH();
                int i4 = -4;
                int i5 = 0;
                while (true) {
                    if (i4 > 4) {
                        break;
                    }
                    int i6 = (i4 * 188) + i3;
                    if (i6 < zzc2 || i6 >= zzd3 || zzH[i6] != 71) {
                        i5 = 0;
                    } else {
                        i5++;
                        if (i5 == 5) {
                            long zzb2 = zzajx.zzb(zzfa, i3, i2);
                            if (zzb2 != -9223372036854775807L) {
                                j2 = zzb2;
                                break;
                            }
                        }
                    }
                    i4++;
                }
                i3--;
            }
            this.zzg = j2;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zze(zzaax);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzaax.zzd());
            if (zzaax.zzf() != 0) {
                zzabs.zza = 0;
                return 1;
            }
            this.zzb.zzC(min2);
            zzaax.zzj();
            ((zzaam) zzaax).zzm(this.zzb.zzH(), 0, min2, false);
            zzfa zzfa2 = this.zzb;
            int zzc3 = zzfa2.zzc();
            int zzd4 = zzfa2.zzd();
            while (true) {
                if (zzc3 >= zzd4) {
                    break;
                }
                if (zzfa2.zzH()[zzc3] == 71) {
                    long zzb3 = zzajx.zzb(zzfa2, zzc3, i2);
                    if (zzb3 != -9223372036854775807L) {
                        j2 = zzb3;
                        break;
                    }
                }
                zzc3++;
            }
            this.zzf = j2;
            this.zzd = true;
            return 0;
        } else {
            long j4 = this.zzf;
            if (j4 == -9223372036854775807L) {
                zze(zzaax);
                return 0;
            }
            long zzb4 = this.zza.zzb(this.zzg) - this.zza.zzb(j4);
            this.zzh = zzb4;
            if (zzb4 < 0) {
                zzer.zzf("TsDurationReader", "Invalid duration: " + zzb4 + ". Using TIME_UNSET instead.");
                this.zzh = -9223372036854775807L;
            }
            zze(zzaax);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfh zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
