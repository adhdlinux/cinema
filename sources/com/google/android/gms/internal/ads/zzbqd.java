package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

final class zzbqd implements SignalCallbacks {
    final /* synthetic */ zzbpw zza;

    zzbqd(zzbqf zzbqf, zzbpw zzbpw) {
        this.zza = zzbpw;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }
}
