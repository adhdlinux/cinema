package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

final class zzdhz implements zzbee {
    final /* synthetic */ zzdiw zza;
    final /* synthetic */ ViewGroup zzb;

    zzdhz(zzdiw zzdiw, ViewGroup viewGroup) {
        this.zza = zzdiw;
        this.zzb = viewGroup;
    }

    public final JSONObject zza() {
        return this.zza.zzo();
    }

    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    public final void zzc() {
        zzdiw zzdiw = this.zza;
        zzfsc zzfsc = zzdhw.zza;
        Map zzm = zzdiw.zzm();
        if (zzm != null) {
            int size = zzfsc.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = zzm.get((String) zzfsc.get(i2));
                i2++;
                if (obj != null) {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }
}
