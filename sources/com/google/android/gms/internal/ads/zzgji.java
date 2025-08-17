package com.google.android.gms.internal.ads;

public final class zzgji extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgji zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zzgji zzgji = new zzgji();
        zzb = zzgji;
        zzgpm.zzaU(zzgji.class, zzgji);
    }

    private zzgji() {
    }

    public static zzgjh zzc() {
        return (zzgjh) zzb.zzaA();
    }

    public static zzgji zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgji) zzgpm.zzaG(zzb, zzgoe, zzgoy);
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
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgji();
        } else {
            if (i3 == 4) {
                return new zzgjh((zzgjg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
