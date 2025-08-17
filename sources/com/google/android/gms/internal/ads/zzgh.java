package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

public final class zzgh {
    private Uri zza;
    private Map zzb = Collections.emptyMap();
    private long zzc;
    private int zzd;

    public final zzgh zza(int i2) {
        this.zzd = 6;
        return this;
    }

    public final zzgh zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzgh zzc(long j2) {
        this.zzc = j2;
        return this;
    }

    public final zzgh zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzgj zze() {
        if (this.zza != null) {
            return new zzgj(this.zza, 0, 1, (byte[]) null, this.zzb, this.zzc, -1, (String) null, this.zzd, (Object) null, (zzgi) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
