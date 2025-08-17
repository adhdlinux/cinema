package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;

public final class zzejx {
    private final zzekc zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public zzdn zzc;

    public zzejx(zzekc zzekc, String str) {
        this.zza = zzekc;
        this.zzb = str;
    }

    public final synchronized String zza() {
        String str;
        str = null;
        try {
            zzdn zzdn = this.zzc;
            if (zzdn != null) {
                str = zzdn.zzg();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            return null;
        }
        return str;
    }

    public final synchronized String zzb() {
        String str;
        str = null;
        try {
            zzdn zzdn = this.zzc;
            if (zzdn != null) {
                str = zzdn.zzg();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            return null;
        }
        return str;
    }

    public final synchronized void zzd(zzl zzl, int i2) throws RemoteException {
        this.zzc = null;
        this.zza.zzb(zzl, this.zzb, new zzekd(i2), new zzejw(this));
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
