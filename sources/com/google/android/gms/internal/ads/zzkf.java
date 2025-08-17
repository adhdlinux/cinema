package com.google.android.gms.internal.ads;

public final class zzkf {
    public zzlc zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzkf(zzlc zzlc) {
        this.zza = zzlc;
    }

    public final void zza(int i2) {
        boolean z2 = true;
        if (true != (this.zzg | i2)) {
            z2 = false;
        }
        this.zzg = z2;
        this.zzb += i2;
    }

    public final void zzb(int i2) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i2;
    }

    public final void zzc(zzlc zzlc) {
        this.zzg |= this.zza != zzlc;
        this.zza = zzlc;
    }

    public final void zzd(int i2) {
        boolean z2 = true;
        if (!this.zzc || this.zzd == 5) {
            this.zzg = true;
            this.zzc = true;
            this.zzd = i2;
            return;
        }
        if (i2 != 5) {
            z2 = false;
        }
        zzdy.zzd(z2);
    }
}
