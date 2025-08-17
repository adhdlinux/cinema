package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

final class zzfve extends zzfvd {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    zzfve(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzfvc) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzfvh zzfvh) {
        return this.zzb.decrementAndGet(zzfvh);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP:0: B:1:0x0002->B:4:0x000e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzfvh r2, java.util.Set r3, java.util.Set r4) {
        /*
            r1 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = r1.zza
        L_0x0002:
            r0 = 0
            boolean r0 = androidx.concurrent.futures.a.a(r3, r2, r0, r4)
            if (r0 == 0) goto L_0x000a
            goto L_0x0010
        L_0x000a:
            java.lang.Object r0 = r3.get(r2)
            if (r0 == 0) goto L_0x0002
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfve.zzb(com.google.android.gms.internal.ads.zzfvh, java.util.Set, java.util.Set):void");
    }
}
