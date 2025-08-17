package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbcl;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzgws;

final class zzn implements zzbcl {
    final /* synthetic */ zzbcn zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzn(zzs zzs, zzbcn zzbcn, Context context, Uri uri) {
        this.zza = zzbcn;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent a2 = new CustomTabsIntent.Builder(this.zza.zza()).a();
        a2.f1615a.setPackage(zzgws.zza(this.zzb));
        a2.a(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
