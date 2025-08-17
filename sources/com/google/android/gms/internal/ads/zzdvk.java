package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzaz;

public final class zzdvk extends zzbtz {
    final /* synthetic */ zzdvl zza;

    protected zzdvk(zzdvl zzdvl) {
        this.zza = zzdvl;
    }

    public final void zze(zzaz zzaz) {
        this.zza.zza.zze(zzaz.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzd(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
