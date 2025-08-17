package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfww implements Runnable {
    zzfwz zza;

    zzfww(zzfwz zzfwz) {
        this.zza = zzfwz;
    }

    public final void run() {
        zzfwm zzf;
        String str;
        zzfwz zzfwz = this.zza;
        if (zzfwz != null && (zzf = zzfwz.zza) != null) {
            this.zza = null;
            if (zzf.isDone()) {
                zzfwz.zzt(zzf);
                return;
            }
            try {
                ScheduledFuture zzw = zzfwz.zzb;
                zzfwz.zzb = null;
                str = "Timed out";
                if (zzw != null) {
                    long abs = Math.abs(zzw.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                zzfwz.zze(new zzfwy(str + ": " + zzf.toString(), (zzfwx) null));
                zzf.cancel(true);
            } catch (Throwable th) {
                zzf.cancel(true);
                throw th;
            }
        }
    }
}
