package com.google.android.gms.internal.cast;

final class zztg implements zztn {
    private final zztn[] zza;

    zztg(zztn... zztnArr) {
        this.zza = zztnArr;
    }

    public final zztm zzb(Class cls) {
        zztn[] zztnArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            zztn zztn = zztnArr[i2];
            if (zztn.zzc(cls)) {
                return zztn.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zztn[] zztnArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zztnArr[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
