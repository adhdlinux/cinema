package com.google.android.gms.internal.ads;

public final class zzgjo extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgjo zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zzgjo zzgjo = new zzgjo();
        zzb = zzgjo;
        zzgpm.zzaU(zzgjo.class, zzgjo);
    }

    private zzgjo() {
    }

    public static zzgjn zzc() {
        return (zzgjn) zzb.zzaA();
    }

    public static zzgjo zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgjo) zzgpm.zzaG(zzb, zzgoe, zzgoy);
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
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        } else if (i3 == 3) {
            return new zzgjo();
        } else {
            if (i3 == 4) {
                return new zzgjn((zzgjm) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
