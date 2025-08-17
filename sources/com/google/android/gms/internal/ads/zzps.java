package com.google.android.gms.internal.ads;

import android.os.SystemClock;

final class zzps {
    private Exception zza;
    private long zzb;

    public zzps(long j2) {
    }

    public final void zza() {
        this.zza = null;
    }

    public final void zzb(Exception exc) throws Exception {
        Class<Throwable> cls = Throwable.class;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zza == null) {
            this.zza = exc;
            this.zzb = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.zzb) {
            Exception exc2 = this.zza;
            if (exc2 != exc) {
                try {
                    cls.getDeclaredMethod("addSuppressed", new Class[]{cls}).invoke(exc2, new Object[]{exc});
                } catch (Exception unused) {
                }
            }
            Exception exc3 = this.zza;
            this.zza = null;
            throw exc3;
        }
    }
}
