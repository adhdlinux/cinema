package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.unity3d.services.core.device.MimeTypes;

public final class zzcce implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager zza;
    private final zzccd zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private float zzf = 1.0f;

    public zzcce(Context context, zzccd zzccd) {
        this.zza = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.zzb = zzccd;
    }

    private final void zzf() {
        boolean z2 = false;
        if (!this.zzd || this.zze || this.zzf <= 0.0f) {
            if (this.zzc) {
                AudioManager audioManager = this.zza;
                if (audioManager != null) {
                    if (audioManager.abandonAudioFocus(this) == 0) {
                        z2 = true;
                    }
                    this.zzc = z2;
                }
                this.zzb.zzn();
            }
        } else if (!this.zzc) {
            AudioManager audioManager2 = this.zza;
            if (audioManager2 != null) {
                if (audioManager2.requestAudioFocus(this, 3, 2) == 1) {
                    z2 = true;
                }
                this.zzc = z2;
            }
            this.zzb.zzn();
        }
    }

    public final void onAudioFocusChange(int i2) {
        this.zzc = i2 > 0;
        this.zzb.zzn();
    }

    public final float zza() {
        float f2 = this.zze ? 0.0f : this.zzf;
        if (this.zzc) {
            return f2;
        }
        return 0.0f;
    }

    public final void zzb() {
        this.zzd = true;
        zzf();
    }

    public final void zzc() {
        this.zzd = false;
        zzf();
    }

    public final void zzd(boolean z2) {
        this.zze = z2;
        zzf();
    }

    public final void zze(float f2) {
        this.zzf = f2;
        zzf();
    }
}
