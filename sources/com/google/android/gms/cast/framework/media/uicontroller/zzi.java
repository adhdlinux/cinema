package com.google.android.gms.cast.framework.media.uicontroller;

import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzi implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ SeekBar zza;
    final /* synthetic */ UIMediaController zzb;

    zzi(UIMediaController uIMediaController, SeekBar seekBar) {
        this.zzb = uIMediaController;
        this.zza = seekBar;
    }

    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        RemoteMediaClient remoteMediaClient = this.zzb.getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && remoteMediaClient.zzv()) {
            if (z2 && i2 < this.zzb.zza.zzd()) {
                int zzd = this.zzb.zza.zzd();
                this.zza.setProgress(zzd);
                this.zzb.onSeekBarProgressChanged(seekBar, zzd, true);
                return;
            } else if (z2 && i2 > this.zzb.zza.zzc()) {
                int zzc = this.zzb.zza.zzc();
                this.zza.setProgress(zzc);
                this.zzb.onSeekBarProgressChanged(seekBar, zzc, true);
                return;
            }
        }
        this.zzb.onSeekBarProgressChanged(seekBar, i2, z2);
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.zzb.onSeekBarStartTrackingTouch(seekBar);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.zzb.onSeekBarStopTrackingTouch(seekBar);
    }
}
