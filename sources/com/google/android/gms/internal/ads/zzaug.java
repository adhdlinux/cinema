package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzaug implements zzaum {
    final /* synthetic */ Activity zza;

    zzaug(zzaun zzaun, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}
