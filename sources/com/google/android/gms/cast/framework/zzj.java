package com.google.android.gms.cast.framework;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzj implements OnCompleteListener {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzj(zzm zzm) {
        this.zza = zzm;
    }

    public final void onComplete(Task task) {
        CastSession.zzh(this.zza.zza, "launchApplication", task);
    }
}
