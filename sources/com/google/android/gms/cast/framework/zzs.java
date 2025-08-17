package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamic.IObjectWrapper;

@ShowFirstParty
public final class zzs {
    private static final Logger zza = new Logger("DiscoveryManager");
    private final zzag zzb;

    zzs(zzag zzag) {
        this.zzb = zzag;
    }

    public final IObjectWrapper zza() {
        try {
            return this.zzb.zze();
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "getWrappedThis", zzag.class.getSimpleName());
            return null;
        }
    }
}
