package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

final class zza extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ zzh zza;

    zza(zzh zzh) {
        this.zza = zzh;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        zzh zzh = this.zza;
        if (zzh.zzk == null) {
            return true;
        }
        if (zzh.zzd.contains(Math.round(x2), Math.round(y2)) && this.zza.zze.zzg(x2, y2)) {
            return true;
        }
        this.zza.zzk.zza();
        return true;
    }
}
