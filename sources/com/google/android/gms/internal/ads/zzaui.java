package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzaui implements zzaum {
    final /* synthetic */ Activity zza;

    zzaui(zzaun zzaun, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.zza);
    }
}
