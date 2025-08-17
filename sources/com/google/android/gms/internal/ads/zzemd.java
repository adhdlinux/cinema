package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzemd implements zzeqx {
    final String zza;
    final int zzb;

    public zzemd(String str, int i2) {
        this.zza = str;
        this.zzb = i2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.zza) && this.zzb != -1) {
            Bundle zza2 = zzfat.zza(bundle, "pii");
            bundle.putBundle("pii", zza2);
            zza2.putString("pvid", this.zza);
            zza2.putInt("pvid_s", this.zzb);
        }
    }
}
