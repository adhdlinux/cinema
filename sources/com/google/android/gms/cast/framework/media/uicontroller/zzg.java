package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

final class zzg implements View.OnClickListener {
    final /* synthetic */ long zza;
    final /* synthetic */ UIMediaController zzb;

    zzg(UIMediaController uIMediaController, long j2) {
        this.zzb = uIMediaController;
        this.zza = j2;
    }

    public final void onClick(View view) {
        this.zzb.onRewindClicked(view, this.zza);
    }
}
