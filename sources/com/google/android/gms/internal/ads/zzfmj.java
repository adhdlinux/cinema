package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzfmj implements OnCompleteListener {
    public final /* synthetic */ zzfmk zza;

    public /* synthetic */ zzfmj(zzfmk zzfmk) {
        this.zza = zzfmk;
    }

    public final void onComplete(Task task) {
        zzfmk zzfmk = this.zza;
        if (task.isCanceled()) {
            zzfmk.cancel(false);
        } else if (task.isSuccessful()) {
            zzfmk.zzd(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzfmk.zze(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
