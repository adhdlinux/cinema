package com.google.android.gms.ads.internal.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zzp extends AnimatorListenerAdapter {
    final /* synthetic */ zzr zza;

    zzp(zzr zzr) {
        this.zza = zzr;
    }

    private final void zza(boolean z2) {
        this.zza.setEnabled(z2);
        this.zza.zza.setEnabled(z2);
    }

    public final void onAnimationCancel(Animator animator) {
        zza(true);
    }

    public final void onAnimationEnd(Animator animator) {
        zza(true);
    }

    public final void onAnimationStart(Animator animator) {
        zza(false);
    }
}
