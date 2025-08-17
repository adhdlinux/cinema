package com.google.android.gms.internal.ads;

import android.app.Application;
import android.content.Context;

public final class zzfgv {
    private boolean zza;

    /* access modifiers changed from: package-private */
    public final void zza(Context context) {
        zzfid.zzb(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzfhr.zzb().zzc(context);
            zzfhm zza2 = zzfhm.zza();
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(zza2);
            }
            zzfib.zzd(context);
            zzfho.zzb().zzc(context);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }
}
