package com.google.android.gms.internal.ads;

public final class zzajj implements zzajw {
    private final zzaji zza;
    private final zzfa zzb = new zzfa(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzajj(zzaji zzaji) {
        this.zza = zzaji;
    }

    public final void zza(zzfa zzfa, int i2) {
        int i3;
        boolean z2;
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = zzfa.zzc() + zzfa.zzk();
        } else {
            i3 = -1;
        }
        if (this.zzf) {
            if (i4 != 0) {
                this.zzf = false;
                zzfa.zzF(i3);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzfa.zza() > 0) {
            int i5 = this.zzd;
            if (i5 < 3) {
                if (i5 == 0) {
                    int zzk = zzfa.zzk();
                    zzfa.zzF(zzfa.zzc() - 1);
                    if (zzk == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int min = Math.min(zzfa.zza(), 3 - this.zzd);
                zzfa.zzB(this.zzb.zzH(), this.zzd, min);
                int i6 = this.zzd + min;
                this.zzd = i6;
                if (i6 == 3) {
                    this.zzb.zzF(0);
                    this.zzb.zzE(3);
                    this.zzb.zzG(1);
                    int zzk2 = this.zzb.zzk();
                    int zzk3 = this.zzb.zzk();
                    if ((zzk2 & 128) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.zze = z2;
                    this.zzc = (((zzk2 & 15) << 8) | zzk3) + 3;
                    int zzb2 = this.zzb.zzb();
                    int i7 = this.zzc;
                    if (zzb2 < i7) {
                        int zzb3 = this.zzb.zzb();
                        this.zzb.zzz(Math.min(4098, Math.max(i7, zzb3 + zzb3)));
                    }
                }
            } else {
                int min2 = Math.min(zzfa.zza(), this.zzc - i5);
                zzfa.zzB(this.zzb.zzH(), this.zzd, min2);
                int i8 = this.zzd + min2;
                this.zzd = i8;
                int i9 = this.zzc;
                if (i8 != i9) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzE(i9);
                    } else if (zzfj.zzd(this.zzb.zzH(), 0, i9, -1) != 0) {
                        this.zzf = true;
                        return;
                    } else {
                        this.zzb.zzE(this.zzc - 4);
                    }
                    this.zzb.zzF(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    public final void zzb(zzfh zzfh, zzaaz zzaaz, zzajv zzajv) {
        this.zza.zzb(zzfh, zzaaz, zzajv);
        this.zzf = true;
    }

    public final void zzc() {
        this.zzf = true;
    }
}
