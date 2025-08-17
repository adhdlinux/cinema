package com.google.android.gms.internal.ads;

public final class zzaxt extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaxt zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzaxt zzaxt = new zzaxt();
        zzb = zzaxt;
        zzgpm.zzaU(zzaxt.class, zzaxt);
    }

    private zzaxt() {
    }

    public static zzaxs zza() {
        return (zzaxs) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzaxt zzaxt, boolean z2) {
        zzaxt.zzd |= 1;
        zzaxt.zze = z2;
    }

    static /* synthetic */ void zze(zzaxt zzaxt, boolean z2) {
        zzaxt.zzd |= 2;
        zzaxt.zzf = z2;
    }

    static /* synthetic */ void zzf(zzaxt zzaxt, int i2) {
        zzaxt.zzd |= 4;
        zzaxt.zzg = i2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzaxt();
        } else {
            if (i3 == 4) {
                return new zzaxs((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
