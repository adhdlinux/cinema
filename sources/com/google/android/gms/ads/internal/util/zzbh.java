package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzbzr;

final class zzbh implements zzalo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbl zzb;

    zzbh(zzbo zzbo, String str, zzbl zzbl) {
        this.zza = str;
        this.zzb = zzbl;
    }

    public final void zza(zzalt zzalt) {
        String str = this.zza;
        String obj = zzalt.toString();
        zzbzr.zzj("Failed to load URL: " + str + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + obj);
        this.zzb.zza((Object) null);
    }
}
