package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbkc implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcaj zza;
    final /* synthetic */ zzbke zzb;

    zzbkc(zzbke zzbke, zzcaj zzcaj) {
        this.zzb = zzbke;
        this.zza = zzcaj;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzd(this.zzb.zza.zzp());
        } catch (DeadObjectException e2) {
            this.zza.zze(e2);
        }
    }

    public final void onConnectionSuspended(int i2) {
        zzcaj zzcaj = this.zza;
        zzcaj.zze(new RuntimeException("onConnectionSuspended: " + i2));
    }
}
