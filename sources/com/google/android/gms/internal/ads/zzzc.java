package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;

final class zzzc implements zzzb {
    private final WindowManager zza;

    private zzzc(WindowManager windowManager) {
        this.zza = windowManager;
    }

    public static zzzb zzc(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new zzzc(windowManager);
        }
        return null;
    }

    public final void zza() {
    }

    public final void zzb(zzyz zzyz) {
        zzzf.zzb(zzyz.zza, this.zza.getDefaultDisplay());
    }
}
