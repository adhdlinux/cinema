package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public final class zzfbe {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzfwn zzc;

    public zzfbe(Callable callable, zzfwn zzfwn) {
        this.zzb = callable;
        this.zzc = zzfwn;
    }

    public final synchronized zzfwm zza() {
        zzc(1);
        return (zzfwm) this.zza.poll();
    }

    public final synchronized void zzb(zzfwm zzfwm) {
        this.zza.addFirst(zzfwm);
    }

    public final synchronized void zzc(int i2) {
        int size = i2 - this.zza.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}
