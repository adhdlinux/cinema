package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class zzfhx {
    private zzfiv zza = new zzfiv((WebView) null);
    private long zzb;
    private int zzc;

    public zzfhx() {
        zzb();
    }

    public final WebView zza() {
        return (WebView) this.zza.get();
    }

    public final void zzb() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }

    public void zzc() {
        this.zza.clear();
    }

    public final void zzd(String str, long j2) {
        if (j2 >= this.zzb && this.zzc != 3) {
            this.zzc = 3;
            zzfhq.zza().zzf(zza(), str);
        }
    }

    public final void zze(String str, long j2) {
        if (j2 >= this.zzb) {
            this.zzc = 2;
            zzfhq.zza().zzf(zza(), str);
        }
    }

    public void zzf(zzfha zzfha, zzfgy zzfgy) {
        zzg(zzfha, zzfgy, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public final void zzg(zzfha zzfha, zzfgy zzfgy, JSONObject jSONObject) {
        String zzh = zzfha.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfib.zze(jSONObject2, "environment", "app");
        zzfib.zze(jSONObject2, "adSessionType", zzfgy.zzd());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        zzfib.zze(jSONObject3, "deviceType", str + "; " + str2);
        zzfib.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfib.zze(jSONObject3, "os", "Android");
        zzfib.zze(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfib.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfib.zze(jSONObject4, "partnerName", zzfgy.zze().zzb());
        zzfib.zze(jSONObject4, "partnerVersion", zzfgy.zze().zzc());
        zzfib.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfib.zze(jSONObject5, "libraryVersion", "1.3.37-google_20220829");
        zzfib.zze(jSONObject5, "appId", zzfho.zzb().zza().getApplicationContext().getPackageName());
        zzfib.zze(jSONObject2, "app", jSONObject5);
        if (zzfgy.zzf() != null) {
            zzfib.zze(jSONObject2, "contentUrl", zzfgy.zzf());
        }
        zzfib.zze(jSONObject2, "customReferenceData", zzfgy.zzg());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it2 = zzfgy.zzh().iterator();
        if (!it2.hasNext()) {
            zzfhq.zza().zzg(zza(), zzh, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzfhg zzfhg = (zzfhg) it2.next();
            throw null;
        }
    }

    public final void zzh(float f2) {
        zzfhq.zza().zze(zza(), f2);
    }

    /* access modifiers changed from: package-private */
    public final void zzi(WebView webView) {
        this.zza = new zzfiv(webView);
    }

    public void zzj() {
    }

    public final boolean zzk() {
        return this.zza.get() != null;
    }
}
