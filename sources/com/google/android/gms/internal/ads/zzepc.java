package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.vungle.ads.internal.Constants;
import java.util.Set;

public final class zzepc implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;
    private final Set zzc;

    public zzepc(zzfwn zzfwn, Context context, Set set) {
        this.zza = zzfwn;
        this.zzb = context;
        this.zzc = set;
    }

    public final int zza() {
        return 27;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzepb(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepd zzc() throws Exception {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue()) {
            Set set = this.zzc;
            if (set.contains(Constants.PLACEMENT_TYPE_REWARDED) || set.contains(Constants.PLACEMENT_TYPE_INTERSTITIAL) || set.contains("native") || set.contains("banner")) {
                return new zzepd(zzt.zzA().zze(this.zzb));
            }
        }
        return new zzepd((String) null);
    }
}
