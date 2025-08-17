package com.google.android.gms.cast.internal;

final class zzam implements zzat {
    final /* synthetic */ zzat zza;
    final /* synthetic */ zzaq zzb;

    zzam(zzaq zzaq, zzat zzat) {
        this.zzb = zzaq;
        this.zza = zzat;
    }

    public final void zza(long j2, int i2, Object obj) {
        if (this.zza != null) {
            if (i2 == 2001) {
                zzaq zzaq = this.zzb;
                zzaq.zza.w("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", Integer.valueOf(zzaq.zzz));
                this.zzb.zzy.zzl();
                i2 = 2001;
            }
            this.zza.zza(j2, i2, obj);
        }
    }

    public final void zzb(long j2) {
        zzat zzat = this.zza;
        if (zzat != null) {
            zzat.zzb(j2);
        }
    }
}
