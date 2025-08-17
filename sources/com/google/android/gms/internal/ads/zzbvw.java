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
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbvw extends RewardedAd {
    private final String zza;
    private final zzbvn zzb;
    private final Context zzc;
    private final zzbwf zzd = new zzbwf();
    private OnAdMetadataChangedListener zze;
    private OnPaidEventListener zzf;
    private FullScreenContentCallback zzg;

    public zzbvw(Context context, String str) {
        this.zzc = context.getApplicationContext();
        this.zza = str;
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
        return this.zzg;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
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
            if (zzbvk == null) {
                return RewardItem.DEFAULT_REWARD;
            }
            return new zzbvx(zzbvk);
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            return RewardItem.DEFAULT_REWARD;
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
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
        try {
            this.zze = onAdMetadataChangedListener;
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzi(new zzfd(onAdMetadataChangedListener));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzj(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzbvn zzbvn = this.zzb;
                if (zzbvn != null) {
                    zzbvn.zzl(new zzbwb(serverSideVerificationOptions));
                }
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzbzr.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
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

    public final void zza(zzdx zzdx, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzbvn zzbvn = this.zzb;
            if (zzbvn != null) {
                zzbvn.zzf(zzp.zza.zza(this.zzc, zzdx), new zzbwa(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
