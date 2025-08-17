package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdpv;
import java.util.ArrayDeque;

public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ zzc zza;
    public final /* synthetic */ zzdpv zzb;
    public final /* synthetic */ ArrayDeque zzc;
    public final /* synthetic */ ArrayDeque zzd;

    public /* synthetic */ zza(zzc zzc2, zzdpv zzdpv, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        this.zza = zzc2;
        this.zzb = zzdpv;
        this.zzc = arrayDeque;
        this.zzd = arrayDeque2;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd);
    }
}
