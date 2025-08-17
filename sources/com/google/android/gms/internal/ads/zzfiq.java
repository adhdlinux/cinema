package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzfiq {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfip zzd = null;

    public zzfiq() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfip zzfip = (zzfip) this.zzc.poll();
        this.zzd = zzfip;
        if (zzfip != null) {
            zzfip.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfip zzfip) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfip zzfip) {
        zzfip.zzb(this);
        this.zzc.add(zzfip);
        if (this.zzd == null) {
            zzc();
        }
    }
}
