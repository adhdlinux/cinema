package com.google.android.gms.internal.ads;

public final class zzgib extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgib zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgie zze;

    static {
        zzgib zzgib = new zzgib();
        zzb = zzgib;
        zzgpm.zzaU(zzgib.class, zzgib);
    }

    private zzgib() {
    }

    public static zzgia zzc() {
        return (zzgia) zzb.zzaA();
    }

    public static zzgib zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgib) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzh(zzgib zzgib, zzgie zzgie) {
        zzgie.getClass();
        zzgib.zze = zzgie;
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
            return new zzgib();
        } else {
            if (i3 == 4) {
                return new zzgia((zzghz) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgie zzf() {
        zzgie zzgie = this.zze;
        return zzgie == null ? zzgie.zze() : zzgie;
    }
}
