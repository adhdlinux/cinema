package com.google.android.gms.internal.consent_sdk;

public final /* synthetic */ class zzbd implements Runnable {
    public final /* synthetic */ zzbg zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbd(zzbg zzbg, String str) {
        this.zza = zzbg;
        this.zzb = str;
    }

    public final void run() {
        zzce.zza(this.zza, this.zzb);
    }
}
