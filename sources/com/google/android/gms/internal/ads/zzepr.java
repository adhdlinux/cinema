package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzepr implements zzeqx {
    private final String zza;
    private final String zzb;

    public zzepr(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgJ)).booleanValue()) {
            bundle.putString("request_id", this.zzb);
        } else {
            bundle.putString("request_id", this.zza);
        }
    }
}
