package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzauf implements zzaum {
    final /* synthetic */ Activity zza;
    final /* synthetic */ Bundle zzb;

    zzauf(zzaun zzaun, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.zza, this.zzb);
    }
}
