package com.google.android.gms.internal.ads;

public final class zzghy extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzghy zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;
    private zzgie zzf;

    static {
        zzghy zzghy = new zzghy();
        zzb = zzghy;
        zzgpm.zzaU(zzghy.class, zzghy);
    }

    private zzghy() {
    }

    public static zzghx zzc() {
        return (zzghx) zzb.zzaA();
    }

    public static zzghy zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzghy) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzj(zzghy zzghy, zzgie zzgie) {
        zzgie.getClass();
        zzghy.zzf = zzgie;
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
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzghy();
        } else {
            if (i3 == 4) {
                return new zzghx((zzghw) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgie zzf() {
        zzgie zzgie = this.zzf;
        return zzgie == null ? zzgie.zze() : zzgie;
    }

    public final zzgoe zzg() {
        return this.zze;
    }
}
