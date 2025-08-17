package com.google.android.gms.internal.ads;

public final class zzatm extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzatm zzb;
    private int zzd;
    private zzatp zze;
    private zzgoe zzf;
    private zzgoe zzg;

    static {
        zzatm zzatm = new zzatm();
        zzb = zzatm;
        zzgpm.zzaU(zzatm.class, zzatm);
    }

    private zzatm() {
        zzgoe zzgoe = zzgoe.zzb;
        this.zzf = zzgoe;
        this.zzg = zzgoe;
    }

    public static zzatm zzc(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzatm) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzatm();
        } else {
            if (i3 == 4) {
                return new zzatl((zzatk) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzatp zzd() {
        zzatp zzatp = this.zze;
        return zzatp == null ? zzatp.zzg() : zzatp;
    }

    public final zzgoe zze() {
        return this.zzg;
    }

    public final zzgoe zzf() {
        return this.zzf;
    }
}
