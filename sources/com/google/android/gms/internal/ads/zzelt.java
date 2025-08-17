package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzw;
import com.uwetrottmann.trakt5.TraktV2;

public final class zzelt implements zzeqx {
    private final zzw zza;
    private final zzbzx zzb;
    private final boolean zzc;

    public zzelt(zzw zzw, zzbzx zzbzx, boolean z2) {
        this.zza = zzw;
        this.zzb = zzbzx;
        this.zzc = z2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) zzba.zzc().zzb(zzbbm.zzeX)).intValue()) {
            bundle.putString("app_open_version", TraktV2.API_VERSION);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeY)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        zzw zzw = this.zza;
        if (zzw != null) {
            int i2 = zzw.zza;
            if (i2 == 1) {
                bundle.putString("avo", ContextChain.TAG_PRODUCT);
            } else if (i2 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
