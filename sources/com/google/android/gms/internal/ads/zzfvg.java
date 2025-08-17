package com.google.android.gms.internal.ads;

import java.util.Set;

final class zzfvg extends zzfvd {
    private zzfvg() {
        super((zzfvc) null);
    }

    /* synthetic */ zzfvg(zzfvf zzfvf) {
        super((zzfvc) null);
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzfvh zzfvh) {
        int zzA;
        synchronized (zzfvh) {
            zzA = zzfvh.remaining - 1;
            zzfvh.remaining = zzA;
        }
        return zzA;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzfvh zzfvh, Set set, Set set2) {
        synchronized (zzfvh) {
            if (zzfvh.seenExceptions == null) {
                zzfvh.seenExceptions = set2;
            }
        }
    }
}
