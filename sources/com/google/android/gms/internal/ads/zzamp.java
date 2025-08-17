package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

final class zzamp implements zzamf {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzamp(Context context) {
        this.zza = context;
    }

    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
