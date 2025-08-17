package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzblb extends AdManagerInterstitialAd {
    private final Context zza;
    private final zzp zzb = zzp.zza;
    private final zzbu zzc;
    private final String zzd;
    private final zzbnt zze;
    private AppEventListener zzf;
    private FullScreenContentCallback zzg;
    private OnPaidEventListener zzh;

    public zzblb(Context context, String str) {
        zzbnt zzbnt = new zzbnt();
        this.zze = zzbnt;
        this.zza = context;
        this.zzd = str;
        this.zzc = zzay.zza().zze(context, new zzq(), str, zzbnt);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzf;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzh;
    }

    public final ResponseInfo getResponseInfo() {
        zzdn zzdn = null;
        try {
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                zzdn = zzbu.zzk();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zzb(zzdn);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        zzauo zzauo;
        try {
            this.zzf = appEventListener;
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                if (appEventListener != null) {
                    zzauo = new zzauo(appEventListener);
                } else {
                    zzauo = null;
                }
                zzbu.zzG(zzauo);
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzg = fullScreenContentCallback;
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                zzbu.zzJ(new zzbb(fullScreenContentCallback));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setImmersiveMode(boolean z2) {
        try {
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                zzbu.zzL(z2);
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzh = onPaidEventListener;
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                zzbu.zzP(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void show(Activity activity) {
        if (activity == null) {
            zzbzr.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                zzbu.zzW(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzdx zzdx, AdLoadCallback adLoadCallback) {
        try {
            zzbu zzbu = this.zzc;
            if (zzbu != null) {
                zzbu.zzy(this.zzb.zza(this.zza, zzdx), new zzh(adLoadCallback, this));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }
}
