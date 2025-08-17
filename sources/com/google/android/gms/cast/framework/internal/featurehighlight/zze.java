package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zze extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzh zzb;

    zze(zzh zzh, Runnable runnable) {
        this.zzb = zzh;
        this.zza = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        this.zzb.setVisibility(8);
        this.zzb.zza = null;
        this.zza.run();
    }
}
