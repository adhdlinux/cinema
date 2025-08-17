package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;
import java.util.Collections;

public final class zzaif implements zzaij {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzez zzc = new zzez(new byte[7], 7);
    private final zzfa zzd = new zzfa(Arrays.copyOf(zza, 10));
    private final String zze;
    private String zzf;
    private zzabz zzg;
    private zzabz zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzabz zzu;
    private long zzv;

    public zzaif(boolean z2, String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzb = z2;
        this.zze = str;
    }

    public static boolean zzf(int i2) {
        return (i2 & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzabz zzabz, long j2, int i2, int i3) {
        this.zzi = 4;
        this.zzj = i2;
        this.zzu = zzabz;
        this.zzv = j2;
        this.zzs = i3;
    }

    private final boolean zzk(zzfa zzfa, byte[] bArr, int i2) {
        int min = Math.min(zzfa.zza(), i2 - this.zzj);
        zzfa.zzB(bArr, this.zzj, min);
        int i3 = this.zzj + min;
        this.zzj = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    private static final boolean zzl(byte b2, byte b3) {
        return zzf((b3 & 255) | 65280);
    }

    private static final boolean zzm(zzfa zzfa, byte[] bArr, int i2) {
        if (zzfa.zza() < i2) {
            return false;
        }
        zzfa.zzB(bArr, 0, i2);
        return true;
    }

    public final void zza(zzfa zzfa) throws zzcd {
        int i2;
        byte b2;
        int i3;
        boolean z2;
        int i4;
        zzfa zzfa2 = zzfa;
        this.zzg.getClass();
        int i5 = zzfj.zza;
        while (zzfa.zza() > 0) {
            int i6 = this.zzi;
            int i7 = 13;
            int i8 = 2;
            if (i6 == 0) {
                byte[] zzH = zzfa.zzH();
                int zzc2 = zzfa.zzc();
                int zzd2 = zzfa.zzd();
                while (true) {
                    if (zzc2 >= zzd2) {
                        zzfa2.zzF(zzc2);
                        break;
                    }
                    i2 = zzc2 + 1;
                    b2 = zzH[zzc2] & 255;
                    if (this.zzk == 512 && zzl((byte) -1, (byte) b2)) {
                        if (this.zzm) {
                            break;
                        }
                        int i9 = i2 - 2;
                        zzfa2.zzF(i9 + 1);
                        if (zzm(zzfa2, this.zzc.zza, 1)) {
                            this.zzc.zzj(4);
                            int zzd3 = this.zzc.zzd(1);
                            int i10 = this.zzn;
                            if (i10 == -1 || zzd3 == i10) {
                                if (this.zzo != -1) {
                                    if (!zzm(zzfa2, this.zzc.zza, 1)) {
                                        break;
                                    }
                                    this.zzc.zzj(i8);
                                    if (this.zzc.zzd(4) == this.zzo) {
                                        zzfa2.zzF(i9 + 2);
                                    }
                                }
                                if (!zzm(zzfa2, this.zzc.zza, 4)) {
                                    break;
                                }
                                this.zzc.zzj(14);
                                int zzd4 = this.zzc.zzd(i7);
                                if (zzd4 >= 7) {
                                    byte[] zzH2 = zzfa.zzH();
                                    int zzd5 = zzfa.zzd();
                                    int i11 = i9 + zzd4;
                                    if (i11 < zzd5) {
                                        byte b3 = zzH2[i11];
                                        if (b3 != -1) {
                                            if (b3 == 73) {
                                                int i12 = i11 + 1;
                                                if (i12 != zzd5) {
                                                    if (zzH2[i12] == 68) {
                                                        int i13 = i11 + 2;
                                                        if (i13 != zzd5) {
                                                            if (zzH2[i13] == 51) {
                                                                break;
                                                            }
                                                        } else {
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            int i14 = i11 + 1;
                                            if (i14 == zzd5) {
                                                break;
                                            }
                                            byte b4 = zzH2[i14];
                                            if (zzl((byte) -1, b4) && ((b4 & 8) >> 3) == zzd3) {
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    int i15 = this.zzk;
                    byte b5 = i15 | b2;
                    if (b5 == 329) {
                        i3 = 768;
                    } else if (b5 == 511) {
                        i3 = 512;
                    } else if (b5 != 836) {
                        if (b5 == 1075) {
                            this.zzi = 2;
                            this.zzj = 3;
                            this.zzs = 0;
                            this.zzd.zzF(0);
                            zzfa2.zzF(i2);
                            break;
                        } else if (i15 != 256) {
                            this.zzk = UserVerificationMethods.USER_VERIFY_HANDPRINT;
                            zzc2 = i2 - 1;
                            i7 = 13;
                            i8 = 2;
                        } else {
                            zzc2 = i2;
                            i7 = 13;
                            i8 = 2;
                        }
                    } else {
                        i3 = 1024;
                    }
                    this.zzk = i3;
                    zzc2 = i2;
                    i7 = 13;
                    i8 = 2;
                }
                this.zzp = (b2 & 8) >> 3;
                if (1 != ((b2 & 1) ^ 1)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.zzl = z2;
                if (!this.zzm) {
                    this.zzi = 1;
                    this.zzj = 0;
                } else {
                    zzi();
                }
                zzfa2.zzF(i2);
            } else if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        int min = Math.min(zzfa.zza(), this.zzs - this.zzj);
                        this.zzu.zzq(zzfa2, min);
                        int i16 = this.zzj + min;
                        this.zzj = i16;
                        int i17 = this.zzs;
                        if (i16 == i17) {
                            long j2 = this.zzt;
                            if (j2 != -9223372036854775807L) {
                                this.zzu.zzs(j2, 1, i17, 0, (zzaby) null);
                                this.zzt += this.zzv;
                            }
                            zzh();
                        }
                    } else {
                        if (true != this.zzl) {
                            i4 = 5;
                        } else {
                            i4 = 7;
                        }
                        if (zzk(zzfa2, this.zzc.zza, i4)) {
                            this.zzc.zzj(0);
                            if (!this.zzq) {
                                int zzd6 = this.zzc.zzd(2) + 1;
                                if (zzd6 != 2) {
                                    zzer.zzf("AdtsReader", "Detected audio object type: " + zzd6 + ", but assuming AAC LC.");
                                }
                                this.zzc.zzl(5);
                                int zzd7 = this.zzc.zzd(3);
                                int i18 = this.zzo;
                                byte[] bArr = {(byte) (((i18 >> 1) & 7) | 16), (byte) (((zzd7 << 3) & 120) | ((i18 << 7) & 128))};
                                zzzt zza2 = zzzu.zza(bArr);
                                zzak zzak = new zzak();
                                zzak.zzH(this.zzf);
                                zzak.zzS("audio/mp4a-latm");
                                zzak.zzx(zza2.zzc);
                                zzak.zzw(zza2.zzb);
                                zzak.zzT(zza2.zza);
                                zzak.zzI(Collections.singletonList(bArr));
                                zzak.zzK(this.zze);
                                zzam zzY = zzak.zzY();
                                this.zzr = 1024000000 / ((long) zzY.zzA);
                                this.zzg.zzk(zzY);
                                this.zzq = true;
                            } else {
                                this.zzc.zzl(10);
                            }
                            this.zzc.zzl(4);
                            int zzd8 = this.zzc.zzd(13) - 7;
                            if (this.zzl) {
                                zzd8 -= 2;
                            }
                            zzj(this.zzg, this.zzr, 0, zzd8);
                        }
                    }
                } else if (zzk(zzfa2, this.zzd.zzH(), 10)) {
                    this.zzh.zzq(this.zzd, 10);
                    this.zzd.zzF(6);
                    zzj(this.zzh, 0, 10, 10 + this.zzd.zzj());
                }
            } else if (zzfa.zza() != 0) {
                zzez zzez = this.zzc;
                zzez.zza[0] = zzfa.zzH()[zzfa.zzc()];
                zzez.zzj(2);
                int zzd9 = this.zzc.zzd(4);
                int i19 = this.zzo;
                if (i19 == -1 || zzd9 == i19) {
                    if (!this.zzm) {
                        this.zzm = true;
                        this.zzn = this.zzp;
                        this.zzo = zzd9;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        zzajv.zzc();
        this.zzf = zzajv.zzb();
        zzabz zzv2 = zzaaz.zzv(zzajv.zza(), 1);
        this.zzg = zzv2;
        this.zzu = zzv2;
        if (this.zzb) {
            zzajv.zzc();
            zzabz zzv3 = zzaaz.zzv(zzajv.zza(), 5);
            this.zzh = zzv3;
            zzak zzak = new zzak();
            zzak.zzH(zzajv.zzb());
            zzak.zzS("application/id3");
            zzv3.zzk(zzak.zzY());
            return;
        }
        this.zzh = new zzaav();
    }

    public final void zzc() {
    }

    public final void zzd(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.zzt = j2;
        }
    }

    public final void zze() {
        this.zzt = -9223372036854775807L;
        zzg();
    }
}
