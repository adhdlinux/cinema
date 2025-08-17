package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbm;
import com.google.android.gms.ads.internal.client.zzl;

public final class zzeiq extends zzbm {
    private final zzejx zza;

    public zzeiq(Context context, zzcgu zzcgu, zzfag zzfag, zzdhl zzdhl, zzbh zzbh) {
        zzejz zzejz = new zzejz(zzdhl, zzcgu.zzx());
        zzejz.zze(zzbh);
        this.zza = new zzejx(new zzekj(zzcgu, context, zzejz, zzfag), zzfag.zzI());
    }

    public final synchronized String zze() {
        return this.zza.zza();
    }

    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    public final void zzg(zzl zzl) throws RemoteException {
        this.zza.zzd(zzl, 1);
    }

    public final synchronized void zzh(zzl zzl, int i2) throws RemoteException {
        this.zza.zzd(zzl, i2);
    }

    public final synchronized boolean zzi() throws RemoteException {
        return this.zza.zze();
    }
}
