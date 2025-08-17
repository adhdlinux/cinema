package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzlp implements zzkl {
    private final zzdz zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzch zze = zzch.zza;

    public zzlp(zzdz zzdz) {
        this.zza = zzdz;
    }

    public final long zza() {
        long j2;
        long j3 = this.zzc;
        if (!this.zzb) {
            return j3;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzch zzch = this.zze;
        if (zzch.zzc == 1.0f) {
            j2 = zzfj.zzo(elapsedRealtime);
        } else {
            j2 = zzch.zza(elapsedRealtime);
        }
        return j3 + j2;
    }

    public final void zzb(long j2) {
        this.zzc = j2;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    public final zzch zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    public final void zzg(zzch zzch) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzch;
    }
}
