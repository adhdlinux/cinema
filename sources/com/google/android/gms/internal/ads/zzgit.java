package com.google.android.gms.internal.ads;

public final class zzgit extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgit zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzgit zzgit = new zzgit();
        zzb = zzgit;
        zzgpm.zzaU(zzgit.class, zzgit);
    }

    private zzgit() {
    }

    public static zzgis zzc() {
        return (zzgis) zzb.zzaA();
    }

    public static zzgit zze() {
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
            return new zzgit();
        } else {
            if (i3 == 4) {
                return new zzgis((zzgir) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
