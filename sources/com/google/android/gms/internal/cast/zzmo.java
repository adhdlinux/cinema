package com.google.android.gms.internal.cast;

public final class zzmo extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        zzmo zzmo = new zzmo();
        zzb = zzmo;
        zzsh.zzG(zzmo.class, zzmo);
    }

    private zzmo() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzka.zza(), "zzf", zzju.zza(), "zzg", zzjx.zza(), "zzh", "zzi"});
        } else if (i3 == 3) {
            return new zzmo();
        } else {
            if (i3 == 4) {
                return new zzmn((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
