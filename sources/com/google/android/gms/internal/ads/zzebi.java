package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;

public final /* synthetic */ class zzebi implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzebl zza;
    public final /* synthetic */ zzl zzb;

    public /* synthetic */ zzebi(zzebl zzebl, zzl zzl) {
        this.zza = zzebl;
        this.zzb = zzl;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzn(this.zzb, dialogInterface);
    }
}
