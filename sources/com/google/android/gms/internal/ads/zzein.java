package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzein extends zzbt {
    private final Context zza;
    private final zzbh zzb;
    private final zzfai zzc;
    private final zzcpb zzd;
    private final ViewGroup zze;
    private final zzdqa zzf;

    public zzein(Context context, zzbh zzbh, zzfai zzfai, zzcpb zzcpb, zzdqa zzdqa) {
        this.zza = context;
        this.zzb = zzbh;
        this.zzc = zzfai;
        this.zzd = zzcpb;
        this.zzf = zzdqa;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        View zzc2 = zzcpb.zzc();
        zzt.zzp();
        frameLayout.addView(zzc2, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzg().zzc);
        frameLayout.setMinimumWidth(zzg().zzf);
        this.zze = frameLayout;
    }

    public final void zzA() throws RemoteException {
        this.zzd.zzg();
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzm().zzc((Context) null);
    }

    public final void zzC(zzbe zzbe) throws RemoteException {
        zzbzr.zzi("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzD(zzbh zzbh) throws RemoteException {
        zzbzr.zzi("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzE(zzby zzby) throws RemoteException {
        zzbzr.zzi("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzF(zzq zzq) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzcpb zzcpb = this.zzd;
        if (zzcpb != null) {
            zzcpb.zzh(this.zze, zzq);
        }
    }

    public final void zzG(zzcb zzcb) throws RemoteException {
        zzejm zzejm = this.zzc.zzc;
        if (zzejm != null) {
            zzejm.zzi(zzcb);
        }
    }

    public final void zzH(zzavw zzavw) throws RemoteException {
    }

    public final void zzI(zzw zzw) throws RemoteException {
    }

    public final void zzJ(zzci zzci) {
    }

    public final void zzK(zzdu zzdu) throws RemoteException {
    }

    public final void zzL(boolean z2) throws RemoteException {
    }

    public final void zzM(zzbsc zzbsc) throws RemoteException {
    }

    public final void zzN(boolean z2) throws RemoteException {
        zzbzr.zzi("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzO(zzbck zzbck) throws RemoteException {
        zzbzr.zzi("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzP(zzdg zzdg) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjW)).booleanValue()) {
            zzejm zzejm = this.zzc.zzc;
            if (zzejm != null) {
                try {
                    if (!zzdg.zzf()) {
                        this.zzf.zze();
                    }
                } catch (RemoteException e2) {
                    zzbzr.zzf("Error in making CSI ping for reporting paid event callback", e2);
                }
                zzejm.zzg(zzdg);
                return;
            }
            return;
        }
        zzbzr.zzi("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzQ(zzbsf zzbsf, String str) throws RemoteException {
    }

    public final void zzR(String str) throws RemoteException {
    }

    public final void zzS(zzbva zzbva) throws RemoteException {
    }

    public final void zzT(String str) throws RemoteException {
    }

    public final void zzU(zzfl zzfl) throws RemoteException {
        zzbzr.zzi("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
    }

    public final boolean zzY() throws RemoteException {
        return false;
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa(zzl zzl) throws RemoteException {
        zzbzr.zzi("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzab(zzcf zzcf) throws RemoteException {
        zzbzr.zzi("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzd() throws RemoteException {
        zzbzr.zzi("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final zzq zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzfam.zza(this.zza, Collections.singletonList(this.zzd.zze()));
    }

    public final zzbh zzi() throws RemoteException {
        return this.zzb;
    }

    public final zzcb zzj() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzdn zzk() {
        return this.zzd.zzl();
    }

    public final zzdq zzl() throws RemoteException {
        return this.zzd.zzd();
    }

    public final IObjectWrapper zzn() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    public final String zzr() throws RemoteException {
        return this.zzc.zzf;
    }

    public final String zzs() throws RemoteException {
        if (this.zzd.zzl() != null) {
            return this.zzd.zzl().zzg();
        }
        return null;
    }

    public final String zzt() throws RemoteException {
        if (this.zzd.zzl() != null) {
            return this.zzd.zzl().zzg();
        }
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzb();
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzm().zzb((Context) null);
    }
}
