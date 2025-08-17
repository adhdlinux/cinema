package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzbqn implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbqo zza;

    zzbqn(zzbqo zzbqo) {
        this.zza = zzbqo;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzg("Operation denied by user.");
    }
}
