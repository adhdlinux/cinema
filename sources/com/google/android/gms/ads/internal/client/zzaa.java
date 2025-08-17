package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbrw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

final class zzaa extends zzax {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzaw zzb;

    zzaa(zzaw zzaw, Activity activity) {
        this.zzb = zzaw;
        this.zza = activity;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzm(ObjectWrapper.wrap(this.zza));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbbm.zza(this.zza);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            return this.zzb.zzf.zza(this.zza);
        }
        try {
            return zzbrs.zzH(((zzbrw) zzbzv.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzz.zza)).zze(ObjectWrapper.wrap(this.zza)));
        } catch (RemoteException | zzbzu | NullPointerException e2) {
            this.zzb.zzh = zzbsw.zza(this.zza.getApplicationContext());
            this.zzb.zzh.zzf(e2, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
