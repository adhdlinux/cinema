package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

public final /* synthetic */ class zzdwb implements zzfvj {
    public static final /* synthetic */ zzdwb zza = new zzdwb();

    private /* synthetic */ zzdwb() {
    }

    public final zzfwm zza(Object obj) {
        Throwable th = (ExecutionException) obj;
        if (th.getCause() != null) {
            th = th.getCause();
        }
        return zzfwc.zzg(th);
    }
}
