package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzfey implements zzfev {
    private final zzfev zza;
    private final Queue zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) zzba.zzc().zzb(zzbbm.zzij)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzfey(zzfev zzfev, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfev;
        long intValue = (long) ((Integer) zzba.zzc().zzb(zzbbm.zzii)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new zzfex(this), intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ void zzc(zzfey zzfey) {
        while (!zzfey.zzb.isEmpty()) {
            zzfey.zza.zzb((zzfeu) zzfey.zzb.remove());
        }
    }

    public final String zza(zzfeu zzfeu) {
        return this.zza.zza(zzfeu);
    }

    public final void zzb(zzfeu zzfeu) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer(zzfeu);
        } else if (!this.zzd.getAndSet(true)) {
            Queue queue = this.zzb;
            zzfeu zzb2 = zzfeu.zzb("dropped_event");
            Map zzj = zzfeu.zzj();
            if (zzj.containsKey("action")) {
                zzb2.zza("dropped_action", (String) zzj.get("action"));
            }
            queue.offer(zzb2);
        }
    }
}
