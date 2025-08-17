package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbgy extends zzbgb {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zza;

    public zzbgy(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzbu zzbu, IObjectWrapper iObjectWrapper) {
        AdListener adListener;
        if (zzbu != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzbu.zzi() instanceof zzg) {
                    zzg zzg = (zzg) zzbu.zzi();
                    if (zzg != null) {
                        adListener = zzg.zzb();
                    } else {
                        adListener = null;
                    }
                    adManagerAdView.setAdListener(adListener);
                }
            } catch (RemoteException e2) {
                zzbzr.zzh("", e2);
            }
            try {
                if (zzbu.zzj() instanceof zzauo) {
                    zzauo zzauo = (zzauo) zzbu.zzj();
                    if (zzauo != null) {
                        appEventListener = zzauo.zzb();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e3) {
                zzbzr.zzh("", e3);
            }
            zzbzk.zza.post(new zzbgx(this, adManagerAdView, zzbu));
        }
    }
}
