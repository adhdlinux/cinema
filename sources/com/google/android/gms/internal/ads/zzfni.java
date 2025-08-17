package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzfni extends zzfnu {
    final /* synthetic */ zzfnj zza;
    private final zzfno zzb;

    zzfni(zzfnj zzfnj, zzfno zzfno) {
        this.zza = zzfnj;
        this.zzb = zzfno;
    }

    public final void zzb(Bundle bundle) {
        int i2 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfnm zzc = zzfnn.zzc();
        zzc.zzb(i2);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i2 == 8157) {
            this.zza.zzc();
        }
    }
}
