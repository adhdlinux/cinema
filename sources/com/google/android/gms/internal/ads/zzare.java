package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzare implements zzarh {
    final /* synthetic */ Activity zza;

    zzare(zzari zzari, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.zza);
    }
}
