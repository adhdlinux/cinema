package com.google.android.gms.internal.cast;

public final class zznt extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznt zzb;
    private int zzd;
    private zzsp zze = zzsh.zzz();
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;
    private long zzj;

    static {
        zznt zznt = new zznt();
        zzb = zznt;
        zzsh.zzG(zznt.class, zznt);
    }

    private zznt() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u0006ဂ\u0004", new Object[]{"zzd", "zze", zznl.class, "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i3 == 3) {
            return new zznt();
        } else {
            if (i3 == 4) {
                return new zzns((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
