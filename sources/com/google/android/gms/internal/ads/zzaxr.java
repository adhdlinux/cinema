package com.google.android.gms.internal.ads;

public final class zzaxr extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaxr zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzaxr zzaxr = new zzaxr();
        zzb = zzaxr;
        zzgpm.zzaU(zzaxr.class, zzaxr);
    }

    private zzaxr() {
    }

    public static zzaxq zza() {
        return (zzaxq) zzb.zzaA();
    }

    public static zzaxr zzd() {
        return zzb;
    }

    static /* synthetic */ void zze(zzaxr zzaxr, boolean z2) {
        zzaxr.zzd |= 1;
        zzaxr.zze = z2;
    }

    static /* synthetic */ void zzf(zzaxr zzaxr, int i2) {
        zzaxr.zzd |= 2;
        zzaxr.zzf = i2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzaxr();
        } else {
            if (i3 == 4) {
                return new zzaxq((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
