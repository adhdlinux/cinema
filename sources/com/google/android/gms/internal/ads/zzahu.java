package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

abstract class zzahu {
    private final zzahn zza = new zzahn();
    private zzabz zzb;
    private zzaaz zzc;
    private zzahp zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzahr zzj = new zzahr();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    /* access modifiers changed from: protected */
    public abstract long zza(zzfa zzfa);

    /* access modifiers changed from: protected */
    public void zzb(boolean z2) {
        int i2;
        if (z2) {
            this.zzj = new zzahr();
            this.zzf = 0;
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.zzh = i2;
        this.zze = -1;
        this.zzg = 0;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzfa zzfa, long j2, zzahr zzahr) throws IOException;

    /* access modifiers changed from: package-private */
    public final int zze(zzaax zzaax, zzabs zzabs) throws IOException {
        boolean z2;
        zzaax zzaax2 = zzaax;
        zzdy.zzb(this.zzb);
        int i2 = zzfj.zza;
        int i3 = this.zzh;
        if (i3 == 0) {
            while (this.zza.zze(zzaax2)) {
                long zzf2 = zzaax.zzf();
                long j2 = this.zzf;
                this.zzk = zzf2 - j2;
                if (zzc(this.zza.zza(), j2, this.zzj)) {
                    this.zzf = zzaax.zzf();
                } else {
                    zzam zzam = this.zzj.zza;
                    this.zzi = zzam.zzA;
                    if (!this.zzm) {
                        this.zzb.zzk(zzam);
                        this.zzm = true;
                    }
                    zzahp zzahp = this.zzj.zzb;
                    if (zzahp != null) {
                        this.zzd = zzahp;
                    } else if (zzaax.zzd() == -1) {
                        this.zzd = new zzaht((zzahs) null);
                    } else {
                        zzaho zzb2 = this.zza.zzb();
                        if ((zzb2.zza & 4) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.zzd = new zzahi(this, this.zzf, zzaax.zzd(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, z2);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                    return 0;
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i3 == 1) {
            ((zzaam) zzaax2).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        } else if (i3 != 2) {
            return -1;
        } else {
            long zzd2 = this.zzd.zzd(zzaax2);
            if (zzd2 >= 0) {
                zzabs.zza = zzd2;
                return 1;
            }
            if (zzd2 < -1) {
                zzi(-(zzd2 + 2));
            }
            if (!this.zzl) {
                zzabv zze2 = this.zzd.zze();
                zzdy.zzb(zze2);
                this.zzc.zzN(zze2);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zze(zzaax2)) {
                this.zzk = 0;
                zzfa zza2 = this.zza.zza();
                long zza3 = zza(zza2);
                if (zza3 >= 0) {
                    long j3 = this.zzg;
                    if (j3 + zza3 >= this.zze) {
                        long zzf3 = zzf(j3);
                        zzabx.zzb(this.zzb, zza2, zza2.zzd());
                        this.zzb.zzs(zzf3, 1, zza2.zzd(), 0, (zzaby) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zza3;
                return 0;
            }
            this.zzh = 3;
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public final long zzf(long j2) {
        return (j2 * 1000000) / ((long) this.zzi);
    }

    /* access modifiers changed from: protected */
    public final long zzg(long j2) {
        return (((long) this.zzi) * j2) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzaaz zzaaz, zzabz zzabz) {
        this.zzc = zzaaz;
        this.zzb = zzabz;
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzi(long j2) {
        this.zzg = j2;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(long j2, long j3) {
        this.zza.zzc();
        if (j2 == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            long zzg2 = zzg(j3);
            this.zze = zzg2;
            zzahp zzahp = this.zzd;
            int i2 = zzfj.zza;
            zzahp.zzg(zzg2);
            this.zzh = 2;
        }
    }
}
