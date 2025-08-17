package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;

public final class zzdma extends zzdlk implements zzdcu {
    private zzdcu zza;

    /* access modifiers changed from: protected */
    public final synchronized void zzi(zza zza2, zzbhc zzbhc, zzo zzo, zzbhe zzbhe, zzz zzz, zzdcu zzdcu) {
        super.zzh(zza2, zzbhc, zzo, zzbhe, zzz);
        this.zza = zzdcu;
    }

    public final synchronized void zzr() {
        zzdcu zzdcu = this.zza;
        if (zzdcu != null) {
            zzdcu.zzr();
        }
    }

    public final synchronized void zzs() {
        zzdcu zzdcu = this.zza;
        if (zzdcu != null) {
            zzdcu.zzs();
        }
    }
}
