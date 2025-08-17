package com.google.android.gms.internal.ads;

public final class zzaxn extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaxn zzb;
    private int zzd;
    private int zze;
    private zzaxr zzf;
    private zzaxt zzg;

    static {
        zzaxn zzaxn = new zzaxn();
        zzb = zzaxn;
        zzgpm.zzaU(zzaxn.class, zzaxn);
    }

    private zzaxn() {
    }

    public static zzaxm zza() {
        return (zzaxm) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzaxn zzaxn, zzaxr zzaxr) {
        zzaxr.getClass();
        zzaxn.zzf = zzaxr;
        zzaxn.zzd |= 2;
    }

    static /* synthetic */ void zze(zzaxn zzaxn, zzaxt zzaxt) {
        zzaxt.getClass();
        zzaxn.zzg = zzaxt;
        zzaxn.zzd |= 4;
    }

    static /* synthetic */ void zzf(zzaxn zzaxn, int i2) {
        zzaxn.zze = 1;
        zzaxn.zzd = 1 | zzaxn.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzaxp.zza, "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzaxn();
        } else {
            if (i3 == 4) {
                return new zzaxm((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
