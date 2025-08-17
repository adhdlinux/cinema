package com.google.android.gms.internal.cast;

public final class zznf extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznf zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznf zznf = new zznf();
        zzb = zznf;
        zzsh.zzG(zznf.class, zznf);
    }

    private zznf() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zznf();
        } else {
            if (i3 == 4) {
                return new zzne((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
