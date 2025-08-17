package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;

public final class zzbz {
    private long zza;
    private long zzb = Long.MIN_VALUE;
    private final Object zzc = new Object();

    public zzbz(long j2) {
        this.zza = j2;
    }

    public final void zza(long j2) {
        synchronized (this.zzc) {
            this.zza = j2;
        }
    }

    public final boolean zzb() {
        synchronized (this.zzc) {
            long elapsedRealtime = zzt.zzB().elapsedRealtime();
            if (this.zzb + this.zza > elapsedRealtime) {
                return false;
            }
            this.zzb = elapsedRealtime;
            return true;
        }
    }
}
