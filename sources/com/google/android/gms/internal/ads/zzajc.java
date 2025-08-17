package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzajc implements zzaah {
    private final zzfh zza;
    private final zzfa zzb = new zzfa();

    /* synthetic */ zzajc(zzfh zzfh, zzajb zzajb) {
        this.zza = zzfh;
    }

    public final zzaag zza(zzaax zzaax, long j2) throws IOException {
        int zzh;
        long j3;
        long zzf = zzaax.zzf();
        int min = (int) Math.min(20000, zzaax.zzd() - zzf);
        this.zzb.zzC(min);
        ((zzaam) zzaax).zzm(this.zzb.zzH(), 0, min, false);
        zzfa zzfa = this.zzb;
        int i2 = -1;
        long j4 = -9223372036854775807L;
        int i3 = -1;
        while (zzfa.zza() >= 4) {
            if (zzajd.zzh(zzfa.zzH(), zzfa.zzc()) != 442) {
                zzfa.zzG(1);
            } else {
                zzfa.zzG(4);
                long zzc = zzaje.zzc(zzfa);
                if (zzc != -9223372036854775807L) {
                    long zzb2 = this.zza.zzb(zzc);
                    if (zzb2 > j2) {
                        if (j4 == -9223372036854775807L) {
                            return zzaag.zzd(zzb2, zzf);
                        }
                        j3 = (long) i3;
                    } else if (100000 + zzb2 > j2) {
                        j3 = (long) zzfa.zzc();
                    } else {
                        i3 = zzfa.zzc();
                        j4 = zzb2;
                    }
                    return zzaag.zze(zzf + j3);
                }
                int zzd = zzfa.zzd();
                if (zzfa.zza() >= 10) {
                    zzfa.zzG(9);
                    int zzk = zzfa.zzk() & 7;
                    if (zzfa.zza() >= zzk) {
                        zzfa.zzG(zzk);
                        if (zzfa.zza() >= 4) {
                            if (zzajd.zzh(zzfa.zzH(), zzfa.zzc()) == 443) {
                                zzfa.zzG(4);
                                int zzo = zzfa.zzo();
                                if (zzfa.zza() < zzo) {
                                    zzfa.zzF(zzd);
                                } else {
                                    zzfa.zzG(zzo);
                                }
                            }
                            while (true) {
                                if (zzfa.zza() < 4 || (zzh = zzajd.zzh(zzfa.zzH(), zzfa.zzc())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzfa.zzG(4);
                                if (zzfa.zza() < 2) {
                                    zzfa.zzF(zzd);
                                    break;
                                }
                                zzfa.zzF(Math.min(zzfa.zzd(), zzfa.zzc() + zzfa.zzo()));
                            }
                        } else {
                            zzfa.zzF(zzd);
                        }
                    } else {
                        zzfa.zzF(zzd);
                    }
                } else {
                    zzfa.zzF(zzd);
                }
                i2 = zzfa.zzc();
            }
        }
        if (j4 != -9223372036854775807L) {
            return zzaag.zzf(j4, zzf + ((long) i2));
        }
        return zzaag.zza;
    }

    public final void zzb() {
        zzfa zzfa = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfa.zzD(bArr, 0);
    }
}
