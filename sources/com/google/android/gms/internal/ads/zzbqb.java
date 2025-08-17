package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class zzbqb implements MediationAdLoadCallback {
    final /* synthetic */ zzbpn zza;
    final /* synthetic */ zzboc zzb;

    zzbqb(zzbqf zzbqf, zzbpn zzbpn, zzboc zzboc) {
        this.zza = zzbpn;
        this.zzb = zzboc;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        UnifiedNativeAdMapper unifiedNativeAdMapper = (UnifiedNativeAdMapper) obj;
        if (unifiedNativeAdMapper == null) {
            zzbzr.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zze("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzbzr.zzh("", e2);
                return null;
            }
        } else {
            try {
                this.zza.zzg(new zzbpb(unifiedNativeAdMapper));
            } catch (RemoteException e3) {
                zzbzr.zzh("", e3);
            }
            return new zzbqg(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }
}
