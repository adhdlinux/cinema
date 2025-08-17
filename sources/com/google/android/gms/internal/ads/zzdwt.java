package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

public final /* synthetic */ class zzdwt implements zzfvj {
    public static final /* synthetic */ zzdwt zza = new zzdwt();

    private /* synthetic */ zzdwt() {
    }

    public final zzfwm zza(Object obj) {
        Throwable th = (ExecutionException) obj;
        if (th.getCause() != null) {
            th = th.getCause();
        }
        return zzfwc.zzg(th);
    }
}
