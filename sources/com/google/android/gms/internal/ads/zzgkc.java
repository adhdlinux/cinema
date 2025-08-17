package com.google.android.gms.internal.ads;

public final class zzgkc extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgkc zzb;
    private zzgkf zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgkc zzgkc = new zzgkc();
        zzb = zzgkc;
        zzgpm.zzaU(zzgkc.class, zzgkc);
    }

    private zzgkc() {
    }

    public static zzgkb zzd() {
        return (zzgkb) zzb.zzaA();
    }

    public static zzgkc zzf() {
        return zzb;
    }

    public static zzgkc zzg(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgkc) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzi(zzgkc zzgkc, zzgkf zzgkf) {
        zzgkf.getClass();
        zzgkc.zzd = zzgkf;
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
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgkc();
        } else {
            if (i3 == 4) {
                return new zzgkb((zzgka) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzc() {
        return this.zzf;
    }

    public final zzgkf zzh() {
        zzgkf zzgkf = this.zzd;
        return zzgkf == null ? zzgkf.zze() : zzgkf;
    }
}
