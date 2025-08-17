package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;

public final class zzph {
    private Boolean zza;

    public zzph() {
    }

    public zzph(Context context) {
    }

    public final zzoh zza(zzam zzam, zzk zzk) {
        zzam.getClass();
        zzk.getClass();
        int i2 = zzfj.zza;
        if (i2 < 29 || zzam.zzA == -1) {
            return zzoh.zza;
        }
        Boolean bool = this.zza;
        if (bool != null) {
            bool.booleanValue();
        } else {
            Boolean bool2 = Boolean.FALSE;
            this.zza = bool2;
            bool2.booleanValue();
        }
        String str = zzam.zzm;
        str.getClass();
        int zza2 = zzcc.zza(str, zzam.zzj);
        if (zza2 == 0) {
            return zzoh.zza;
        }
        if (i2 < 34 && zza2 == 30) {
            return zzoh.zza;
        }
        int zzf = zzfj.zzf(zzam.zzz);
        if (zzf == 0) {
            return zzoh.zza;
        }
        AudioFormat zzs = zzfj.zzs(zzam.zzA, zzf, zza2);
        if (i2 >= 31) {
            return zzpg.zza(zzs, zzk.zza().zza, false);
        }
        return zzpf.zza(zzs, zzk.zza().zza, false);
    }
}
