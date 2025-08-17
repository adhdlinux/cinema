package com.google.android.gms.internal.cast;

public final class zzon extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzon zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzon zzon = new zzon();
        zzb = zzon;
        zzsh.zzG(zzon.class, zzon);
    }

    private zzon() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzon();
        } else {
            if (i3 == 4) {
                return new zzom((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
