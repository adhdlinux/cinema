package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzedq implements zzdew {
    public final /* synthetic */ zzcaj zza;

    public /* synthetic */ zzedq(zzcaj zzcaj) {
        this.zza = zzcaj;
    }

    public final void zza(boolean z2, Context context, zzcvt zzcvt) {
        zzcaj zzcaj = this.zza;
        try {
            zzt.zzi();
            zzm.zza(context, (AdOverlayInfoParcel) zzcaj.get(), true);
        } catch (Exception unused) {
        }
    }
}
