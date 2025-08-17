package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

public final class zzeie {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdnv zzb;

    public zzeie(zzdnv zzdnv) {
        this.zzb = zzdnv;
    }

    public final zzbpt zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbpt) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e2) {
            zzbzr.zzh("Couldn't create RTB adapter : ", e2);
        }
    }
}
