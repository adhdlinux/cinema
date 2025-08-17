package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;

public final /* synthetic */ class zzebh implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzebl zza;
    public final /* synthetic */ zzl zzb;

    public /* synthetic */ zzebh(zzebl zzebl, zzl zzl) {
        this.zza = zzebl;
        this.zzb = zzl;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzm(this.zzb, dialogInterface, i2);
    }
}
