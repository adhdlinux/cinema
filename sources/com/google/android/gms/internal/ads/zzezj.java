package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

final class zzezj implements OnAdMetadataChangedListener {
    final /* synthetic */ zzby zza;
    final /* synthetic */ zzezk zzb;

    zzezj(zzezk zzezk, zzby zzby) {
        this.zzb = zzezk;
        this.zza = zzby;
    }

    public final void onAdMetadataChanged() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
