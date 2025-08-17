package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;

public final /* synthetic */ class zzebg implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzebl zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzl zzc;
    public final /* synthetic */ zzbr zzd;

    public /* synthetic */ zzebg(zzebl zzebl, Activity activity, zzl zzl, zzbr zzbr) {
        this.zza = zzebl;
        this.zzb = activity;
        this.zzc = zzl;
        this.zzd = zzbr;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzl(this.zzb, this.zzc, this.zzd, dialogInterface, i2);
    }
}
