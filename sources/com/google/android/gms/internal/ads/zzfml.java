package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Task;

public final class zzfml {
    public static zzfwm zza(Task task) {
        zzfmk zzfmk = new zzfmk(task);
        task.addOnCompleteListener(zzfwt.zzb(), new zzfmj(zzfmk));
        return zzfmk;
    }
}
