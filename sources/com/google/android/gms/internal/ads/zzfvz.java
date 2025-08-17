package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class zzfvz implements Runnable {
    final Future zza;
    final zzfvy zzb;

    zzfvz(Future future, zzfvy zzfvy) {
        this.zza = future;
        this.zzb = zzfvy;
    }

    public final void run() {
        Throwable zza2;
        Future future = this.zza;
        if (!(future instanceof zzfxf) || (zza2 = zzfxg.zza((zzfxf) future)) == null) {
            try {
                this.zzb.zzb(zzfwc.zzo(this.zza));
            } catch (ExecutionException e2) {
                this.zzb.zza(e2.getCause());
            } catch (Error | RuntimeException e3) {
                this.zzb.zza(e3);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfpa zza2 = zzfpb.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
