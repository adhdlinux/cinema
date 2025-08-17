package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbel implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzbfl zza;

    public zzbel(zzbfl zzbfl) {
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
