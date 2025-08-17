package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzfiz implements Continuation {
    public static final /* synthetic */ zzfiz zza = new zzfiz();

    private /* synthetic */ zzfiz() {
    }

    public final Object then(Task task) {
        return Boolean.valueOf(task.isSuccessful());
    }
}
