package com.google.android.gms.internal.cast;

public final class zznz extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznz zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zznz zznz = new zznz();
        zzb = zznz;
        zzsh.zzG(zznz.class, zznz);
    }

    private zznz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002င\u0001\u0003ဌ\u0002", new Object[]{"zzd", "zze", zzjc.zza(), "zzf", "zzg", zzlt.zza()});
        } else if (i3 == 3) {
            return new zznz();
        } else {
            if (i3 == 4) {
                return new zzny((zzlu) null);
            }
            if (i3 == 5) {
                return zzb;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzh = b2;
            return null;
        }
    }
}
