package com.google.android.gms.internal.cast;

public final class zzoh extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzoh zzb;
    private int zzd;
    private long zze;
    private zzso zzf = zzsh.zzy();
    private zzso zzg = zzsh.zzy();

    static {
        zzoh zzoh = new zzoh();
        zzb = zzoh;
        zzsh.zzG(zzoh.class, zzoh);
    }

    private zzoh() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzoh();
        } else {
            if (i3 == 4) {
                return new zzog((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
