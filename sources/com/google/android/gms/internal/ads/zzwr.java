package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.core.device.MimeTypes;

final class zzwr {
    private final Spatializer zza;
    private final boolean zzb;
    private Handler zzc;
    private Spatializer.OnSpatializerStateChangedListener zzd;

    private zzwr(Spatializer spatializer) {
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
    }

    public static zzwr zza(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return new zzwr(audioManager.getSpatializer());
    }

    public final void zzb(zzwy zzwy, Looper looper) {
        if (this.zzd == null && this.zzc == null) {
            this.zzd = new zzwq(this, zzwy);
            Handler handler = new Handler(looper);
            this.zzc = handler;
            this.zza.addOnSpatializerStateChangedListener(new zzwp(handler), this.zzd);
        }
    }

    public final void zzc() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.zzd;
        if (onSpatializerStateChangedListener != null && this.zzc != null) {
            this.zza.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            Handler handler = this.zzc;
            int i2 = zzfj.zza;
            handler.removeCallbacksAndMessages((Object) null);
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final boolean zzd(zzk zzk, zzam zzam) {
        int i2;
        if (!"audio/eac3-joc".equals(zzam.zzm) || zzam.zzz != 16) {
            i2 = zzam.zzz;
        } else {
            i2 = 12;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(zzfj.zzf(i2));
        int i3 = zzam.zzA;
        if (i3 != -1) {
            channelMask.setSampleRate(i3);
        }
        return this.zza.canBeSpatialized(zzk.zza().zza, channelMask.build());
    }

    public final boolean zze() {
        return this.zza.isAvailable();
    }

    public final boolean zzf() {
        return this.zza.isEnabled();
    }

    public final boolean zzg() {
        return this.zzb;
    }
}
