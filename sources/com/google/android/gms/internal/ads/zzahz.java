package com.google.android.gms.internal.ads;

public final class zzahz implements zzaij {
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

    public zzahz() {
        this((String) null);
    }

    public final void zza(zzfa zzfa) {
        boolean z2;
        boolean z3;
        zzdy.zzb(this.zze);
        while (zzfa.zza() > 0) {
            int i2 = this.zzf;
            if (i2 == 0) {
                while (true) {
                    if (zzfa.zza() <= 0) {
                        break;
                    } else if (!this.zzh) {
                        if (zzfa.zzk() == 11) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.zzh = z3;
                    } else {
                        int zzk2 = zzfa.zzk();
                        if (zzk2 == 119) {
                            this.zzh = false;
                            this.zzf = 1;
                            zzfa zzfa2 = this.zzb;
                            zzfa2.zzH()[0] = 11;
                            zzfa2.zzH()[1] = 119;
                            this.zzg = 2;
                            break;
                        }
                        if (zzk2 == 11) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.zzh = z2;
                    }
                }
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
                byte[] zzH = this.zzb.zzH();
                int min2 = Math.min(zzfa.zza(), 128 - this.zzg);
                zzfa.zzB(zzH, this.zzg, min2);
                int i5 = this.zzg + min2;
                this.zzg = i5;
                if (i5 == 128) {
                    this.zza.zzj(0);
                    zzzw zze2 = zzzx.zze(this.zza);
                    zzam zzam = this.zzj;
                    if (zzam == null || zze2.zzc != zzam.zzz || zze2.zzb != zzam.zzA || !zzfj.zzC(zze2.zza, zzam.zzm)) {
                        zzak zzak = new zzak();
                        zzak.zzH(this.zzd);
                        zzak.zzS(zze2.zza);
                        zzak.zzw(zze2.zzc);
                        zzak.zzT(zze2.zzb);
                        zzak.zzK(this.zzc);
                        zzak.zzO(zze2.zzf);
                        if ("audio/ac3".equals(zze2.zza)) {
                            zzak.zzv(zze2.zzf);
                        }
                        zzam zzY = zzak.zzY();
                        this.zzj = zzY;
                        this.zze.zzk(zzY);
                    }
                    this.zzk = zze2.zzd;
                    this.zzi = (((long) zze2.zze) * 1000000) / ((long) this.zzj.zzA);
                    this.zzb.zzF(0);
                    this.zze.zzq(this.zzb, 128);
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

    public zzahz(String str) {
        zzez zzez = new zzez(new byte[128], 128);
        this.zza = zzez;
        this.zzb = new zzfa(zzez.zza);
        this.zzf = 0;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
