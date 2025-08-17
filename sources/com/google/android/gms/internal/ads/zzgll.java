package com.google.android.gms.internal.ads;

public final class zzgll extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgll zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzglo zze;

    static {
        zzgll zzgll = new zzgll();
        zzb = zzgll;
        zzgpm.zzaU(zzgll.class, zzgll);
    }

    private zzgll() {
    }

    public static zzglk zzc() {
        return (zzglk) zzb.zzaA();
    }

    public static zzgll zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgll) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzh(zzgll zzgll, zzglo zzglo) {
        zzglo.getClass();
        zzgll.zze = zzglo;
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
            return new zzgll();
        } else {
            if (i3 == 4) {
                return new zzglk((zzglj) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglo zzf() {
        zzglo zzglo = this.zze;
        return zzglo == null ? zzglo.zzd() : zzglo;
    }
}
