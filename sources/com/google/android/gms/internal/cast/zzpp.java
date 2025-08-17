package com.google.android.gms.internal.cast;

public final class zzpp extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpp zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zzpp zzpp = new zzpp();
        zzb = zzpp;
        zzsh.zzG(zzpp.class, zzpp);
    }

    private zzpp() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", zzlk.zza(), "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzpp();
        } else {
            if (i3 == 4) {
                return new zzpo((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
