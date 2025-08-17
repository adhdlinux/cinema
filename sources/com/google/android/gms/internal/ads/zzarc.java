package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzarc implements zzarh {
    final /* synthetic */ Activity zza;

    zzarc(zzari zzari, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.zza);
    }
}
