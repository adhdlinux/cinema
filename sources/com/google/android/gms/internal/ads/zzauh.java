package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzauh implements zzaum {
    final /* synthetic */ Activity zza;

    zzauh(zzaun zzaun, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.zza);
    }
}
