package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zztf {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzgj zza;
    public final Uri zzb;
    public final Map zzc;

    public zztf(long j2, zzgj zzgj, Uri uri, Map map, long j3, long j4, long j5) {
        this.zza = zzgj;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
