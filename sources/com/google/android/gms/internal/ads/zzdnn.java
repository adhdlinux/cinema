package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdnn implements zzcwb {
    private final zzcez zza;

    zzdnn(zzcez zzcez) {
        this.zza = zzcez;
    }

    public final void zzbn(Context context) {
        zzcez zzcez = this.zza;
        if (zzcez != null) {
            zzcez.destroy();
        }
    }

    public final void zzbp(Context context) {
        zzcez zzcez = this.zza;
        if (zzcez != null) {
            zzcez.onPause();
        }
    }

    public final void zzbq(Context context) {
        zzcez zzcez = this.zza;
        if (zzcez != null) {
            zzcez.onResume();
        }
    }
}
