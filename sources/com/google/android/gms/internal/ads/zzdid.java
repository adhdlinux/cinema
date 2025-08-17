package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

public final /* synthetic */ class zzdid implements zzbij {
    public final /* synthetic */ zzdie zza;
    public final /* synthetic */ zzbgl zzb;

    public /* synthetic */ zzdid(zzdie zzdie, zzbgl zzbgl) {
        this.zza = zzdie;
        this.zzb = zzbgl;
    }

    public final void zza(Object obj, Map map) {
        zzdie zzdie = this.zza;
        zzbgl zzbgl = this.zzb;
        try {
            zzdie.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzbzr.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzdie.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzbgl == null) {
            zzbzr.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbgl.zzf(str);
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
