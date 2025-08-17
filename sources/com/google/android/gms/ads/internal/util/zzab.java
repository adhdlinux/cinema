package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
import com.unity3d.services.core.device.MimeTypes;

public final class zzab {
    private boolean zza = false;
    private float zzb = 1.0f;

    public static float zzb(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }

    private final synchronized boolean zzf() {
        return this.zzb >= 0.0f;
    }

    public final synchronized float zza() {
        if (!zzf()) {
            return 1.0f;
        }
        return this.zzb;
    }

    public final synchronized void zzc(boolean z2) {
        this.zza = z2;
    }

    public final synchronized void zzd(float f2) {
        this.zzb = f2;
    }

    public final synchronized boolean zze() {
        return this.zza;
    }
}
