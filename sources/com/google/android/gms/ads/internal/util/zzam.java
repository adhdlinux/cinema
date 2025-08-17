package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

public final /* synthetic */ class zzam implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzas zza;

    public /* synthetic */ zzam(zzas zzas) {
        this.zza = zzas;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzr();
    }
}
