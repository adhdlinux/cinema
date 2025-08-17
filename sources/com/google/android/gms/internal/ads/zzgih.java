package com.google.android.gms.internal.ads;

public final class zzgih extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgih zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgin zze;
    private zzgjz zzf;

    static {
        zzgih zzgih = new zzgih();
        zzb = zzgih;
        zzgpm.zzaU(zzgih.class, zzgih);
    }

    private zzgih() {
    }

    public static zzgig zzc() {
        return (zzgig) zzb.zzaA();
    }

    public static zzgih zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgih) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzi(zzgih zzgih, zzgin zzgin) {
        zzgin.getClass();
        zzgih.zze = zzgin;
    }

    static /* synthetic */ void zzj(zzgih zzgih, zzgjz zzgjz) {
        zzgjz.getClass();
        zzgih.zzf = zzgjz;
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
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgih();
        } else {
            if (i3 == 4) {
                return new zzgig((zzgif) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgin zzf() {
        zzgin zzgin = this.zze;
        return zzgin == null ? zzgin.zze() : zzgin;
    }

    public final zzgjz zzg() {
        zzgjz zzgjz = this.zzf;
        return zzgjz == null ? zzgjz.zze() : zzgjz;
    }
}
