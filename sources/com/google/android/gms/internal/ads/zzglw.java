package com.google.android.gms.internal.ads;

public final class zzglw extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglw zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;

    static {
        zzglw zzglw = new zzglw();
        zzb = zzglw;
        zzgpm.zzaU(zzglw.class, zzglw);
    }

    private zzglw() {
    }

    public static zzglv zzc() {
        return (zzglv) zzb.zzaA();
    }

    public static zzglw zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzglw) zzgpm.zzaG(zzb, zzgoe, zzgoy);
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
            return new zzglw();
        } else {
            if (i3 == 4) {
                return new zzglv((zzglu) null);
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
