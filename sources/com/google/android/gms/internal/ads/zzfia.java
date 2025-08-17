package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzfia extends zzfhx {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzfia(Map map, String str) {
        this.zzc = map;
    }

    public final void zzc() {
        long j2;
        super.zzc();
        if (this.zzb == null) {
            j2 = 4000;
        } else {
            j2 = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzfhz(this), Math.max(4000 - j2, 2000));
        this.zza = null;
    }

    public final void zzf(zzfha zzfha, zzfgy zzfgy) {
        JSONObject jSONObject = new JSONObject();
        Map zzi = zzfgy.zzi();
        for (String str : zzi.keySet()) {
            zzfib.zze(jSONObject, str, (zzfhg) zzi.get(str));
        }
        zzg(zzfha, zzfgy, jSONObject);
    }

    public final void zzj() {
        WebView webView = new WebView(zzfho.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        zzi(this.zza);
        WebView webView2 = this.zza;
        if (webView2 != null && !TextUtils.isEmpty((CharSequence) null)) {
            webView2.loadUrl("javascript: null");
        }
        Iterator it2 = this.zzc.keySet().iterator();
        if (!it2.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzfhg zzfhg = (zzfhg) this.zzc.get((String) it2.next());
        throw null;
    }
}
