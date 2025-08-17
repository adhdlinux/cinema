package com.google.android.gms.internal.ads;

public final class zzglf extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglf zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgli zze;

    static {
        zzglf zzglf = new zzglf();
        zzb = zzglf;
        zzgpm.zzaU(zzglf.class, zzglf);
    }

    private zzglf() {
    }

    public static zzgle zzc() {
        return (zzgle) zzb.zzaA();
    }

    public static zzglf zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzglf) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzh(zzglf zzglf, zzgli zzgli) {
        zzgli.getClass();
        zzglf.zze = zzgli;
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
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzglf();
        } else {
            if (i3 == 4) {
                return new zzgle((zzgld) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgli zzf() {
        zzgli zzgli = this.zze;
        return zzgli == null ? zzgli.zzc() : zzgli;
    }
}
