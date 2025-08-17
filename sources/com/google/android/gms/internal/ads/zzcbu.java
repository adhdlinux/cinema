package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import java.util.concurrent.TimeUnit;

public final class zzcbu {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzba.zzc().zzb(zzbbm.zzD)).longValue());
    private long zzb;
    private boolean zzc = true;

    zzcbu() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzcbf zzcbf) {
        if (zzcbf != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzc || Math.abs(timestamp - this.zzb) >= this.zza) {
                this.zzc = false;
                this.zzb = timestamp;
                zzs.zza.post(new zzcbt(zzcbf));
            }
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
