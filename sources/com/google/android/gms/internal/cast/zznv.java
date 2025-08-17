package com.google.android.gms.internal.cast;

public final class zznv extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznv zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zznr zzg;

    static {
        zznv zznv = new zznv();
        zzb = zznv;
        zzsh.zzG(zznv.class, zznv);
    }

    private zznv() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zznv();
        } else {
            if (i3 == 4) {
                return new zznu((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
