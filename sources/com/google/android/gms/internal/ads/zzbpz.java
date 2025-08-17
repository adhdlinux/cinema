package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

final class zzbpz implements MediationAdLoadCallback {
    final /* synthetic */ zzbph zza;
    final /* synthetic */ zzboc zzb;

    zzbpz(zzbqf zzbqf, zzbph zzbph, zzboc zzboc) {
        this.zza = zzbph;
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
        MediationInterscrollerAd mediationInterscrollerAd = (MediationInterscrollerAd) obj;
        if (mediationInterscrollerAd == null) {
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
                this.zza.zzh(new zzbox(mediationInterscrollerAd));
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
