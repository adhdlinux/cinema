package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

public final /* synthetic */ class zzad implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzad(zzas zzas, String str) {
        this.zza = zzas;
        this.zzb = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzi(this.zzb, dialogInterface, i2);
    }
}
