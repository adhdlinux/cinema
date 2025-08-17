package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;
import android.widget.ImageView;

final class zzc implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    zzc(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onPlayPauseToggleClicked((ImageView) view);
    }
}
