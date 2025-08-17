package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbvu;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbwb;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;

public final class zzfc extends zzbvm {
    private static void zzr(zzbvu zzbvu) {
        zzbzr.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbzk.zza.post(new zzfb(zzbvu));
    }

    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    public final zzdn zzc() {
        return null;
    }

    public final zzbvk zzd() {
        return null;
    }

    public final String zze() throws RemoteException {
        return "";
    }

    public final void zzf(zzl zzl, zzbvu zzbvu) throws RemoteException {
        zzr(zzbvu);
    }

    public final void zzg(zzl zzl, zzbvu zzbvu) throws RemoteException {
        zzr(zzbvu);
    }

    public final void zzh(boolean z2) {
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
    }

    public final void zzj(zzdg zzdg) {
    }

    public final void zzk(zzbvq zzbvq) throws RemoteException {
    }

    public final void zzl(zzbwb zzbwb) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z2) {
    }

    public final boolean zzo() throws RemoteException {
        return false;
    }

    public final void zzp(zzbvv zzbvv) throws RemoteException {
    }
}
