package com.google.android.gms.internal.ads;

import android.view.View;

final class zzcfd implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbws zza;
    final /* synthetic */ zzcfg zzb;

    zzcfd(zzcfg zzcfg, zzbws zzbws) {
        this.zzb = zzcfg;
        this.zza = zzbws;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzR(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
