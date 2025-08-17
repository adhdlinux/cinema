package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdfu implements zzbij {
    private final WeakReference zza;

    /* synthetic */ zzdfu(zzdfx zzdfx, zzdft zzdft) {
        this.zza = new WeakReference(zzdfx);
    }

    public final void zza(Object obj, Map map) {
        zzdfx zzdfx = (zzdfx) this.zza.get();
        if (zzdfx != null) {
            zzdfx.zzh.onAdClicked();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
                zzdfx.zzi.zzr();
                if (!TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    zzdfx.zzi.zzs();
                }
            }
        }
    }
}
