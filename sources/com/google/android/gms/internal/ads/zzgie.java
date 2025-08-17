package com.google.android.gms.internal.ads;

public final class zzgie extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgie zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzgie zzgie = new zzgie();
        zzb = zzgie;
        zzgpm.zzaU(zzgie.class, zzgie);
    }

    private zzgie() {
    }

    public static zzgid zzc() {
        return (zzgid) zzb.zzaA();
    }

    public static zzgie zze() {
        return zzb;
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
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        } else if (i3 == 3) {
            return new zzgie();
        } else {
            if (i3 == 4) {
                return new zzgid((zzgic) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
