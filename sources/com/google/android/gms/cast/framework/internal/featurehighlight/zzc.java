package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.View;

final class zzc implements View.OnLayoutChangeListener {
    final /* synthetic */ zzh zza;

    zzc(zzh zzh, Runnable runnable) {
        this.zza = zzh;
    }

    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.zza.zzk();
        this.zza.removeOnLayoutChangeListener(this);
    }
}
