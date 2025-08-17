package com.google.android.gms.internal.ads;

public final class zzgjl extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgjl zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;

    static {
        zzgjl zzgjl = new zzgjl();
        zzb = zzgjl;
        zzgpm.zzaU(zzgjl.class, zzgjl);
    }

    private zzgjl() {
    }

    public static zzgjk zzc() {
        return (zzgjk) zzb.zzaA();
    }

    public static zzgjl zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgjl) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgjl();
        } else {
            if (i3 == 4) {
                return new zzgjk((zzgjj) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgoe zzf() {
        return this.zze;
    }
}
