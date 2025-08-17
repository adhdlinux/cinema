package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.unity3d.services.core.device.MimeTypes;

public final class zzemn implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;

    public zzemn(zzfwn zzfwn, Context context) {
        this.zza = zzfwn;
        this.zzb = context;
    }

    public final int zza() {
        return 13;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzemm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzemo zzc() throws Exception {
        int i2;
        int i3;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int mode = audioManager.getMode();
        boolean isMusicActive = audioManager.isMusicActive();
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjz)).booleanValue()) {
            i3 = zzt.zzq().zzk(audioManager);
            i2 = audioManager.getStreamMaxVolume(3);
        } else {
            i3 = -1;
            i2 = -1;
        }
        return new zzemo(mode, isMusicActive, isSpeakerphoneOn, streamVolume, i3, i2, audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzt.zzr().zza(), zzt.zzr().zze());
    }
}
