package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.vungle.ads.internal.Constants;
import java.io.File;
import java.util.Collections;
import java.util.Map;

public class zzcgc extends zzcfg {
    public zzcgc(zzcez zzcez, zzawz zzawz, boolean z2, zzebl zzebl) {
        super(zzcez, zzawz, z2, new zzbqv(zzcez, zzcez.zzE(), new zzbaw(zzcez.getContext())), (zzbqq) null, zzebl);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzN(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcez)) {
            zzbzr.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcez zzcez = (zzcez) webView;
        zzbws zzbws = this.zza;
        if (zzbws != null) {
            zzbws.zzd(str, map, 1);
        }
        if (!Constants.AD_MRAID_JS_FILE_NAME.equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcez.zzN() != null) {
            zzcez.zzN().zzE();
        }
        if (zzcez.zzO().zzi()) {
            str2 = (String) zzba.zzc().zzb(zzbbm.zzP);
        } else if (zzcez.zzaA()) {
            str2 = (String) zzba.zzc().zzb(zzbbm.zzO);
        } else {
            str2 = (String) zzba.zzc().zzb(zzbbm.zzN);
        }
        zzt.zzp();
        return zzs.zzt(zzcez.getContext(), zzcez.zzn().zza, str2);
    }
}
