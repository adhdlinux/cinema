package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzari implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzari(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzara(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzarg(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzard(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzarc(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzarf(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzarb(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzare(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzarh zzarh) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzarh.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
