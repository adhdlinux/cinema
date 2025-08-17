package com.google.android.gms.internal.ads;

import com.google.protobuf.CodedOutputStream;

public final class zzaix implements zzaij {
    private final zzfa zza;
    private final zzabp zzb;
    private final String zzc;
    private zzabz zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzaix() {
        this((String) null);
    }

    public final void zza(zzfa zzfa) {
        boolean z2;
        boolean z3;
        zzdy.zzb(this.zzd);
        while (zzfa.zza() > 0) {
            int i2 = this.zzf;
            if (i2 == 0) {
                byte[] zzH = zzfa.zzH();
                int zzc2 = zzfa.zzc();
                int zzd2 = zzfa.zzd();
                while (true) {
                    if (zzc2 >= zzd2) {
                        zzfa.zzF(zzd2);
                        break;
                    }
                    byte b2 = zzH[zzc2];
                    if ((b2 & 255) == 255) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!this.zzi || (b2 & 224) != 224) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    this.zzi = z2;
                    if (z3) {
                        zzfa.zzF(zzc2 + 1);
                        this.zzi = false;
                        this.zza.zzH()[1] = zzH[zzc2];
                        this.zzg = 2;
                        this.zzf = 1;
                        break;
                    }
                    zzc2++;
                }
            } else if (i2 != 1) {
                int min = Math.min(zzfa.zza(), this.zzk - this.zzg);
                this.zzd.zzq(zzfa, min);
                int i3 = this.zzg + min;
                this.zzg = i3;
                int i4 = this.zzk;
                if (i3 >= i4) {
                    long j2 = this.zzl;
                    if (j2 != -9223372036854775807L) {
                        this.zzd.zzs(j2, 1, i4, 0, (zzaby) null);
                        this.zzl += this.zzj;
                    }
                    this.zzg = 0;
                    this.zzf = 0;
                }
            } else {
                int min2 = Math.min(zzfa.zza(), 4 - this.zzg);
                zzfa.zzB(this.zza.zzH(), this.zzg, min2);
                int i5 = this.zzg + min2;
                this.zzg = i5;
                if (i5 >= 4) {
                    this.zza.zzF(0);
                    if (!this.zzb.zza(this.zza.zze())) {
                        this.zzg = 0;
                        this.zzf = 1;
                    } else {
                        zzabp zzabp = this.zzb;
                        this.zzk = zzabp.zzc;
                        if (!this.zzh) {
                            this.zzj = (((long) zzabp.zzg) * 1000000) / ((long) zzabp.zzd);
                            zzak zzak = new zzak();
                            zzak.zzH(this.zze);
                            zzak.zzS(this.zzb.zzb);
                            zzak.zzL(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                            zzak.zzw(this.zzb.zze);
                            zzak.zzT(this.zzb.zzd);
                            zzak.zzK(this.zzc);
                            this.zzd.zzk(zzak.zzY());
                            this.zzh = true;
                        }
                        this.zza.zzF(0);
                        this.zzd.zzq(this.zza, 4);
                        this.zzf = 2;
                    }
                }
            }
        }
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        zzajv.zzc();
        this.zze = zzajv.zzb();
        this.zzd = zzaaz.zzv(zzajv.zza(), 1);
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
        this.zzi = false;
        this.zzl = -9223372036854775807L;
    }

    public zzaix(String str) {
        this.zzf = 0;
        zzfa zzfa = new zzfa(4);
        this.zza = zzfa;
        zzfa.zzH()[0] = -1;
        this.zzb = new zzabp();
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
