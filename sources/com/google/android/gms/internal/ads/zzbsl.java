package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

final class zzbsl extends zzbsh {
    final /* synthetic */ UpdateImpressionUrlsCallback zza;

    zzbsl(zzbsq zzbsq, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(String str) {
        this.zza.onFailure(str);
    }

    public final void zzf(List list) {
        this.zza.onSuccess(list);
    }
}
