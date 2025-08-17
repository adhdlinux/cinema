package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzbqs implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbqt zza;

    zzbqs(zzbqt zzbqt) {
        this.zza = zzbqt;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzg("User canceled the download.");
    }
}
