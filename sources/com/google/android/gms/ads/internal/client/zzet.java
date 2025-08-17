package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;

final class zzet extends zzbm {
    final /* synthetic */ zzeu zza;

    /* synthetic */ zzet(zzeu zzeu, zzes zzes) {
        this.zza = zzeu;
    }

    public final String zze() throws RemoteException {
        return null;
    }

    public final String zzf() throws RemoteException {
        return null;
    }

    public final void zzg(zzl zzl) throws RemoteException {
        zzh(zzl, 1);
    }

    public final void zzh(zzl zzl, int i2) throws RemoteException {
        zzbzr.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbzk.zza.post(new zzer(this));
    }

    public final boolean zzi() throws RemoteException {
        return false;
    }
}
