package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;

public final /* synthetic */ class zzffm {
    public static zzffn zza(Context context, int i2) {
        boolean z2;
        if (zzfgb.zza()) {
            int i3 = i2 - 2;
            if (i3 != 20 && i3 != 21) {
                switch (i3) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        z2 = ((Boolean) zzbcy.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        z2 = ((Boolean) zzbcy.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        z2 = ((Boolean) zzbcy.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                z2 = ((Boolean) zzbcy.zze.zze()).booleanValue();
            }
            if (z2) {
                return new zzffp(context, i2);
            }
        }
        return new zzfgk();
    }

    public static zzffn zzb(Context context, int i2, int i3, zzl zzl) {
        zzffn zza = zza(context, i2);
        if (!(zza instanceof zzffp)) {
            return zza;
        }
        zza.zzh();
        zza.zzm(i3);
        if (zzffx.zze(zzl.zzp)) {
            zza.zze(zzl.zzp);
        }
        return zza;
    }
}
