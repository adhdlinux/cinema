package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzx;
import java.util.Map;

final class zzbir implements zzx {
    boolean zza = false;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zza zzc;
    final /* synthetic */ Map zzd;
    final /* synthetic */ Map zze;

    zzbir(zzbit zzbit, boolean z2, zza zza2, Map map, Map map2) {
        this.zzb = z2;
        this.zzc = zza2;
        this.zzd = map;
        this.zze = map2;
    }

    public final void zza(boolean z2) {
        if (!this.zza) {
            if (z2 && this.zzb) {
                ((zzdcu) this.zzc).zzr();
            }
            this.zza = true;
            this.zzd.put((String) this.zze.get("event_id"), Boolean.valueOf(z2));
            ((zzblc) this.zzc).zzd("openIntentAsync", this.zzd);
        }
    }

    public final void zzb(int i2) {
    }
}
