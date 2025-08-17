package com.google.android.gms.internal.ads;

public final class zzgju extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgju zzb;

    static {
        zzgju zzgju = new zzgju();
        zzb = zzgju;
        zzgpm.zzaU(zzgju.class, zzgju);
    }

    private zzgju() {
    }

    public static zzgju zzc() {
        return zzb;
    }

    public static zzgju zzd(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgju) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i3 == 3) {
            return new zzgju();
        }
        if (i3 == 4) {
            return new zzgjt((zzgjs) null);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
