package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import java.util.concurrent.Executor;

public final class zzedr implements zzecc {
    private final Context zza;
    private final zzdeo zzb;
    private final Executor zzc;
    private final zzezm zzd;

    public zzedr(Context context, Executor executor, zzdeo zzdeo, zzezm zzezm) {
        this.zza = context;
        this.zzb = zzdeo;
        this.zzc = executor;
        this.zzd = zzezm;
    }

    private static String zzd(zzezn zzezn) {
        try {
            return zzezn.zzw.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        Uri uri;
        String zzd2 = zzd(zzezn);
        if (zzd2 != null) {
            uri = Uri.parse(zzd2);
        } else {
            uri = null;
        }
        return zzfwc.zzm(zzfwc.zzh((Object) null), new zzedp(this, uri, zzezz, zzezn), this.zzc);
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        Context context = this.zza;
        if (!(context instanceof Activity) || !zzbcn.zzg(context) || TextUtils.isEmpty(zzd(zzezn))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(Uri uri, zzezz zzezz, zzezn zzezn, Object obj) throws Exception {
        try {
            CustomTabsIntent a2 = new CustomTabsIntent.Builder().a();
            a2.f1615a.setData(uri);
            zzc zzc2 = new zzc(a2.f1615a, (zzx) null);
            zzcaj zzcaj = new zzcaj();
            zzddo zze = this.zzb.zze(new zzcrs(zzezz, zzezn, (String) null), new zzddr(new zzedq(zzcaj), (zzcez) null));
            zzcaj.zzd(new AdOverlayInfoParcel(zzc2, (zza) null, (zzo) zze.zza(), (zzz) null, new zzbzx(0, 0, false, false, false), (zzcez) null, (zzdcu) null));
            this.zzd.zza();
            return zzfwc.zzh(zze.zzg());
        } catch (Throwable th) {
            zzbzr.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
