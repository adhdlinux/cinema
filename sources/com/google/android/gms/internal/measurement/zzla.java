package com.google.android.gms.internal.measurement;

final class zzla implements zzlh {
    private final zzlh[] zza;

    zzla(zzlh... zzlhArr) {
        this.zza = zzlhArr;
    }

    public final zzlg zzb(Class cls) {
        zzlh[] zzlhArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            zzlh zzlh = zzlhArr[i2];
            if (zzlh.zzc(cls)) {
                return zzlh.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzlh[] zzlhArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzlhArr[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
