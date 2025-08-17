package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class zzdnb implements View.OnTouchListener {
    public final /* synthetic */ zzdnh zza;

    public /* synthetic */ zzdnb(zzdnh zzdnh) {
        this.zza = zzdnh;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
