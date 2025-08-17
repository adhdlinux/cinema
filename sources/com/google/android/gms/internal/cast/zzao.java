package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.view.ViewGroup;

public final /* synthetic */ class zzao implements Runnable {
    public final /* synthetic */ zzaq zza;
    public final /* synthetic */ Activity zzb;

    public /* synthetic */ zzao(zzaq zzaq, Activity activity) {
        this.zza = zzaq;
        this.zzb = activity;
    }

    public final void run() {
        zzaq zzaq = this.zza;
        Activity activity = this.zzb;
        if (zzaq.zzc.zzf) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(zzaq.zzc);
            zzar zzar = zzaq.zzc;
            if (zzar.zzc != null) {
                zzar.zzc.onOverlayDismissed();
            }
            zzaq.zzc.zzd();
        }
    }
}
