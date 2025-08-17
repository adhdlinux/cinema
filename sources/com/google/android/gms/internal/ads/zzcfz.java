package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;

public final class zzcfz {
    private final zzcga zza;
    private final zzcfy zzb;

    public zzcfz(zzcga zzcga, zzcfy zzcfy) {
        this.zzb = zzcfy;
        this.zza = zzcga;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcgh, com.google.android.gms.internal.ads.zzcga] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ? r02 = this.zza;
        zzaqs zzI = r02.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaqo zzc = zzI.zzc();
        if (r02.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        }
        Context context = this.zza.getContext();
        zzcga zzcga = this.zza;
        return zzc.zzf(context, str, (View) zzcga, zzcga.zzi());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcgh, com.google.android.gms.internal.ads.zzcga] */
    @JavascriptInterface
    public String getViewSignals() {
        ? r02 = this.zza;
        zzaqs zzI = r02.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaqo zzc = zzI.zzc();
        if (r02.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        }
        Context context = this.zza.getContext();
        zzcga zzcga = this.zza;
        return zzc.zzh(context, (View) zzcga, zzcga.zzi());
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbzr.zzj("URL is empty, ignoring message");
        } else {
            zzs.zza.post(new zzcfx(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        zzcfy zzcfy = this.zzb;
        Uri parse = Uri.parse(str);
        zzcfg zzaJ = ((zzcfs) zzcfy.zza).zzaJ();
        if (zzaJ == null) {
            zzbzr.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaJ.zzj(parse);
        }
    }
}
