package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzd;

final class zzh extends zzd {
    final /* synthetic */ UIMediaController zza;

    zzh(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void zza(CastSeekBar castSeekBar, int i2, boolean z2) {
        this.zza.zzc(castSeekBar, i2, z2);
    }

    public final void zzb(CastSeekBar castSeekBar) {
        this.zza.zzd(castSeekBar);
    }

    public final void zzc(CastSeekBar castSeekBar) {
        this.zza.zze(castSeekBar);
    }
}
