package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

final class zzbsm extends zzbsh {
    final /* synthetic */ UpdateClickUrlCallback zza;

    zzbsm(zzbsq zzbsq, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza = updateClickUrlCallback;
    }

    public final void zze(String str) {
        this.zza.onFailure(str);
    }

    public final void zzf(List list) {
        this.zza.onSuccess((Uri) list.get(0));
    }
}
