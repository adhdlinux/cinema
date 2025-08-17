package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzeqz implements Runnable {
    public final /* synthetic */ zzerb zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzeqy zzc;

    public /* synthetic */ zzeqz(zzerb zzerb, long j2, zzeqy zzeqy) {
        this.zza = zzerb;
        this.zzb = j2;
        this.zzc = zzeqy;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
