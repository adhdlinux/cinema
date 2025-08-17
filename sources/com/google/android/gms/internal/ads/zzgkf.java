package com.google.android.gms.internal.ads;

public final class zzgkf extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgkf zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgkf zzgkf = new zzgkf();
        zzb = zzgkf;
        zzgpm.zzaU(zzgkf.class, zzgkf);
    }

    private zzgkf() {
    }

    public static zzgke zzc() {
        return (zzgke) zzb.zzaA();
    }

    public static zzgkf zze() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgkf();
        } else {
            if (i3 == 4) {
                return new zzgke((zzgkd) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzg() {
        int i2 = this.zzd;
        int i3 = 2;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 3;
            } else if (i2 != 2) {
                i3 = 5;
                if (i2 != 3) {
                    i3 = i2 != 4 ? i2 != 5 ? 0 : 7 : 6;
                }
            } else {
                i3 = 4;
            }
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
