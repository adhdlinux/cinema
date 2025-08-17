package com.google.android.gms.internal.ads;

public final class zzgiq extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgiq zzb;
    private zzgit zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgiq zzgiq = new zzgiq();
        zzb = zzgiq;
        zzgpm.zzaU(zzgiq.class, zzgiq);
    }

    private zzgiq() {
    }

    public static zzgip zzc() {
        return (zzgip) zzb.zzaA();
    }

    public static zzgiq zze() {
        return zzb;
    }

    public static zzgiq zzf(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgiq) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzh(zzgiq zzgiq, zzgit zzgit) {
        zzgit.getClass();
        zzgiq.zzd = zzgit;
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
            return new zzgiq();
        } else {
            if (i3 == 4) {
                return new zzgip((zzgio) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgit zzg() {
        zzgit zzgit = this.zzd;
        return zzgit == null ? zzgit.zze() : zzgit;
    }
}
