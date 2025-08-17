package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

public final class zzfhj extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private final zzfhh zzc;
    private float zzd;
    private final zzfhr zze;

    public zzfhj(Handler handler, Context context, zzfhh zzfhh, zzfhr zzfhr) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.zzc = zzfhh;
        this.zze = zzfhr;
    }

    private final float zzc() {
        int streamVolume = this.zzb.getStreamVolume(3);
        int streamMaxVolume = this.zzb.getStreamMaxVolume(3);
        float f2 = 0.0f;
        if (streamMaxVolume > 0 && streamVolume > 0) {
            float f3 = ((float) streamVolume) / ((float) streamMaxVolume);
            f2 = 1.0f;
            if (f3 > 1.0f) {
                return f2;
            }
            return f3;
        }
        return f2;
    }

    private final void zzd() {
        this.zze.zzd(this.zzd);
    }

    public final void onChange(boolean z2) {
        super.onChange(z2);
        float zzc2 = zzc();
        if (zzc2 != this.zzd) {
            this.zzd = zzc2;
            zzd();
        }
    }

    public final void zza() {
        this.zzd = zzc();
        zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver(this);
    }
}
