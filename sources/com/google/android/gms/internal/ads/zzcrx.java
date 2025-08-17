package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcrx implements zzo {
    private final zzcwn zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzcrx(zzcwn zzcwn) {
        this.zza = zzcwn;
    }

    private final void zzh() {
        if (!this.zzc.get()) {
            this.zzc.set(true);
            this.zza.zza();
        }
    }

    public final void zzb() {
        this.zza.zzc();
    }

    public final void zzbF() {
    }

    public final void zzbo() {
    }

    public final void zzby() {
        zzh();
    }

    public final void zze() {
    }

    public final void zzf(int i2) {
        this.zzb.set(true);
        zzh();
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
