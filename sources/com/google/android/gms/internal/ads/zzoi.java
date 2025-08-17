package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzoi implements Runnable {
    public final /* synthetic */ zzos zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzoi(zzos zzos, Exception exc) {
        this.zza = zzos;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
