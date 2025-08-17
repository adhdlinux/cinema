package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

final class zzhg extends zzhh {
    zzhg(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j2) {
        return Double.longBitsToDouble(zzj(obj, j2));
    }

    public final float zzb(Object obj, long j2) {
        return Float.intBitsToFloat(zzi(obj, j2));
    }

    public final void zzc(Object obj, long j2, boolean z2) {
        if (zzhi.zza) {
            zzhi.zzi(obj, j2, z2);
        } else {
            zzhi.zzj(obj, j2, z2);
        }
    }

    public final void zzd(Object obj, long j2, double d2) {
        zzn(obj, j2, Double.doubleToLongBits(d2));
    }

    public final void zze(Object obj, long j2, float f2) {
        zzm(obj, j2, Float.floatToIntBits(f2));
    }

    public final boolean zzf(Object obj, long j2) {
        if (zzhi.zza) {
            return zzhi.zzq(obj, j2);
        }
        return zzhi.zzr(obj, j2);
    }
}
