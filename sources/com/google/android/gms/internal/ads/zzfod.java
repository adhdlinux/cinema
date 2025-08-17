package com.google.android.gms.internal.ads;

import android.os.IBinder;

final class zzfod extends zzfnx {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzfog zzb;

    zzfod(zzfog zzfog, IBinder iBinder) {
        this.zzb = zzfog;
        this.zza = iBinder;
    }

    public final void zza() {
        this.zzb.zza.zzn = zzfns.zzb(this.zza);
        zzfoh.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
