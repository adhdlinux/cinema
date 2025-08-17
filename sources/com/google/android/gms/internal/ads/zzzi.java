package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzzi implements Runnable {
    public final /* synthetic */ zzzq zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzzi(zzzq zzzq, Exception exc) {
        this.zza = zzzq;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
