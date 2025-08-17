package com.google.android.gms.internal.ads;

public final class zzgiz extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgiz zzb;
    private zzgjc zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgiz zzgiz = new zzgiz();
        zzb = zzgiz;
        zzgpm.zzaU(zzgiz.class, zzgiz);
    }

    private zzgiz() {
    }

    public static zzgiy zzc() {
        return (zzgiy) zzb.zzaA();
    }

    public static zzgiz zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgiz) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzg(zzgiz zzgiz, zzgjc zzgjc) {
        zzgjc.getClass();
        zzgiz.zzd = zzgjc;
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
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgiz();
        } else {
            if (i3 == 4) {
                return new zzgiy((zzgix) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjc zzf() {
        zzgjc zzgjc = this.zzd;
        return zzgjc == null ? zzgjc.zze() : zzgjc;
    }
}
