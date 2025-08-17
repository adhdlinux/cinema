package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbon implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationAppOpenAdCallback {
    private final zzboc zza;

    public zzbon(zzboc zzboc) {
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

    public final void onAdLeftApplication() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
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

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onVideoComplete.");
        try {
            this.zza.zzu();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onVideoPause.");
        try {
            this.zza.zzw();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onVideoPlay() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbzr.zze("Adapter called onVideoPlay.");
        try {
            this.zza.zzx();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onVideoUnmute() {
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
