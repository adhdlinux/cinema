package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.Cast;

final class zzl extends Cast.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    zzl(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    public final void onDeviceNameChanged() {
        this.zza.zzn();
    }
}
