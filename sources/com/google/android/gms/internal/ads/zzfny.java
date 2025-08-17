package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzfny implements OnCompleteListener {
    public final /* synthetic */ zzfoh zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzfny(zzfoh zzfoh, TaskCompletionSource taskCompletionSource) {
        this.zza = zzfoh;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zzt(this.zzb, task);
    }
}
