package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzaul implements zzaum {
    final /* synthetic */ Activity zza;

    zzaul(zzaun zzaun, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.zza);
    }
}
