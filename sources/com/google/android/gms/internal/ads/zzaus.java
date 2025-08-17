package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzaus implements Application.ActivityLifecycleCallbacks {
    private Activity zza;
    private Context zzb;
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public boolean zzd = true;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    public final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private Runnable zzh;
    private boolean zzi = false;
    private long zzj;

    zzaus() {
    }

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator it2 = this.zzg.iterator();
                while (it2.hasNext()) {
                    try {
                        if (((zzavh) it2.next()).zza()) {
                            it2.remove();
                        }
                    } catch (Exception e2) {
                        zzt.zzo().zzu(e2, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbzr.zzh("", e2);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            for (zzavh zzb2 : this.zzg) {
                try {
                    zzb2.zzb();
                } catch (Exception e2) {
                    zzt.zzo().zzu(e2, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbzr.zzh("", e2);
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            zzs.zza.removeCallbacks(runnable);
        }
        zzfmd zzfmd = zzs.zza;
        zzaur zzaur = new zzaur(this);
        this.zzh = zzaur;
        zzfmd.postDelayed(zzaur, this.zzj);
    }

    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z2 = !this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            zzs.zza.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            for (zzavh zzc2 : this.zzg) {
                try {
                    zzc2.zzc();
                } catch (Exception e2) {
                    zzt.zzo().zzu(e2, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbzr.zzh("", e2);
                }
            }
            if (z2) {
                for (zzaut zza2 : this.zzf) {
                    try {
                        zza2.zza(true);
                    } catch (Exception e3) {
                        zzbzr.zzh("", e3);
                    }
                }
            } else {
                zzbzr.zze("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzaut zzaut) {
        synchronized (this.zzc) {
            this.zzf.add(zzaut);
        }
    }

    public final void zzg(Application application, Context context) {
        if (!this.zzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                zzk((Activity) context);
            }
            this.zzb = application;
            this.zzj = ((Long) zzba.zzc().zzb(zzbbm.zzaP)).longValue();
            this.zzi = true;
        }
    }

    public final void zzh(zzaut zzaut) {
        synchronized (this.zzc) {
            this.zzf.remove(zzaut);
        }
    }
}
