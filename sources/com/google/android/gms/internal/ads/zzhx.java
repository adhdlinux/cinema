package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.unity3d.services.core.device.MimeTypes;

final class zzhx {
    private final AudioManager zza;
    private final zzhv zzb;
    private zzhw zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzhx(Context context, Handler handler, zzhw zzhw) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzhw;
        this.zzb = new zzhv(this, handler);
        this.zzd = 0;
    }

    static /* bridge */ /* synthetic */ void zzc(zzhx zzhx, int i2) {
        if (i2 == -3 || i2 == -2) {
            if (i2 != -2) {
                zzhx.zzg(3);
                return;
            }
            zzhx.zzf(0);
            zzhx.zzg(2);
        } else if (i2 == -1) {
            zzhx.zzf(-1);
            zzhx.zze();
        } else if (i2 != 1) {
            zzer.zzf("AudioFocusManager", "Unknown focus change type: " + i2);
        } else {
            zzhx.zzg(1);
            zzhx.zzf(1);
        }
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzfj.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzg(0);
        }
    }

    private final void zzf(int i2) {
        zzhw zzhw = this.zzc;
        if (zzhw != null) {
            zzjt zzjt = (zzjt) zzhw;
            boolean zzv = zzjt.zza.zzv();
            zzjt.zza.zzal(zzv, i2, zzjx.zzY(zzv, i2));
        }
    }

    private final void zzg(int i2) {
        float f2;
        if (this.zzd != i2) {
            this.zzd = i2;
            if (i2 == 3) {
                f2 = 0.2f;
            } else {
                f2 = 1.0f;
            }
            if (this.zze != f2) {
                this.zze = f2;
                zzhw zzhw = this.zzc;
                if (zzhw != null) {
                    ((zzjt) zzhw).zza.zzai();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z2, int i2) {
        zze();
        return z2 ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
