package com.google.android.gms.internal.ads;

public final class zzgik extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgik zzb;
    private zzgiq zzd;
    private zzgkc zze;

    static {
        zzgik zzgik = new zzgik();
        zzb = zzgik;
        zzgpm.zzaU(zzgik.class, zzgik);
    }

    private zzgik() {
    }

    public static zzgij zza() {
        return (zzgij) zzb.zzaA();
    }

    public static zzgik zzd(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgik) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzg(zzgik zzgik, zzgiq zzgiq) {
        zzgiq.getClass();
        zzgik.zzd = zzgiq;
    }

    static /* synthetic */ void zzh(zzgik zzgik, zzgkc zzgkc) {
        zzgkc.getClass();
        zzgik.zze = zzgkc;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgik();
        } else {
            if (i3 == 4) {
                return new zzgij((zzgii) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgiq zze() {
        zzgiq zzgiq = this.zzd;
        return zzgiq == null ? zzgiq.zze() : zzgiq;
    }

    public final zzgkc zzf() {
        zzgkc zzgkc = this.zze;
        return zzgkc == null ? zzgkc.zzf() : zzgkc;
    }
}
