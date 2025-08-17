package com.google.android.gms.internal.ads;

public final class zzbmf extends zzcaq {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbmk zzb;
    private boolean zzc;

    public zzbmf(zzbmk zzbmk) {
        this.zzb = zzbmk;
    }

    public final void zzb() {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                zzi(new zzbmc(this), new zzcam());
                zzi(new zzbmd(this), new zzbme(this));
            }
        }
    }
}
