package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

final class zzbop implements MediationAdLoadCallback {
    final /* synthetic */ zzboc zza;
    final /* synthetic */ Adapter zzb;
    final /* synthetic */ zzbow zzc;

    zzbop(zzbow zzbow, zzboc zzboc, Adapter adapter) {
        this.zzc = zzbow;
        this.zza = zzboc;
        this.zzb = adapter;
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            zzbzr.zze(canonicalName + "failed to load mediation ad: ErrorCode = " + code + ". ErrorMessage = " + message + ". ErrorDomain = " + domain);
            this.zza.zzh(adError.zza());
            this.zza.zzi(adError.getCode(), adError.getMessage());
            this.zza.zzg(adError.getCode());
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        try {
            this.zzc.zzi = (MediationInterscrollerAd) obj;
            this.zza.zzo();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
        return new zzbon(this.zza);
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }
}
