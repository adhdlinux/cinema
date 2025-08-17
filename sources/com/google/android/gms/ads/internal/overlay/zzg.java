package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzas;

final class zzg extends RelativeLayout {
    final zzas zza;
    boolean zzb;

    public zzg(Context context, String str, String str2, String str3) {
        super(context);
        zzas zzas = new zzas(context, str);
        this.zza = zzas;
        zzas.zzo(str2);
        zzas.zzn(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zzm(motionEvent);
        return false;
    }
}
