package com.google.android.gms.internal.ads;

public final class zzaic implements zzaij {
    private final zzez zza;
    private final zzfa zzb;
    private final String zzc;
    private String zzd;
    private zzabz zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzam zzj;
    private int zzk;
    private long zzl;

    public zzaic() {
        this((String) null);
    }

    public final void zza(zzfa zzfa) {
        int zzk2;
        boolean z2;
        byte b2;
        boolean z3;
        zzdy.zzb(this.zze);
        while (zzfa.zza() > 0) {
            int i2 = this.zzf;
            if (i2 == 0) {
                while (true) {
                    if (zzfa.zza() <= 0) {
                        break;
                    } else if (!this.zzh) {
                        if (zzfa.zzk() == 172) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.zzh = z3;
                    } else {
                        zzk2 = zzfa.zzk();
                        if (zzk2 == 172) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.zzh = z2;
                        b2 = 64;
                        if (zzk2 == 64) {
                            break;
                        } else if (zzk2 == 65) {
                            zzk2 = 65;
                            break;
                        }
                    }
                }
                this.zzf = 1;
                zzfa zzfa2 = this.zzb;
                zzfa2.zzH()[0] = -84;
                byte[] zzH = zzfa2.zzH();
                if (zzk2 == 65) {
                    b2 = 65;
                }
                zzH[1] = b2;
                this.zzg = 2;
            } else if (i2 != 1) {
                int min = Math.min(zzfa.zza(), this.zzk - this.zzg);
                this.zze.zzq(zzfa, min);
                int i3 = this.zzg + min;
                this.zzg = i3;
                int i4 = this.zzk;
                if (i3 == i4) {
                    long j2 = this.zzl;
                    if (j2 != -9223372036854775807L) {
                        this.zze.zzs(j2, 1, i4, 0, (zzaby) null);
                        this.zzl += this.zzi;
                    }
                    this.zzf = 0;
                }
            } else {
                byte[] zzH2 = this.zzb.zzH();
                int min2 = Math.min(zzfa.zza(), 16 - this.zzg);
                zzfa.zzB(zzH2, this.zzg, min2);
                int i5 = this.zzg + min2;
                this.zzg = i5;
                if (i5 == 16) {
                    this.zza.zzj(0);
                    zzzz zza2 = zzaaa.zza(this.zza);
                    zzam zzam = this.zzj;
                    if (zzam == null || zzam.zzz != 2 || zza2.zza != zzam.zzA || !"audio/ac4".equals(zzam.zzm)) {
                        zzak zzak = new zzak();
                        zzak.zzH(this.zzd);
                        zzak.zzS("audio/ac4");
                        zzak.zzw(2);
                        zzak.zzT(zza2.zza);
                        zzak.zzK(this.zzc);
                        zzam zzY = zzak.zzY();
                        this.zzj = zzY;
                        this.zze.zzk(zzY);
                    }
                    this.zzk = zza2.zzb;
                    this.zzi = (((long) zza2.zzc) * 1000000) / ((long) this.zzj.zzA);
                    this.zzb.zzF(0);
                    this.zze.zzq(this.zzb, 16);
                    this.zzf = 2;
                }
            }
        }
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        zzajv.zzc();
        this.zzd = zzajv.zzb();
        this.zze = zzaaz.zzv(zzajv.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.zzl = j2;
        }
    }

    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public zzaic(String str) {
        zzez zzez = new zzez(new byte[16], 16);
        this.zza = zzez;
        this.zzb = new zzfa(zzez.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
