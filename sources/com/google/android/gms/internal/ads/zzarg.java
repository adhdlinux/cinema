package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzarg implements zzarh {
    final /* synthetic */ Activity zza;

    zzarg(zzari zzari, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.zza);
    }
}
