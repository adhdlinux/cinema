package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(21)
public final class zzcgd extends zzcgc {
    public zzcgd(zzcez zzcez, zzawz zzawz, boolean z2, zzebl zzebl) {
        super(zzcez, zzawz, z2, zzebl);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzN(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
