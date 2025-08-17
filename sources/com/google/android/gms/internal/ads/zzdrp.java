package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzdrp implements zzdqz {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final zzdre zzb;
    private final zzeze zzc;

    zzdrp(long j2, Context context, zzdre zzdre, zzcgu zzcgu, String str) {
        this.zza = j2;
        this.zzb = zzdre;
        zzezg zzu = zzcgu.zzu();
        zzu.zzb(context);
        zzu.zza(str);
        this.zzc = zzu.zzc().zza();
    }

    public final void zza() {
    }

    public final void zzb(zzl zzl) {
        try {
            this.zzc.zzf(zzl, new zzdrn(this));
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzc() {
        try {
            this.zzc.zzk(new zzdro(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
