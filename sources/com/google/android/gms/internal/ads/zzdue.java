package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzdue implements Callable {
    public final /* synthetic */ CookieManager zza;

    public /* synthetic */ zzdue(CookieManager cookieManager) {
        this.zza = cookieManager;
    }

    public final Object call() {
        CookieManager cookieManager = this.zza;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie((String) zzba.zzc().zzb(zzbbm.zzaK));
    }
}
