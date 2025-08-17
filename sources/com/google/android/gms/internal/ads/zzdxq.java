package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzaz;

public final class zzdxq extends zzbtw {
    final /* synthetic */ zzdxr zza;

    protected zzdxq(zzdxr zzdxr) {
        this.zza = zzdxr;
    }

    public final void zze(zzaz zzaz) {
        this.zza.zza.zze(zzaz.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzd(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
