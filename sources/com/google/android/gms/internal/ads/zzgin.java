package com.google.android.gms.internal.ads;

public final class zzgin extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgin zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgit zze;
    /* access modifiers changed from: private */
    public zzgoe zzf = zzgoe.zzb;

    static {
        zzgin zzgin = new zzgin();
        zzb = zzgin;
        zzgpm.zzaU(zzgin.class, zzgin);
    }

    private zzgin() {
    }

    public static zzgim zzc() {
        return (zzgim) zzb.zzaA();
    }

    public static zzgin zze() {
        return zzb;
    }

    public static zzgin zzf(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgin) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzj(zzgin zzgin, zzgit zzgit) {
        zzgit.getClass();
        zzgin.zze = zzgit;
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
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgin();
        } else {
            if (i3 == 4) {
                return new zzgim((zzgil) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgit zzg() {
        zzgit zzgit = this.zze;
        return zzgit == null ? zzgit.zze() : zzgit;
    }

    public final zzgoe zzh() {
        return this.zzf;
    }
}
