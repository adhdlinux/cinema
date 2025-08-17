package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;
import com.facebook.react.uimanager.ViewProps;

final class zzzd implements DisplayManager.DisplayListener, zzzb {
    private final DisplayManager zza;
    private zzyz zzb;

    private zzzd(DisplayManager displayManager) {
        this.zza = displayManager;
    }

    public static zzzb zzc(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY);
        if (displayManager != null) {
            return new zzzd(displayManager);
        }
        return null;
    }

    private final Display zzd() {
        return this.zza.getDisplay(0);
    }

    public final void onDisplayAdded(int i2) {
    }

    public final void onDisplayChanged(int i2) {
        zzyz zzyz = this.zzb;
        if (zzyz != null && i2 == 0) {
            zzzf.zzb(zzyz.zza, zzd());
        }
    }

    public final void onDisplayRemoved(int i2) {
    }

    public final void zza() {
        this.zza.unregisterDisplayListener(this);
        this.zzb = null;
    }

    public final void zzb(zzyz zzyz) {
        this.zzb = zzyz;
        this.zza.registerDisplayListener(this, zzfj.zzt((Handler.Callback) null));
        zzzf.zzb(zzyz.zza, zzd());
    }
}
