package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

final class zzhv implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzhx zza;
    private final Handler zzb;

    public zzhv(zzhx zzhx, Handler handler) {
        this.zza = zzhx;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i2) {
        this.zzb.post(new zzhu(this, i2));
    }
}
