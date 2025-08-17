package com.google.android.gms.internal.ads;

final class zzgqn implements zzgqu {
    private final zzgqu[] zza;

    zzgqn(zzgqu... zzgquArr) {
        this.zza = zzgquArr;
    }

    public final zzgqt zzb(Class cls) {
        zzgqu[] zzgquArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            zzgqu zzgqu = zzgquArr[i2];
            if (zzgqu.zzc(cls)) {
                return zzgqu.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzgqu[] zzgquArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzgquArr[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
