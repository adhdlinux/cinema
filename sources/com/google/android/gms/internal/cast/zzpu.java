package com.google.android.gms.internal.cast;

public final class zzpu extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpu zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private zzpw zzh;

    static {
        zzpu zzpu = new zzpu();
        zzb = zzpu;
        zzsh.zzG(zzpu.class, zzpu);
    }

    private zzpu() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zzpu();
        } else {
            if (i3 == 4) {
                return new zzpt((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
