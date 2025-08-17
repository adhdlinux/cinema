package com.google.android.gms.internal.ads;

public final class zzaja implements zzajw {
    private final zzaij zza;
    private final zzez zzb = new zzez(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfh zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaja(zzaij zzaij) {
        this.zza = zzaij;
    }

    private final void zzd(int i2) {
        this.zzc = i2;
        this.zzd = 0;
    }

    private final boolean zze(zzfa zzfa, byte[] bArr, int i2) {
        int min = Math.min(zzfa.zza(), i2 - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfa.zzG(min);
        } else {
            zzfa.zzB(bArr, this.zzd, min);
        }
        int i3 = this.zzd + min;
        this.zzd = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public final void zza(zzfa zzfa, int i2) throws zzcd {
        long j2;
        int i3;
        int i4;
        zzfa zzfa2 = zzfa;
        zzdy.zzb(this.zze);
        int i5 = -1;
        int i6 = 2;
        int i7 = 1;
        if ((i2 & 1) != 0) {
            int i8 = this.zzc;
            if (!(i8 == 0 || i8 == 1)) {
                if (i8 != 2) {
                    int i9 = this.zzj;
                    if (i9 != -1) {
                        zzer.zzf("PesReader", "Unexpected start indicator: expected " + i9 + " more bytes");
                    }
                    this.zza.zzc();
                } else {
                    zzer.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i10 = i2;
        while (zzfa.zza() > 0) {
            int i11 = this.zzc;
            if (i11 != 0) {
                int i12 = 0;
                if (i11 != i7) {
                    if (i11 != i6) {
                        int zza2 = zzfa.zza();
                        int i13 = this.zzj;
                        if (i13 != i5) {
                            i12 = zza2 - i13;
                        }
                        if (i12 > 0) {
                            zza2 -= i12;
                            zzfa2.zzE(zzfa.zzc() + zza2);
                        }
                        this.zza.zza(zzfa2);
                        int i14 = this.zzj;
                        if (i14 != i5) {
                            int i15 = i14 - zza2;
                            this.zzj = i15;
                            if (i15 == 0) {
                                this.zza.zzc();
                                zzd(i7);
                            }
                        }
                    } else {
                        if (zze(zzfa2, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfa2, (byte[]) null, this.zzi)) {
                            this.zzb.zzj(0);
                            if (this.zzf) {
                                this.zzb.zzl(4);
                                long zzd2 = (long) this.zzb.zzd(3);
                                this.zzb.zzl(i7);
                                int zzd3 = this.zzb.zzd(15) << 15;
                                this.zzb.zzl(i7);
                                long zzd4 = (long) this.zzb.zzd(15);
                                this.zzb.zzl(i7);
                                if (this.zzh || !this.zzg) {
                                    i4 = zzd3;
                                } else {
                                    this.zzb.zzl(4);
                                    this.zzb.zzl(i7);
                                    this.zzb.zzl(i7);
                                    long zzd5 = (long) this.zzb.zzd(15);
                                    this.zzb.zzl(i7);
                                    i4 = zzd3;
                                    this.zze.zzb((((long) this.zzb.zzd(3)) << 30) | ((long) (this.zzb.zzd(15) << 15)) | zzd5);
                                    this.zzh = true;
                                }
                                j2 = this.zze.zzb((zzd2 << 30) | ((long) i4) | zzd4);
                            } else {
                                j2 = -9223372036854775807L;
                            }
                            if (true != this.zzk) {
                                i3 = 0;
                            } else {
                                i3 = 4;
                            }
                            i10 |= i3;
                            this.zza.zzd(j2, i10);
                            zzd(3);
                            i5 = -1;
                            i6 = 2;
                            i7 = 1;
                        }
                    }
                } else if (zze(zzfa2, this.zzb.zza, 9)) {
                    int i16 = 0;
                    this.zzb.zzj(0);
                    int zzd6 = this.zzb.zzd(24);
                    i7 = 1;
                    if (zzd6 != 1) {
                        zzer.zzf("PesReader", "Unexpected start code prefix: " + zzd6);
                        i5 = -1;
                        this.zzj = -1;
                    } else {
                        this.zzb.zzl(8);
                        int zzd7 = this.zzb.zzd(16);
                        this.zzb.zzl(5);
                        this.zzk = this.zzb.zzn();
                        this.zzb.zzl(2);
                        this.zzf = this.zzb.zzn();
                        this.zzg = this.zzb.zzn();
                        this.zzb.zzl(6);
                        int zzd8 = this.zzb.zzd(8);
                        this.zzi = zzd8;
                        if (zzd7 == 0) {
                            this.zzj = -1;
                        } else {
                            int i17 = (zzd7 - 3) - zzd8;
                            this.zzj = i17;
                            if (i17 < 0) {
                                zzer.zzf("PesReader", "Found negative packet payload size: " + i17);
                                i5 = -1;
                                this.zzj = -1;
                                i16 = 2;
                            }
                        }
                        i5 = -1;
                        i16 = 2;
                    }
                    zzd(i16);
                } else {
                    i5 = -1;
                    i7 = 1;
                }
            } else {
                zzfa2.zzG(zzfa.zza());
            }
            i6 = 2;
        }
    }

    public final void zzb(zzfh zzfh, zzaaz zzaaz, zzajv zzajv) {
        this.zze = zzfh;
        this.zza.zzb(zzaaz, zzajv);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
