package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzbxj implements Runnable {
    public final /* synthetic */ zzbxw zza;
    public final /* synthetic */ zzbxv zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbxj(zzbxw zzbxw, zzbxv zzbxv, String str) {
        this.zza = zzbxw;
        this.zzb = zzbxv;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
