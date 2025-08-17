package com.google.android.gms.internal.ads;

public final class zzgjf extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgjf zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;

    static {
        zzgjf zzgjf = new zzgjf();
        zzb = zzgjf;
        zzgpm.zzaU(zzgjf.class, zzgjf);
    }

    private zzgjf() {
    }

    public static zzgje zzc() {
        return (zzgje) zzb.zzaA();
    }

    public static zzgjf zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgjf) zzgpm.zzaG(zzb, zzgoe, zzgoy);
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
            return new zzgjf();
        } else {
            if (i3 == 4) {
                return new zzgje((zzgjd) null);
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
