package com.google.android.gms.internal.ads;

final class zzfob extends zzfnx {
    final /* synthetic */ zzfoh zza;

    zzfob(zzfoh zzfoh) {
        this.zza = zzfoh;
    }

    public final void zza() {
        synchronized (this.zza.zzg) {
            if (this.zza.zzl.get() > 0) {
                if (this.zza.zzl.decrementAndGet() > 0) {
                    this.zza.zzc.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            zzfoh zzfoh = this.zza;
            if (zzfoh.zzn != null) {
                zzfoh.zzc.zzc("Unbind from service.", new Object[0]);
                zzfoh zzfoh2 = this.zza;
                zzfoh2.zzb.unbindService(zzfoh2.zzm);
                this.zza.zzh = false;
                this.zza.zzn = null;
                this.zza.zzm = null;
            }
            this.zza.zzw();
        }
    }
}
