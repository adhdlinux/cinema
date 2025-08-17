package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class zzeb implements InitializationStatus {
    public final /* synthetic */ zzej zza;

    public /* synthetic */ zzeb(zzej zzej) {
        this.zza = zzej;
    }

    public final Map getAdapterStatusMap() {
        zzej zzej = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzee(zzej));
        return hashMap;
    }
}
