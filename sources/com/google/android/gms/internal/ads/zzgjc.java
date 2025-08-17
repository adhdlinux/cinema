package com.google.android.gms.internal.ads;

public final class zzgjc extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgjc zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzgjc zzgjc = new zzgjc();
        zzb = zzgjc;
        zzgpm.zzaU(zzgjc.class, zzgjc);
    }

    private zzgjc() {
    }

    public static zzgjb zzc() {
        return (zzgjb) zzb.zzaA();
    }

    public static zzgjc zze() {
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
            return new zzgjc();
        } else {
            if (i3 == 4) {
                return new zzgjb((zzgja) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
