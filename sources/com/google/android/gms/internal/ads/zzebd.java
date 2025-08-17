package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;

public final /* synthetic */ class zzebd implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzebl zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzbr zzc;
    public final /* synthetic */ zzl zzd;

    public /* synthetic */ zzebd(zzebl zzebl, Activity activity, zzbr zzbr, zzl zzl) {
        this.zza = zzebl;
        this.zzb = activity;
        this.zzc = zzbr;
        this.zzd = zzl;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzd(this.zzb, this.zzc, this.zzd, dialogInterface, i2);
    }
}
