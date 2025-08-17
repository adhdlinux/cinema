package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

public final class zzcgb extends zzcgc {
    public zzcgb(zzcez zzcez, zzawz zzawz, boolean z2, zzebl zzebl) {
        super(zzcez, zzawz, z2, zzebl);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzN(webView, str, (Map) null);
    }
}
