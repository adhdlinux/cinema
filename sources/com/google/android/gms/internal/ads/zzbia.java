package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Map;

final class zzbia implements zzbij {
    zzbia() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        if (zzcez.zzJ() != null) {
            zzcez.zzJ().zza();
        }
        zzl zzL = zzcez.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        zzl zzM = zzcez.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            zzbzr.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
