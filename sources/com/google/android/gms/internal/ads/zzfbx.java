package com.google.android.gms.internal.ads;

final class zzfbx {
    private final zzfbw zza = new zzfbw();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    zzfbx() {
    }

    public final zzfbw zza() {
        zzfbw zza2 = this.zza.clone();
        zzfbw zzfbw = this.zza;
        zzfbw.zza = false;
        zzfbw.zzb = false;
        return zza2;
    }

    public final String zzb() {
        return "\n\tPool does not exist: " + this.zzd + "\n\tNew pools created: " + this.zzb + "\n\tPools removed: " + this.zzc + "\n\tEntries added: " + this.zzf + "\n\tNo entries retrieved: " + this.zze + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
    }

    public final void zzc() {
        this.zzf++;
    }

    public final void zzd() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zze() {
        this.zze++;
    }

    public final void zzf() {
        this.zzd++;
    }

    public final void zzg() {
        this.zzc++;
        this.zza.zzb = true;
    }
}
