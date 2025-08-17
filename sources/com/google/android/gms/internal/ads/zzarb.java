package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzarb implements zzarh {
    final /* synthetic */ Activity zza;

    zzarb(zzari zzari, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}
