package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzoo implements Runnable {
    public final /* synthetic */ zzos zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzoo(zzos zzos, Exception exc) {
        this.zza = zzos;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
