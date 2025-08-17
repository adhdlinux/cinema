package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbwd implements MediationRewardedAdCallback {
    private final zzboc zza;

    public zzbwd(zzboc zzboc) {
        this.zza = zzboc;
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        zzbzr.zzj("Mediation ad failed to show: Error Code = " + code + ". Error Message = " + message + " Error Domain = " + domain);
        try {
            this.zza.zzk(adError.zza());
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzt(new zzbwe(rewardItem));
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onVideoComplete.");
        try {
            this.zza.zzu();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onVideoStart.");
        try {
            this.zza.zzy();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called reportAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onAdFailedToShow.");
        zzbzr.zzj("Mediation ad failed to show: ".concat(String.valueOf(str)));
        try {
            this.zza.zzl(str);
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
