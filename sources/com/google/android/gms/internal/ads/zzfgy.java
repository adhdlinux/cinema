package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzfgy {
    private final zzfhf zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfgz zzg;

    private zzfgy(zzfhf zzfhf, WebView webView, String str, List list, String str2, String str3, zzfgz zzfgz) {
        this.zza = zzfhf;
        this.zzb = webView;
        this.zzg = zzfgz;
        this.zzf = str2;
        this.zze = "";
    }

    public static zzfgy zzb(zzfhf zzfhf, WebView webView, String str, String str2) {
        return new zzfgy(zzfhf, webView, (String) null, (List) null, str, "", zzfgz.HTML);
    }

    public static zzfgy zzc(zzfhf zzfhf, WebView webView, String str, String str2) {
        return new zzfgy(zzfhf, webView, (String) null, (List) null, str, "", zzfgz.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfgz zzd() {
        return this.zzg;
    }

    public final zzfhf zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
