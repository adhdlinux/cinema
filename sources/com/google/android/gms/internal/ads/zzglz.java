package com.google.android.gms.internal.ads;

public final class zzglz extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglz zzb;
    private int zzd;

    static {
        zzglz zzglz = new zzglz();
        zzb = zzglz;
        zzgpm.zzaU(zzglz.class, zzglz);
    }

    private zzglz() {
    }

    public static zzglz zzc() {
        return zzb;
    }

    public static zzglz zzd(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzglz) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        } else if (i3 == 3) {
            return new zzglz();
        } else {
            if (i3 == 4) {
                return new zzgly((zzglx) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
