package com.google.android.gms.internal.ads;

public final class zzgjr extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgjr zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;

    static {
        zzgjr zzgjr = new zzgjr();
        zzb = zzgjr;
        zzgpm.zzaU(zzgjr.class, zzgjr);
    }

    private zzgjr() {
    }

    public static zzgjq zzc() {
        return (zzgjq) zzb.zzaA();
    }

    public static zzgjr zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgjr) zzgpm.zzaG(zzb, zzgoe, zzgoy);
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
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgjr();
        } else {
            if (i3 == 4) {
                return new zzgjq((zzgjp) null);
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
