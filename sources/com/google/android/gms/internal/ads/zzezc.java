package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

final class zzezc implements OnAdMetadataChangedListener {
    final /* synthetic */ zzdd zza;
    final /* synthetic */ zzeze zzb;

    zzezc(zzeze zzeze, zzdd zzdd) {
        this.zzb = zzeze;
        this.zza = zzdd;
    }

    public final void onAdMetadataChanged() {
        if (this.zzb.zzi != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
