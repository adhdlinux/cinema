package com.google.android.gms.internal.ads;

public final class zzcj {
    private final zzaf zza = new zzaf();

    public final zzcj zza(int i2) {
        this.zza.zza(i2);
        return this;
    }

    public final zzcj zzb(zzcl zzcl) {
        zzaf zzaf = this.zza;
        zzah zza2 = zzcl.zzd;
        for (int i2 = 0; i2 < zza2.zzb(); i2++) {
            zzaf.zza(zza2.zza(i2));
        }
        return this;
    }

    public final zzcj zzc(int... iArr) {
        zzaf zzaf = this.zza;
        for (int i2 = 0; i2 < 19; i2++) {
            zzaf.zza(iArr[i2]);
        }
        return this;
    }

    public final zzcj zzd(int i2, boolean z2) {
        zzaf zzaf = this.zza;
        if (z2) {
            zzaf.zza(i2);
        }
        return this;
    }

    public final zzcl zze() {
        return new zzcl(this.zza.zzb(), (zzck) null);
    }
}
