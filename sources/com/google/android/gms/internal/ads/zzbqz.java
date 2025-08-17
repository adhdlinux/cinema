package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbqz implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbfl zza;

    public zzbqz(zzbfl zzbfl) {
        this.zza = zzbfl;
        try {
            zzbfl.zzm();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzp(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return false;
        }
    }
}
