package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzfuz implements Runnable {
    public final /* synthetic */ zzfvb zza;
    public final /* synthetic */ zzfwm zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzfuz(zzfvb zzfvb, zzfwm zzfwm, int i2) {
        this.zza = zzfvb;
        this.zzb = zzfwm;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzx(this.zzb, this.zzc);
    }
}
