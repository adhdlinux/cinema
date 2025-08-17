package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

public final /* synthetic */ class zzap implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ int zzf;

    public /* synthetic */ zzap(zzas zzas, int i2, int i3, int i4, int i5, int i6) {
        this.zza = zzas;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dialogInterface, i2);
    }
}
