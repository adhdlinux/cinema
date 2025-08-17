package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.TimeUnit;

public final class zzduh implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzduh(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CookieManager zzb2 = zzt.zzq().zzb((Context) this.zzb.zzb());
        zzfef zzfef = zzfef.WEBVIEW_COOKIE;
        return zzfdv.zza(new zzdue(zzb2), zzfef, (zzfel) this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfdy(zzduf.zza)).zza();
    }
}
