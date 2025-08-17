package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;

public final class zzfho {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzfho zza = new zzfho();
    private Context zzb;

    private zzfho() {
    }

    public static zzfho zzb() {
        return zza;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
