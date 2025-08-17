package com.google.android.gms.internal.auth;

final class zzfn implements zzfu {
    private final zzfu[] zza;

    zzfn(zzfu... zzfuArr) {
        this.zza = zzfuArr;
    }

    public final zzft zzb(Class cls) {
        zzfu[] zzfuArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            zzfu zzfu = zzfuArr[i2];
            if (zzfu.zzc(cls)) {
                return zzfu.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzfu[] zzfuArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzfuArr[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
