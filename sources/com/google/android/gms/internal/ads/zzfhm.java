package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.view.View;

public final class zzfhm implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzfhm zza = new zzfhm();
    private boolean zzb;
    private boolean zzc;
    private zzfhr zzd;

    private zzfhm() {
    }

    public static zzfhm zza() {
        return zza;
    }

    private final void zze() {
        String str;
        boolean z2 = this.zzc;
        for (zzfha zzg : zzfhl.zza().zzc()) {
            zzfhx zzg2 = zzg.zzg();
            if (zzg2.zzk()) {
                if (true != z2) {
                    str = "foregrounded";
                } else {
                    str = "backgrounded";
                }
                zzfhq.zza().zzb(zzg2.zza(), "setState", str);
            }
        }
    }

    private final void zzf(boolean z2) {
        if (this.zzc != z2) {
            this.zzc = z2;
            if (this.zzb) {
                zze();
                if (this.zzd == null) {
                    return;
                }
                if (!z2) {
                    zzfin.zzd().zzi();
                } else {
                    zzfin.zzd().zzh();
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzf(false);
    }

    public final void onActivityStopped(Activity activity) {
        View zzf;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i2 = runningAppProcessInfo.importance;
        boolean z2 = true;
        boolean z3 = true;
        for (zzfha zzfha : zzfhl.zza().zzb()) {
            if (zzfha.zzj() && (zzf = zzfha.zzf()) != null && zzf.hasWindowFocus()) {
                z3 = false;
            }
        }
        if (i2 == 100 || !z3) {
            z2 = false;
        }
        zzf(z2);
    }

    public final void zzb() {
        this.zzb = true;
        this.zzc = false;
        zze();
    }

    public final void zzc() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = null;
    }

    public final void zzd(zzfhr zzfhr) {
        this.zzd = zzfhr;
    }
}
