package com.google.android.gms.internal.ads;

public final class zzgli extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgli zzb;
    private String zzd = "";

    static {
        zzgli zzgli = new zzgli();
        zzb = zzgli;
        zzgpm.zzaU(zzgli.class, zzgli);
    }

    private zzgli() {
    }

    public static zzgli zzc() {
        return zzb;
    }

    public static zzgli zzd(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgli) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        } else if (i3 == 3) {
            return new zzgli();
        } else {
            if (i3 == 4) {
                return new zzglh((zzglg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zze() {
        return this.zzd;
    }
}
