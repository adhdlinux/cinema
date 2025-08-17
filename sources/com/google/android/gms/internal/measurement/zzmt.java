package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class zzmt extends zzmu {
    zzmt(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j2) {
        return Double.longBitsToDouble(zzk(obj, j2));
    }

    public final float zzb(Object obj, long j2) {
        return Float.intBitsToFloat(zzj(obj, j2));
    }

    public final void zzc(Object obj, long j2, boolean z2) {
        if (zzmv.zzb) {
            zzmv.zzD(obj, j2, r3 ? (byte) 1 : 0);
        } else {
            zzmv.zzE(obj, j2, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j2, byte b2) {
        if (zzmv.zzb) {
            zzmv.zzD(obj, j2, b2);
        } else {
            zzmv.zzE(obj, j2, b2);
        }
    }

    public final void zze(Object obj, long j2, double d2) {
        zzo(obj, j2, Double.doubleToLongBits(d2));
    }

    public final void zzf(Object obj, long j2, float f2) {
        zzn(obj, j2, Float.floatToIntBits(f2));
    }

    public final boolean zzg(Object obj, long j2) {
        if (zzmv.zzb) {
            return zzmv.zzt(obj, j2);
        }
        return zzmv.zzu(obj, j2);
    }
}
