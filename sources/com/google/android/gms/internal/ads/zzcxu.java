package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzcxu implements Runnable {
    private final WeakReference zza;

    /* synthetic */ zzcxu(zzcxv zzcxv, zzcxt zzcxt) {
        this.zza = new WeakReference(zzcxv);
    }

    public final void run() {
        zzcxv zzcxv = (zzcxv) this.zza.get();
        if (zzcxv != null) {
            zzcxv.zzp(zzcxs.zza);
        }
    }
}
