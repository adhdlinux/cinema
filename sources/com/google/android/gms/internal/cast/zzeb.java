package com.google.android.gms.internal.cast;

import android.animation.Animator;

public final class zzeb extends zzdz {
    protected final Animator zza;
    private final int zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private final zzef zzd = new zzea(this);

    private zzeb(Animator animator, int i2, Runnable runnable) {
        this.zza = animator;
        this.zzb = -1;
    }

    public static void zzd(Animator animator, int i2, Runnable runnable) {
        animator.addListener(new zzeb(animator, -1, (Runnable) null));
    }

    static /* bridge */ /* synthetic */ boolean zze(zzeb zzeb) {
        return zzeb.zzb != -1 && zzeb.zzc >= 0;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!zza(animator)) {
            zzei.zzb().zza(this.zzd);
        }
    }
}
