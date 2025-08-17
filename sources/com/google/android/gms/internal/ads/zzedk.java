package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;

public final /* synthetic */ class zzedk implements zzcrb {
    public final /* synthetic */ zzecf zza;

    public /* synthetic */ zzedk(zzecf zzecf) {
        this.zza = zzecf;
    }

    public final zzdq zza() {
        try {
            return ((zzbpt) this.zza.zzb).zze();
        } catch (RemoteException e2) {
            throw new zzfan(e2);
        }
    }
}
