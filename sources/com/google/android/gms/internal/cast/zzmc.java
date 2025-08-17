package com.google.android.gms.internal.cast;

public final class zzmc extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmc zzb;
    private int zzd;
    private int zze;
    private double zzf;
    private double zzg;
    private double zzh;
    private double zzi;

    static {
        zzmc zzmc = new zzmc();
        zzb = zzmc;
        zzsh.zzG(zzmc.class, zzmc);
    }

    private zzmc() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဋ\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i3 == 3) {
            return new zzmc();
        } else {
            if (i3 == 4) {
                return new zzmb((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
