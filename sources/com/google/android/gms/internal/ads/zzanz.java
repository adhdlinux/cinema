package com.google.android.gms.internal.ads;

public final class zzanz extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzanz zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzanz zzanz = new zzanz();
        zzb = zzanz;
        zzgpm.zzaU(zzanz.class, zzanz);
    }

    private zzanz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzgpq zzgpq = zzaot.zza;
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", zzgpq, "zzg", zzgpq});
        } else if (i3 == 3) {
            return new zzanz();
        } else {
            if (i3 == 4) {
                return new zzany((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
