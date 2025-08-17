package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzdao implements Runnable {
    public final /* synthetic */ zzdap zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzdao(zzdap zzdap, Object obj) {
        this.zza = zzdap;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzt.zzo().zzt(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
