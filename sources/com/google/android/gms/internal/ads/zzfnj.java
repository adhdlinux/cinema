package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

@SuppressLint({"RestrictedApi"})
@TargetApi(18)
final class zzfnj {
    /* access modifiers changed from: private */
    public static final zzfnw zzb = new zzfnw("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzfoh zza;
    /* access modifiers changed from: private */
    public final String zzd;

    zzfnj(Context context) {
        if (zzfok.zza(context)) {
            this.zza = new zzfoh(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, zzfne.zza, (zzfoc) null);
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zza != null) {
            zzb.zzc("unbind LMD display overlay service", new Object[0]);
            this.zza.zzu();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzfna zzfna, zzfno zzfno) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzfng(this, taskCompletionSource, zzfna, zzfno, taskCompletionSource), taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfnl zzfnl, zzfno zzfno) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else if (zzfnl.zzg() == null) {
            zzb.zza("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzfnm zzc2 = zzfnn.zzc();
            zzc2.zzb(8160);
            zzfno.zza(zzc2.zzc());
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfnf(this, taskCompletionSource, zzfnl, zzfno, taskCompletionSource), taskCompletionSource);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzfnq zzfnq, zzfno zzfno, int i2) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzfnh(this, taskCompletionSource, zzfnq, i2, zzfno, taskCompletionSource), taskCompletionSource);
    }
}
