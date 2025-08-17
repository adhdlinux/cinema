package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.internal.ads.zzbzr;

public final class zzcx implements MuteThisAdReason {
    private final String zza;
    private final zzcw zzb;

    public zzcx(zzcw zzcw) {
        String str;
        this.zzb = zzcw;
        try {
            str = zzcw.zze();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            str = null;
        }
        this.zza = str;
    }

    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzcw zza() {
        return this.zzb;
    }
}
