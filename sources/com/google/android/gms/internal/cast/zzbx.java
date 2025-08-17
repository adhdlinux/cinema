package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzbx implements zza {
    final /* synthetic */ zzbz zza;

    zzbx(zzbz zzbz) {
        this.zza = zzbz;
    }

    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            zzbz zzbz = this.zza;
            if (zzbz.zzd != null) {
                zzbz.zzd.setVisibility(4);
            }
            this.zza.zza.setVisibility(0);
            this.zza.zza.setImageBitmap(bitmap);
            zzbz zzbz2 = this.zza;
            if (zzbz2.zzf != null) {
                zzbz2.zzf.zza();
            }
        }
    }
}
