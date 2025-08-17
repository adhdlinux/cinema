package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import java.util.regex.Pattern;

public final class zzffx {
    public static void zza(zzfwm zzfwm, zzffy zzffy, zzffn zzffn) {
        zzg(zzfwm, zzffy, zzffn, false);
    }

    public static void zzb(zzfwm zzfwm, zzffy zzffy, zzffn zzffn) {
        zzg(zzfwm, zzffy, zzffn, true);
    }

    public static void zzc(zzfwm zzfwm, zzffy zzffy, zzffn zzffn) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            zzfwc.zzq(zzfvt.zzv(zzfwm), new zzffw(zzffy, zzffn), zzcae.zzf);
        }
    }

    public static void zzd(zzfwm zzfwm, zzffn zzffn) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            zzfwc.zzq(zzfvt.zzv(zzfwm), new zzffu(zzffn), zzcae.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) zzba.zzc().zzb(zzbbm.zzio), str);
    }

    public static int zzf(zzfai zzfai) {
        int zze = zzf.zze(zzfai) - 1;
        return (zze == 0 || zze == 1) ? 7 : 23;
    }

    private static void zzg(zzfwm zzfwm, zzffy zzffy, zzffn zzffn, boolean z2) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            zzfwc.zzq(zzfvt.zzv(zzfwm), new zzffv(zzffy, zzffn, z2), zzcae.zzf);
        }
    }
}
