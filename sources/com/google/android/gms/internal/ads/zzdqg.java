package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdqg implements Runnable {
    public final /* synthetic */ zzdqh zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdqg(zzdqh zzdqh, String str) {
        this.zza = zzdqh;
        this.zzb = str;
    }

    public final void run() {
        zzdqh zzdqh = this.zza;
        zzdqh.zzd.zza(this.zzb);
    }
}
