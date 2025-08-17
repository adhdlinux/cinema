package com.google.android.gms.internal.ads;

public final class zzanl extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzanl zzb;
    private int zzd;
    private int zze = 2;

    static {
        zzanl zzanl = new zzanl();
        zzb = zzanl;
        zzgpm.zzaU(zzanl.class, zzanl);
    }

    private zzanl() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzd", "zze", zzanm.zza});
        } else if (i3 == 3) {
            return new zzanl();
        } else {
            if (i3 == 4) {
                return new zzank((zzanh) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
