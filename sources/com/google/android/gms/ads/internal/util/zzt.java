package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcgd;
import com.google.android.gms.internal.ads.zzebl;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public class zzt extends zzaa {
    public zzt() {
        super((zzz) null);
    }

    public final int zza() {
        return 16974374;
    }

    public final CookieManager zzb(Context context) {
        com.google.android.gms.ads.internal.zzt.zzp();
        if (zzs.zzB()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbzr.zzh("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final WebResourceResponse zzc(String str, String str2, int i2, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i2, str3, map, inputStream);
    }

    public final zzcfg zzd(zzcez zzcez, zzawz zzawz, boolean z2, zzebl zzebl) {
        return new zzcgd(zzcez, zzawz, z2, zzebl);
    }
}
