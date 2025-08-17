package com.google.android.gms.internal.ads;

public final class zzazz extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzazz zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzazz zzazz = new zzazz();
        zzb = zzazz;
        zzgpm.zzaU(zzazz.class, zzazz);
    }

    private zzazz() {
    }

    public static zzazy zza() {
        return (zzazy) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzazz zzazz, int i2) {
        zzazz.zzd |= 1;
        zzazz.zze = i2;
    }

    static /* synthetic */ void zze(zzazz zzazz, int i2) {
        zzazz.zzd |= 2;
        zzazz.zzf = i2;
    }

    static /* synthetic */ void zzf(zzazz zzazz, int i2) {
        zzazz.zzd |= 4;
        zzazz.zzg = i2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzazz();
        } else {
            if (i3 == 4) {
                return new zzazy((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
