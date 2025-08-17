package com.google.android.gms.internal.ads;

public final class zzglo extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglo zzb;
    private String zzd = "";
    private zzgkp zze;

    static {
        zzglo zzglo = new zzglo();
        zzb = zzglo;
        zzgpm.zzaU(zzglo.class, zzglo);
    }

    private zzglo() {
    }

    public static zzglo zzd() {
        return zzb;
    }

    public static zzglo zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzglo) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    public final zzgkp zza() {
        zzgkp zzgkp = this.zze;
        return zzgkp == null ? zzgkp.zzd() : zzgkp;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzglo();
        } else {
            if (i3 == 4) {
                return new zzgln((zzglm) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze != null;
    }
}
