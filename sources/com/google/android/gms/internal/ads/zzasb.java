package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

final class zzasb implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzasc zza;

    zzasb(zzasc zzasc) {
        this.zza = zzasc;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z2) {
        if (z2) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        zzasc zzasc = this.zza;
        if (zzasc.zzc > 0 && currentTimeMillis >= zzasc.zzc) {
            zzasc.zzd = currentTimeMillis - zzasc.zzc;
        }
        this.zza.zze = false;
    }
}
