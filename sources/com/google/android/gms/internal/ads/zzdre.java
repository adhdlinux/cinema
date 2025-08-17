package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.vungle.ads.internal.Constants;

public final class zzdre {
    private final zzbjg zza;

    zzdre(zzbjg zzbjg) {
        this.zza = zzbjg;
    }

    private final void zzs(zzdrd zzdrd) throws RemoteException {
        String zza2 = zzdrd.zza(zzdrd);
        zzbzr.zzi("Dispatching AFMA event on publisher webview: ".concat(zza2));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdrd(MobileAdsBridgeBase.initializeMethodName, (zzdrc) null));
    }

    public final void zzb(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_INTERSTITIAL, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdClicked";
        this.zza.zzb(zzdrd.zza(zzdrd));
    }

    public final void zzc(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_INTERSTITIAL, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdClosed";
        zzs(zzdrd);
    }

    public final void zzd(long j2, int i2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_INTERSTITIAL, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdFailedToLoad";
        zzdrd.zzd = Integer.valueOf(i2);
        zzs(zzdrd);
    }

    public final void zze(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_INTERSTITIAL, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdLoaded";
        zzs(zzdrd);
    }

    public final void zzf(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_INTERSTITIAL, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdrd);
    }

    public final void zzg(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_INTERSTITIAL, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdOpened";
        zzs(zzdrd);
    }

    public final void zzh(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd("creation", (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "nativeObjectCreated";
        zzs(zzdrd);
    }

    public final void zzi(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd("creation", (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "nativeObjectNotCreated";
        zzs(zzdrd);
    }

    public final void zzj(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdClicked";
        zzs(zzdrd);
    }

    public final void zzk(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onRewardedAdClosed";
        zzs(zzdrd);
    }

    public final void zzl(long j2, zzbvk zzbvk) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onUserEarnedReward";
        zzdrd.zze = zzbvk.zzf();
        zzdrd.zzf = Integer.valueOf(zzbvk.zze());
        zzs(zzdrd);
    }

    public final void zzm(long j2, int i2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onRewardedAdFailedToLoad";
        zzdrd.zzd = Integer.valueOf(i2);
        zzs(zzdrd);
    }

    public final void zzn(long j2, int i2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onRewardedAdFailedToShow";
        zzdrd.zzd = Integer.valueOf(i2);
        zzs(zzdrd);
    }

    public final void zzo(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onAdImpression";
        zzs(zzdrd);
    }

    public final void zzp(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onRewardedAdLoaded";
        zzs(zzdrd);
    }

    public final void zzq(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdrd);
    }

    public final void zzr(long j2) throws RemoteException {
        zzdrd zzdrd = new zzdrd(Constants.PLACEMENT_TYPE_REWARDED, (zzdrc) null);
        zzdrd.zza = Long.valueOf(j2);
        zzdrd.zzc = "onRewardedAdOpened";
        zzs(zzdrd);
    }
}
