package com.google.android.gms.internal.ads;

public final class zzgjz extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgjz zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgkf zze;
    /* access modifiers changed from: private */
    public zzgoe zzf = zzgoe.zzb;

    static {
        zzgjz zzgjz = new zzgjz();
        zzb = zzgjz;
        zzgpm.zzaU(zzgjz.class, zzgjz);
    }

    private zzgjz() {
    }

    public static zzgjy zzc() {
        return (zzgjy) zzb.zzaA();
    }

    public static zzgjz zze() {
        return zzb;
    }

    public static zzgjz zzf(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgjz) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzj(zzgjz zzgjz, zzgkf zzgkf) {
        zzgkf.getClass();
        zzgjz.zze = zzgkf;
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
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgjz();
        } else {
            if (i3 == 4) {
                return new zzgjy((zzgjx) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkf zzg() {
        zzgkf zzgkf = this.zze;
        return zzgkf == null ? zzgkf.zze() : zzgkf;
    }

    public final zzgoe zzh() {
        return this.zzf;
    }
}
