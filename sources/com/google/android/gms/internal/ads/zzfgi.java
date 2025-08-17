package com.google.android.gms.internal.ads;

public final class zzfgi extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzfgi zzb;
    private zzfge zzd;

    static {
        zzfgi zzfgi = new zzfgi();
        zzb = zzfgi;
        zzgpm.zzaU(zzfgi.class, zzfgi);
    }

    private zzfgi() {
    }

    public static zzfgh zza() {
        return (zzfgh) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzfgi zzfgi, zzfge zzfge) {
        zzfge.getClass();
        zzfgi.zzd = zzfge;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0006\u0006\u0001\u0000\u0000\u0000\u0006\t", new Object[]{"zzd"});
        } else if (i3 == 3) {
            return new zzfgi();
        } else {
            if (i3 == 4) {
                return new zzfgh((zzfgf) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
