package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

public final /* synthetic */ class zzw implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ zzx zza;
    public final /* synthetic */ Activity zzb;

    public /* synthetic */ zzw(zzx zzx, Activity activity) {
        this.zza = zzx;
        this.zzb = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzx.zzm(this.zzb, view, windowInsets);
    }
}
