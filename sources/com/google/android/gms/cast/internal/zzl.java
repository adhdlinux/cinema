package com.google.android.gms.cast.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzl extends zzae {
    final /* synthetic */ TaskCompletionSource zza;

    zzl(zzn zzn, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Bundle bundle) {
        this.zza.setResult(bundle);
    }
}
