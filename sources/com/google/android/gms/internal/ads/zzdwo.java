package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

public final /* synthetic */ class zzdwo implements zzfvj {
    public static final /* synthetic */ zzdwo zza = new zzdwo();

    private /* synthetic */ zzdwo() {
    }

    public final zzfwm zza(Object obj) {
        Throwable th = (ExecutionException) obj;
        if (th.getCause() != null) {
            th = th.getCause();
        }
        return zzfwc.zzg(th);
    }
}
