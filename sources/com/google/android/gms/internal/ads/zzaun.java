package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzaun implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzaun(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzauf(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzaul(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzaui(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzauh(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzauk(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzaug(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzauj(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzaum zzaum) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzaum.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e2) {
            zzbzr.zzh("Error while dispatching lifecycle callback.", e2);
        }
    }
}
