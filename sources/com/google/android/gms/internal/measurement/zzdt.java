package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

abstract class zzdt implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzee zzk;

    zzdt(zzee zzee, boolean z2) {
        this.zzk = zzee;
        this.zzh = zzee.zza.currentTimeMillis();
        this.zzi = zzee.zza.elapsedRealtime();
        this.zzj = z2;
    }

    public final void run() {
        if (this.zzk.zzh) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e2) {
            this.zzk.zzS(e2, false, this.zzj);
            zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zza() throws RemoteException;

    /* access modifiers changed from: protected */
    public void zzb() {
    }
}
