package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzgso extends zzgsp {
    zzgso(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(long j2) {
        return Memory.peekByte(j2);
    }

    public final double zzb(Object obj, long j2) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j2));
    }

    public final float zzc(Object obj, long j2) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j2));
    }

    public final void zzd(long j2, byte[] bArr, long j3, long j4) {
        Memory.peekByteArray(j2, bArr, (int) j3, (int) j4);
    }

    public final void zze(Object obj, long j2, boolean z2) {
        if (zzgsq.zzb) {
            zzgsq.zzG(obj, j2, r3 ? (byte) 1 : 0);
        } else {
            zzgsq.zzH(obj, j2, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzf(Object obj, long j2, byte b2) {
        if (zzgsq.zzb) {
            zzgsq.zzG(obj, j2, b2);
        } else {
            zzgsq.zzH(obj, j2, b2);
        }
    }

    public final void zzg(Object obj, long j2, double d2) {
        this.zza.putLong(obj, j2, Double.doubleToLongBits(d2));
    }

    public final void zzh(Object obj, long j2, float f2) {
        this.zza.putInt(obj, j2, Float.floatToIntBits(f2));
    }

    public final boolean zzi(Object obj, long j2) {
        if (zzgsq.zzb) {
            return zzgsq.zzw(obj, j2);
        }
        return zzgsq.zzx(obj, j2);
    }
}
