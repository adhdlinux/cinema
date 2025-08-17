package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

final class zzbqm implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbqo zza;

    zzbqm(zzbqo zzbqo) {
        this.zza = zzbqo;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        Intent zzb = this.zza.zzb();
        zzt.zzp();
        zzs.zzP(this.zza.zzb, zzb);
    }
}
