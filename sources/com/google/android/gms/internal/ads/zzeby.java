package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

public final class zzeby implements zzebz {
    static /* synthetic */ zzfgw zzc(String str, String str2, String str3, zzeca zzeca, String str4, WebView webView, String str5, String str6, zzecb zzecb) {
        zzfhf zza = zzfhf.zza("Google", str2);
        zzfhe zzm = zzm("javascript");
        zzfhb zzk = zzk(zzeca.toString());
        zzfhe zzfhe = zzfhe.NONE;
        if (zzm == zzfhe) {
            zzbzr.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzk == null) {
            zzbzr.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(zzeca)));
            return null;
        } else {
            zzfhe zzm2 = zzm(str4);
            if (zzk == zzfhb.VIDEO && zzm2 == zzfhe) {
                zzbzr.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
                return null;
            }
            return zzfgw.zza(zzfgx.zza(zzk, zzl(zzecb.toString()), zzm, zzm2, true), zzfgy.zzb(zza, webView, str5, ""));
        }
    }

    static /* synthetic */ zzfgw zzd(String str, String str2, String str3, String str4, zzeca zzeca, WebView webView, String str5, String str6, zzecb zzecb) {
        zzfhf zza = zzfhf.zza(str, str2);
        zzfhe zzm = zzm("javascript");
        zzfhe zzm2 = zzm(str4);
        zzfhb zzk = zzk(zzeca.toString());
        zzfhe zzfhe = zzfhe.NONE;
        if (zzm == zzfhe) {
            zzbzr.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzk == null) {
            zzbzr.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(zzeca)));
            return null;
        } else if (zzk == zzfhb.VIDEO && zzm2 == zzfhe) {
            zzbzr.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        } else {
            return zzfgw.zza(zzfgx.zza(zzk, zzl(zzecb.toString()), zzm, zzm2, true), zzfgy.zzc(zza, webView, str5, ""));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfhb zzk(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzfhb r4 = com.google.android.gms.internal.ads.zzfhb.VIDEO
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzfhb r4 = com.google.android.gms.internal.ads.zzfhb.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzfhb r4 = com.google.android.gms.internal.ads.zzfhb.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeby.zzk(java.lang.String):com.google.android.gms.internal.ads.zzfhb");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfhd zzl(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfhd r4 = com.google.android.gms.internal.ads.zzfhd.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfhd r4 = com.google.android.gms.internal.ads.zzfhd.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfhd r4 = com.google.android.gms.internal.ads.zzfhd.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfhd r4 = com.google.android.gms.internal.ads.zzfhd.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeby.zzl(java.lang.String):com.google.android.gms.internal.ads.zzfhd");
    }

    private static zzfhe zzm(String str) {
        if ("native".equals(str)) {
            return zzfhe.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfhe.JAVASCRIPT;
        }
        return zzfhe.NONE;
    }

    private static final Object zzn(zzebx zzebx) {
        try {
            return zzebx.zza();
        } catch (RuntimeException e2) {
            zzt.zzo().zzt(e2, "omid exception");
            return null;
        }
    }

    private static final void zzo(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e2) {
            zzt.zzo().zzt(e2, "omid exception");
        }
    }

    public final zzfgw zza(String str, WebView webView, String str2, String str3, String str4, zzecb zzecb, zzeca zzeca, String str5) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue() || !zzfgu.zzb()) {
            return null;
        }
        return (zzfgw) zzn(new zzebu("Google", str, "javascript", zzeca, str4, webView, str5, "", zzecb));
    }

    public final zzfgw zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzecb zzecb, zzeca zzeca, String str6) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue() || !zzfgu.zzb()) {
            return null;
        }
        return (zzfgw) zzn(new zzebv(str5, str, "javascript", str4, zzeca, webView, str6, "", zzecb));
    }

    public final String zze(Context context) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue()) {
            return null;
        }
        return (String) zzn(zzebr.zza);
    }

    public final void zzf(zzfgw zzfgw, View view) {
        zzo(new zzebq(zzfgw, view));
    }

    public final void zzg(zzfgw zzfgw) {
        zzo(new zzebt(zzfgw));
    }

    public final void zzh(zzfgw zzfgw, View view) {
        zzo(new zzebp(zzfgw, view));
    }

    public final void zzi(zzfgw zzfgw) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue() && zzfgu.zzb()) {
            zzfgw.getClass();
            zzo(new zzebs(zzfgw));
        }
    }

    public final boolean zzj(Context context) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeM)).booleanValue()) {
            zzbzr.zzj("Omid flag is disabled");
            return false;
        }
        Boolean bool = (Boolean) zzn(new zzebw(context));
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }
}
