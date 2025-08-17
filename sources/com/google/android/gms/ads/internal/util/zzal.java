package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class zzal implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ AtomicInteger zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;

    public /* synthetic */ zzal(zzas zzas, AtomicInteger atomicInteger, int i2, int i3, int i4) {
        this.zza = zzas;
        this.zzb = atomicInteger;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze, dialogInterface, i2);
    }
}
