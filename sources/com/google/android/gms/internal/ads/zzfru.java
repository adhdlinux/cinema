package com.google.android.gms.internal.ads;

final class zzfru {
    static int zza(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
    }

    static int zzb(Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
