package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzawt implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzawl zza;
    final /* synthetic */ zzcaj zzb;
    final /* synthetic */ zzawv zzc;

    zzawt(zzawv zzawv, zzawl zzawl, zzcaj zzcaj) {
        this.zzc = zzawv;
        this.zza = zzawl;
        this.zzb = zzcaj;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzawv zzawv = this.zzc;
            if (!zzawv.zzb) {
                zzawv.zzb = true;
                zzawk zza2 = this.zzc.zza;
                if (zza2 != null) {
                    zzfwm zza3 = zzcae.zza.zza(new zzawq(this, zza2, this.zza, this.zzb));
                    zzcaj zzcaj = this.zzb;
                    zzcaj.zzc(new zzawr(zzcaj, zza3), zzcae.zzf);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i2) {
    }
}
