package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.Collections;
import java.util.List;

public final class zzey extends zzcn {
    private zzbkm zza;

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzbkm zzbkm = this.zza;
        if (zzbkm != null) {
            try {
                zzbkm.zzb(Collections.emptyList());
            } catch (RemoteException e2) {
                zzbzr.zzk("Could not notify onComplete event.", e2);
            }
        }
    }

    public final float zze() throws RemoteException {
        return 1.0f;
    }

    public final String zzf() {
        return "";
    }

    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzh(String str) throws RemoteException {
    }

    public final void zzi() {
    }

    public final void zzj(boolean z2) throws RemoteException {
    }

    public final void zzk() throws RemoteException {
        zzbzr.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzbzk.zza.post(new zzex(this));
    }

    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzm(zzda zzda) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzo(zzbnw zzbnw) throws RemoteException {
    }

    public final void zzp(boolean z2) throws RemoteException {
    }

    public final void zzq(float f2) throws RemoteException {
    }

    public final void zzr(String str) throws RemoteException {
    }

    public final void zzs(zzbkm zzbkm) throws RemoteException {
        this.zza = zzbkm;
    }

    public final void zzt(String str) {
    }

    public final void zzu(zzff zzff) throws RemoteException {
    }

    public final boolean zzv() throws RemoteException {
        return false;
    }
}
