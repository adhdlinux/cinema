package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zzd extends AnimatorListenerAdapter {
    final /* synthetic */ zzh zza;

    zzd(zzh zzh) {
        this.zza = zzh;
    }

    public final void onAnimationEnd(Animator animator) {
        zzh zzh = this.zza;
        zzh.zza = zzh.zza(zzh);
        this.zza.zza.start();
    }
}
