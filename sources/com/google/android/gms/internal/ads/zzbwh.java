package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzfd;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbwh extends RewardedInterstitialAd {
    private final String zza;
    private final zzbvn zzb;
    private final Context zzc;
    private final zzbwf zzd = new zzbwf();
    private FullScreenContentCallback zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;

    public zzbwh(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = zzay.zza().zzq(context, str, new zzbnt());
    }

    public final Bundle getAdMetadata() {
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                return zzbvn.zzb();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final ResponseInfo getResponseInfo() {
        zzdn zzdn = null;
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzdn = zzbvn.zzc();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zzb(zzdn);
    }

    public final RewardItem getRewardItem() {
        zzbvk zzbvk;
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvk = zzbvn.zzd();
            } else {
                zzbvk = null;
            }
            if (zzbvk != null) {
                return new zzbvx(zzbvk);
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z2) {
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzh(z2);
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzi(new zzfd(onAdMetadataChangedListener));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzj(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzl(new zzbwb(serverSideVerificationOptions));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzdx zzdx, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzg(zzp.zza.zza(this.zzc, zzdx), new zzbwg(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
