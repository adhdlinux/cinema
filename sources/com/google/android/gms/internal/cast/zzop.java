package com.google.android.gms.internal.cast;

public final class zzop extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzop zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private String zzh = "";
    private int zzi;
    private int zzj;
    private String zzk = "";

    static {
        zzop zzop = new zzop();
        zzb = zzop;
        zzsh.zzG(zzop.class, zzop);
    }

    private zzop() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i3 == 3) {
            return new zzop();
        } else {
            if (i3 == 4) {
                return new zzoo((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
