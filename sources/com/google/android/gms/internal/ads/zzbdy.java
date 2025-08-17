package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

public final class zzbdy {
    private final Context zza;

    public zzbdy(Context context) {
        this.zza = context;
    }

    public final void zza(zzbtd zzbtd) {
        try {
            ((zzbdz) zzbzv.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzbdx.zza)).zze(zzbtd);
        } catch (zzbzu e2) {
            zzbzr.zzj("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e2.getMessage())));
        } catch (RemoteException e3) {
            zzbzr.zzj("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e3.getMessage())));
        }
    }
}
