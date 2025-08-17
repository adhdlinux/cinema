package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONObject;

public final class zzfhq {
    private static final zzfhq zza = new zzfhq();

    private zzfhq() {
    }

    public static final zzfhq zza() {
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            if (r6 > 0) {
                for (Object obj : objArr) {
                    if (obj == null) {
                        sb.append("\"\"");
                    } else if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                            sb.append('\"');
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.setLength(sb.length() - 1);
            }
            sb.append(")}");
            String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
            } else {
                handler.post(new zzfhp(this, webView, sb2));
            }
        } else {
            zzfgt.zza.booleanValue();
        }
    }

    public final void zzc(WebView webView) {
        zzb(webView, "finishSession", new Object[0]);
    }

    public final void zzd(WebView webView, JSONObject jSONObject) {
        zzb(webView, "init", jSONObject);
    }

    public final void zze(WebView webView, float f2) {
        zzb(webView, "setDeviceVolume", Float.valueOf(f2));
    }

    public final void zzf(WebView webView, String str) {
        zzb(webView, "setNativeViewHierarchy", str);
    }

    public final void zzg(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzb(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }
}
