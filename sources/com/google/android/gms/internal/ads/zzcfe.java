package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;

final class zzcfe implements zzfvy {
    final /* synthetic */ List zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Uri zzc;
    final /* synthetic */ zzcfg zzd;

    zzcfe(zzcfg zzcfg, List list, String str, Uri uri) {
        this.zzd = zzcfg;
        this.zza = list;
        this.zzb = str;
        this.zzc = uri;
    }

    public final void zza(Throwable th) {
        zzbzr.zzj("Failed to parse gmsg params for: ".concat(String.valueOf(this.zzc)));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzP((Map) obj, this.zza, this.zzb);
    }
}
